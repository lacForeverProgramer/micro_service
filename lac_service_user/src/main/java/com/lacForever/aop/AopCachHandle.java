package com.lacForever.aop;


import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.lacForever.annotation.Cach;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Liujiahao
 * @Date: 19-1-21 下午3:28
 */
@Aspect
@Component
public class AopCachHandle {

    private static Logger logger = Logger.getLogger(AopCachHandle.class);

    @Autowired
    private RedisTemplate redisTemplate;
    @Pointcut(value = "@annotation(com.lacForever.annotation.Cach)")
    public void pointcut(){}

    @Around(value = "pointcut() && @annotation(cach)")
    public Object around(ProceedingJoinPoint point, Cach cach){
        Method method = getMethod(point);
        //根据类名、方法名和参数生成key
        final String key = parseKey(cach.key(), method, point.getArgs());
            Object obj = redisTemplate.opsForValue().get(key);
        if(null == obj){
           logger.info("<============ redis 中不存在该记录 从数据库查找=============>");
            try {
                obj = point.proceed();
                if(obj !=null){
                    if(cach.expire()>0){
                        redisTemplate.opsForValue().set(key,obj,cach.expire(),TimeUnit.SECONDS);
                    }else{
                        redisTemplate.opsForValue().set(key,obj);
                    }
                }
            } catch (Throwable throwable) {
                logger.error("<======================cach 执行异常:{}============================>",throwable);
            }
            return obj;
        }
        return obj;
    }
    /**
      * 获取被拦截方法对象
      * MethodSignature.getMethod() 获取的是顶层接口或者父类的方法对象
      * 而缓存的注解在实现类的方法上
      * 所以应该使用反射获取当前对象的方法对象
      */
            private Method getMethod(ProceedingJoinPoint pjp) {
        //获取参数的类型
        Class[] argTypes = ((MethodSignature) pjp.getSignature()).getParameterTypes();
        Method method = null;
        try {
            method = pjp.getTarget().getClass().getMethod(pjp.getSignature().getName(), argTypes);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return method;
    }
    private String parseKey(String key, Method method, Object[] args) {
        if (StringUtils.isEmpty(key)) {
            return method.getName();
        }
        //获得被拦截方法参数列表
        LocalVariableTableParameterNameDiscoverer nd = new LocalVariableTableParameterNameDiscoverer();
        String[] parameterNames = nd.getParameterNames(method);
        for (int i = 0; i < parameterNames.length; i++) {
            key = key.replace(parameterNames[i] + "", args[i] + "");
        }
        return method.getName() +"_"+ key;
    }
}

package com.lacForever.annotation;

import java.lang.annotation.*;

/**
 * @Author: Liujiahao
 * @Date: 19-1-21 下午3:18
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Cach {
    String key() default "";
    Class type();
    //默认缓存时间一天
    long expire() default 60*60*24L;
}

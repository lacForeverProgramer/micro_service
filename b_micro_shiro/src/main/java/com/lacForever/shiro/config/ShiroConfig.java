package com.lacForever.shiro.config;

import com.lacForever.shiro.EnceladusShiroRealm;
import com.lacForever.shiro.PasswordHelper;
import com.lacForever.shiro.filter.CaptchaFormAuthenticationFilter;
import com.lacForever.shiro.filter.Llll;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: Liujiahao
 * @Date: 19-3-26 下午6:47
 */
@Configuration
public class ShiroConfig {


    public CaptchaFormAuthenticationFilter corsAuthenticationFilter(){
        return new CaptchaFormAuthenticationFilter();
    }

    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        Map<String, String> filterChainDefinitionMap = new HashMap<String, String>();
//        shiroFilterFactoryBean.setLoginUrl("login.html");

//        shiroFilterFactoryBean.setUnauthorizedUrl("/v1/unauthc");
        //        filterChainDefinitionMap.put("/v1/authc/renewable", "perms[Create,Update,Retrieve]");
//        shiroFilterFactoryBean.setSuccessUrl("/v1/home/index");
//        filterChainDefinitionMap.put("/v1/authc/index", "authc");
//        filterChainDefinitionMap.put("/v1/authc/index", "authc");
//        filterChainDefinitionMap.put("/v1/login", "anon");
//        filterChainDefinitionMap.put("/v1/authc/**", "authc");
        filterChainDefinitionMap.put("/v1/authc/admin", "roles[admin]");


        //自定义过滤器
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("authc", new CaptchaFormAuthenticationFilter());//登录权限
        filterMap.put("roles",new Llll());//角色权限
        shiroFilterFactoryBean.setFilters(filterMap);

        return shiroFilterFactoryBean;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName(PasswordHelper.ALGORITHM_NAME); // 散列算法
        hashedCredentialsMatcher.setHashIterations(PasswordHelper.HASH_ITERATIONS); // 散列次数
        return hashedCredentialsMatcher;
    }

    @Bean
    public EnceladusShiroRealm shiroRealm() {
        EnceladusShiroRealm shiroRealm = new EnceladusShiroRealm();
        shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher()); // 原来在这里
        return shiroRealm;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm());
        return securityManager;
    }

    @Bean
    public PasswordHelper passwordHelper() {
        return new PasswordHelper();
    }
}

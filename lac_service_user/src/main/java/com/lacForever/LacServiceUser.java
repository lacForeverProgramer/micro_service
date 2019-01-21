package com.lacForever;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.lacForever.dao")
@EnableCaching
public class LacServiceUser
{
    public static void main(String [] args){
        SpringApplication.run(LacServiceUser.class,args);
    }
}

package com.lacForever;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.lacForever.dao")
public class LacServiceUser
{
    public static void main(String [] args){
        SpringApplication.run(LacServiceUser.class,args);
    }
}

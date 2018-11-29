package com.lacForever.controller;

import com.lacForever.config.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Liujiahao
 * @Date: 18-11-29 下午6:37
 */
@RestController
public class TestController {

    @Autowired
    TestConfig config;


    @GetMapping(value = "/test")
    public String sayHello(){
        return config.getWriter();
    }
}

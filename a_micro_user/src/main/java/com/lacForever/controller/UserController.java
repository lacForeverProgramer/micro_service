package com.lacForever.controller;

import com.lacForever.bena.Ok;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Liujiahao
 * @Date: 19-3-20 下午6:26
 */
@RestController
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private Ok ok;

    @GetMapping("/")
    public String getName(){
        logger.info("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
        return ok.getName()+"ssss";
    }
}

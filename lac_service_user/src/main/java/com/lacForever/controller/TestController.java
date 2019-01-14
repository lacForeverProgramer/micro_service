package com.lacForever.controller;

import com.lacForever.dao.LcUserMapper;
import com.lacForever.model.LcUser;
import com.lacForever.response.ResponseMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.logging.Logger;

/**
 * @Author: Liujiahao
 * @Date: 18-11-29 下午6:37
 */
@RestController
public class TestController {

    @Autowired
    public LcUserMapper mapper;

    @GetMapping(value = "/test")
    public Map sayHello(){
      Map okMap =  ResponseMap.getInstance().getOKMap();
        LcUser user = mapper.selectByPrimaryKey(1);
        okMap.put("info",user);
        return okMap;
    }
}

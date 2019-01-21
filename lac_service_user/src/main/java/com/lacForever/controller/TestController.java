package com.lacForever.controller;

import com.alibaba.fastjson.JSON;
import com.lacForever.annotation.Cach;
import com.lacForever.dao.LcUserMapper;
import com.lacForever.model.LcUser;
import com.lacForever.response.ResponseMap;
import com.lacForever.service.TheThirdPartyService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Liujiahao
 * @Date: 18-11-29 下午6:37
 */
@RestController
public class TestController {

    private static Logger logger = Logger.getLogger(TestController.class);

    @Autowired
    private LcUserMapper mapper;
    @Autowired
    private TheThirdPartyService theThirdPartyService;

    @GetMapping(value = "/test")
    @Cach(key = "user",type = Map.class,expire = 20*60*60*24L)
    public Map sayHello(){
        logger.info("this is info");
      Map okMap =  ResponseMap.getInstance().getOKMap();
        LcUser user = mapper.selectByPrimaryKey(1);
        okMap.put("info",user);
        return okMap;
    }

    @GetMapping(value = "/testPost")
    public Map getEmotion(){
        Map okMap = ResponseMap.getInstance().getOKMap();
      JSON json = (JSON) JSON.parse(theThirdPartyService.getAuth());
       okMap.put("info",json);
        return okMap;
    }

    public static void main(String  [] args){
        Map map = new HashMap();
        map.put("sss","ssss");
        System.out.println(map.get("sffff"));
    }
}

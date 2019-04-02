package com.lacForever.bena;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Author: Liujiahao
 * @Date: 19-3-20 下午6:51
 */
@Component
@ConfigurationProperties(prefix = "user")
public class Ok {
    private String name = "刘家豪";

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

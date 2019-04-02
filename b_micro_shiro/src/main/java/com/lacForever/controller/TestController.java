package com.lacForever.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lacForever.entity.User;
import com.lacForever.service.UserService;
import com.lacForever.shiro.PasswordHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Liujiahao
 * @Date: 19-3-26 下午6:18
 */
@RestController
@RequestMapping("v1/")
public class TestController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordHelper passwordHelper;


    @GetMapping("login")
    public Object login() {
        return "Here is Login page";
    }

    @GetMapping("unauthc")
    public Object unauthc() {
        return "Here is Unauthc page";
    }

    @GetMapping("doLogin")
    public Object doLogin(@RequestParam String username, @RequestParam String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (IncorrectCredentialsException ice) {
            return "password error!";
        } catch (UnknownAccountException uae) {
            return "username error!";
        }

        User user = userService.findUserByName(username);
        subject.getSession().setAttribute("user", user);
        return user.toString()+"成功ign";
    }

    @GetMapping("register")
    public Object register(@RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        passwordHelper.encryptPassword(user);

        userService.saveUser(user);
        return "SUCCESS";
    }

    @GetMapping("/authc/index")
    public String goIndex(){
        return "index页面";
    }

    @GetMapping("/authc/admin")
    public String lll(){
        return "admin";
    }

    @GetMapping("/authc/renewable")
    public String getrenewable(){
        return "renewable";
    }
}

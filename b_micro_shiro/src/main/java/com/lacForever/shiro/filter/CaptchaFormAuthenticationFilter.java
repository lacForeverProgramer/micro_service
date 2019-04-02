package com.lacForever.shiro.filter;

import jdk.nashorn.internal.parser.JSONParser;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Liujiahao
 * @Date: 19-4-1 下午7:11
 * 处理登录失败 覆盖shiro 重定向 修改为返回前端json
 */
public class CaptchaFormAuthenticationFilter extends FormAuthenticationFilter {

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse res = (HttpServletResponse)response;
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setStatus(HttpServletResponse.SC_OK);
        res.setCharacterEncoding("UTF-8");
        PrintWriter writer = res.getWriter();
        Map<String, Object> map= new HashMap<>();
        map.put("code", 702);
        map.put("msg", "未登录");
        writer.write(map.toString());
        writer.close();
        return false;
    }
}

package com.lacForever.shiro.filter;

import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @Author: Liujiahao
 * @Date: 19-4-2 下午4:57
 */
public class Llll extends RolesAuthorizationFilter{

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
        System.out.println("没有权限!");
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        System.out.println("***********jinlaile************");
        return super.onAccessDenied(request, response);
    }
}

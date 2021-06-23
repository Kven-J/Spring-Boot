package com.tylor.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String loginUser = (String) request.getSession().getAttribute("loginUser");
        if (!StringUtils.hasLength(loginUser)) {
            request.setAttribute("msg", "未获取权限，请先登录！");
            request.getRequestDispatcher("/").forward(request, response);
            return false;
        }
        return true;
    }
}

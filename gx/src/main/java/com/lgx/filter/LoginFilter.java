package com.lgx.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lgx.common.Constants;
import com.lgx.model.User;

public class LoginFilter implements Filter {

   
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
            FilterChain chain) throws IOException, ServletException {
        // 获得在下面代码中要用的request,response,session
        HttpServletRequest servletRequest = (HttpServletRequest) req;
        HttpServletResponse servletResponse = (HttpServletResponse) resp;
        HttpSession session = servletRequest.getSession();
        //项目名  /gx
        String contextPath = servletRequest.getContextPath();
        //访问url 例：/index
        String servletPath = servletRequest.getServletPath();
        
       /* //取当前登录的用户
        User user = null;
        if (session != null) {
            user = (User) session.getAttribute(Constants.USER);
        }
        //过滤操作
        //会话或者用户为空时 跳转到登录页面
        if(session == null || user == null){
            servletResponse.sendRedirect("/index");
        }*/
        chain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

}

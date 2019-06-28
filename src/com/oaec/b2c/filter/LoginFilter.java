package com.oaec.b2c.filter;

import com.oaec.b2c.util.HttpFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/cart","/add2cart","/cart/delete","/updateQuantity","/order","/checkout","/submit"})
public class LoginFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //判断用户是否登录
        HttpSession session = request.getSession();
        if(session.getAttribute("user") == null){
            //没有登录，重定向到登录页面
            response.sendRedirect(request.getContextPath()+"/login");
            return;
        }
        //放行
        filterChain.doFilter(request,response);
    }
}

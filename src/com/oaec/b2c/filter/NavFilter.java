package com.oaec.b2c.filter;

import com.oaec.b2c.service.NavService;
import com.oaec.b2c.service.impl.NavServiceImpl;
import com.oaec.b2c.util.HttpFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebFilter({"/index","/list","/product","/login","/cart","/order","/checkout"})
public class NavFilter extends HttpFilter {

    private NavService navService = new NavServiceImpl();

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //查询导航中需要的分类
        List<Map<String, Object>> nav = navService.getNav();
        //将查询到的nav存放在request中
        request.setAttribute("nav",nav);
        filterChain.doFilter(request,response);
    }
}

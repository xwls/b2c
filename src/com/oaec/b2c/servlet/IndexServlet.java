package com.oaec.b2c.servlet;

import com.oaec.b2c.service.NavService;
import com.oaec.b2c.service.impl.NavServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    //依赖业务层
//    private NavService navService = new NavServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询导航中需要的分类
//        List<Map<String, Object>> nav = navService.getNav();
        //将查询到的nav存放在request中
//        req.setAttribute("nav",nav);
        //转发到index.jsp
        req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req,resp);
    }
}

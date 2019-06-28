package com.oaec.b2c.servlet;

import com.alibaba.fastjson.JSON;
import com.oaec.b2c.service.UserService;
import com.oaec.b2c.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Map<String, Object> map = userService.login(username, password);
        //设置contentType
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        if(map.containsKey("error")){
            //登录失败
            writer.println(JSON.toJSONString(map));
        }else{
            //登录成功，将用户信息存入session
            req.getSession().setAttribute("user",map);
            writer.println("{\"success\":true}");
        }
        writer.close();
    }
}

package com.oaec.b2c.servlet;

import com.oaec.b2c.service.OrderService;
import com.oaec.b2c.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/submit")
public class SubmitServlet extends HttpServlet {

    private OrderService orderService = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户编号
        HttpSession session = req.getSession();
        Map<String,Object> user = (Map<String, Object>) session.getAttribute("user");
        int userId = Integer.parseInt(user.get("user_id").toString());
        //获取地址编号
        String aid = req.getParameter("aid");
        //获取要结算的商品编号
        String[] pids = req.getParameterValues("pid");
        boolean submit = orderService.submit(userId, Integer.parseInt(aid), pids);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("{\"success\":"+submit+"}");
        writer.close();
    }
}

package com.oaec.b2c.servlet;

import com.oaec.b2c.service.CartService;
import com.oaec.b2c.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/cart/delete")
public class DeleteCartServlet extends HttpServlet {

    private CartService cartService = new CartServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户编号
        HttpSession session = req.getSession();
        Map<String,Object> user = (Map<String, Object>) session.getAttribute("user");
        int userId = Integer.parseInt(user.get("user_id").toString());
        //获取商品编号
        Integer productId = Integer.parseInt(req.getParameter("productId"));
        boolean delete = cartService.delete(userId, productId);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("{\"success\":"+delete+"}");
        writer.close();
    }
}

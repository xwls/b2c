package com.oaec.b2c.servlet;

import com.oaec.b2c.service.AddressService;
import com.oaec.b2c.service.CartService;
import com.oaec.b2c.service.impl.AddressServiceImpl;
import com.oaec.b2c.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    private AddressService addressService = new AddressServiceImpl();
    private CartService cartService = new CartServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取用户编号
        HttpSession session = req.getSession();
        Map<String, Object> user = (Map<String, Object>) session.getAttribute("user");
        int userId = Integer.parseInt(user.get("user_id").toString());
        String[] pids = req.getParameterValues("pid");
        //查询收货地址
        List<Map<String, Object>> addressList = addressService.getAddress(userId);
        //查询要结算的商品
        List<Map<String, Object>> productList = cartService.getProducts4Checkout(userId, pids);
        //查询统计
        Map<String, Object> total = cartService.getTotal(userId, pids);
        //将数据存储在request中
        req.setAttribute("addressList",addressList);
        req.setAttribute("productList",productList);
        req.setAttribute("total",total);
        System.out.println(addressList);
        System.out.println(productList);
        System.out.println(total);
        req.getRequestDispatcher("/WEB-INF/views/checkout.jsp").forward(req,resp);
    }
}

package com.oaec.b2c.servlet;

import com.alibaba.fastjson.JSON;
import com.oaec.b2c.service.ProductService;
import com.oaec.b2c.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    private ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数、
        String pid = req.getParameter("pid");
        //调用业务层方法查询商品
        Map<String, Object> product = productService.getProduct(pid);
        System.out.println(JSON.toJSONString(product));
        //将查询到的商品存入request中
        req.setAttribute("product",product);
        req.getRequestDispatcher("/WEB-INF/views/product.jsp").forward(req,resp);
    }
}

package com.oaec.b2c.test;

import com.oaec.b2c.dao.impl.ProductDaoImpl;
import com.oaec.b2c.service.impl.OrderServiceImpl;

import java.util.List;
import java.util.Map;

public class HelloWorld {

    public static void main(String[] args) {
        ProductDaoImpl productDao = new ProductDaoImpl();
        int countAll = productDao.getCountAll();
        System.out.println("countAll = " + countAll);
        int pageSize = 5;
        double pageNum = Math.ceil((double)countAll / pageSize);
        System.out.println("pageNum = " + pageNum);
    }
}

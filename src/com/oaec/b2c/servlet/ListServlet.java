package com.oaec.b2c.servlet;

import com.oaec.b2c.dao.ProductDao;
import com.oaec.b2c.service.BrandService;
import com.oaec.b2c.service.NavService;
import com.oaec.b2c.service.ProductService;
import com.oaec.b2c.service.impl.BrandServiceImpl;
import com.oaec.b2c.service.impl.NavServiceImpl;
import com.oaec.b2c.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/list")
public class ListServlet extends HttpServlet {

    private ProductService productService = new ProductServiceImpl();
//    private NavService navService = new NavServiceImpl();
    private BrandService brandService = new BrandServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String name = req.getParameter("name");
        String cid = req.getParameter("cid");
        String bid = req.getParameter("bid");
        String page = req.getParameter("page");
        if (page == null){
            page = "1";
        }
        req.setAttribute("page",page);
        //查询商品
//        List<Map<String, Object>> list = productService.query(name,cid,bid);
        List<Map<String, Object>> list = productService.query(name,cid,bid,Integer.parseInt(page));
        int count = productService.getCount(name, cid, bid);
        //一共需要的页数
        double pageNum = Math.ceil((double)count / ProductDao.PAGE_SIZE);
        //将查询到的商品存放在request中
        req.setAttribute("list",list);
        req.setAttribute("pageNum",pageNum);
        //查询导航中需要的分类
//        List<Map<String, Object>> nav = navService.getNav();
        //将查询到的nav存放在request中
//        req.setAttribute("nav",nav);
        //查询品牌
        List<Map<String, Object>> brands = brandService.query(cid);
        //将查询到的品牌存入request中
        req.setAttribute("brands",brands);
        //转发到list.jsp
        req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req,resp);
    }
}

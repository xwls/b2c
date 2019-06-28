package com.oaec.b2c.service.impl;

import com.oaec.b2c.dao.BrandDao;
import com.oaec.b2c.dao.CategoryDao;
import com.oaec.b2c.dao.ProductDao;
import com.oaec.b2c.dao.impl.BrandDaoImpl;
import com.oaec.b2c.dao.impl.CategoryDaoImpl;
import com.oaec.b2c.dao.impl.ProductDaoImpl;
import com.oaec.b2c.service.ProductService;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao = new ProductDaoImpl();
    private BrandDao brandDao = new BrandDaoImpl();
    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Map<String, Object>> query(String name, String cid, String bid) {
        if(bid != null && cid != null){
            return productDao.queryByBidAndCid(Integer.parseInt(bid), Integer.parseInt(cid));
        }
        if(cid != null){
            return productDao.queryByCid(Integer.parseInt(cid));
        }
        if(bid != null){
            return productDao.queryByBid(Integer.parseInt(bid));
        }
        if(name == null){
            return productDao.queryAll();
        }else {
            return productDao.queryLike(name);
        }
    }

    @Override
    public List<Map<String, Object>> query(String name, String cid, String bid, int page) {
        if(bid != null && cid != null){
            return productDao.queryByBidAndCid(Integer.parseInt(bid), Integer.parseInt(cid));
        }
        if(cid != null){
            return productDao.queryByCid(Integer.parseInt(cid));
        }
        if(bid != null){
            return productDao.queryByBid(Integer.parseInt(bid));
        }
        if(name == null){
            return productDao.queryAll(page);
        }else {
            return productDao.queryLike(name);
        }
    }

    @Override
    public int getCount(String name, String cid, String bid) {
        if(bid != null && cid != null){
           return  0;
        }
        if(cid != null){
            return 0;
        }
        if(bid != null){
            return 0;
        }
        if(name == null){
            return productDao.getCountAll();
        }else {
            return 0;
        }
    }

    @Override
    public Map<String, Object> getProduct(String pid) {
        Map<String, Object> product = productDao.queryByPid(Integer.parseInt(pid));
        //获取品牌编号
        Integer bid = Integer.parseInt(product.get("bid").toString());
        //获取分类编号
        Integer cid = Integer.parseInt(product.get("cid").toString());
        //查询品牌
        Map<String, Object> brand = brandDao.queryByBid(bid);
        //查询分类
        Map<String, Object> category = categoryDao.queryByCid(cid);
        product.put("brand",brand);
        product.put("category",category);
        return product;
    }
}

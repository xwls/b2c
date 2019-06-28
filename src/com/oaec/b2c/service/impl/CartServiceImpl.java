package com.oaec.b2c.service.impl;

import com.oaec.b2c.dao.CartDao;
import com.oaec.b2c.dao.impl.CartDaoImpl;
import com.oaec.b2c.service.CartService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartServiceImpl implements CartService {

    private CartDao cartDao = new CartDaoImpl();

    @Override
    public List<Map<String, Object>> getCartProducts(Integer userId) {
        return cartDao.queryByUserId(userId);
    }

    @Override
    public boolean addCart(Integer userId, Integer productId, Integer quantity) {
        //查询当前用户的购物车是否存在此商品
        Map<String, Object> cart = cartDao.queryByUserIdAndProductId(userId, productId);
        Map<String,Object> param = new HashMap<>();
        param.put("userId",userId);
        param.put("productId",productId);
        param.put("quantity",quantity);
        int result = 0;
        if(cart == null){
            //不存在，添加
            result = cartDao.doInsert(param);
        }else{
            //存在，修改数量
            result = cartDao.updateQuantity(param);
        }
        return result == 1;
    }

    @Override
    public boolean delete(Integer userId, Integer productId) {
        return cartDao.doDelete(userId, productId) == 1;
    }

    @Override
    public boolean updateQuantity(String action, Integer userId, Integer productId) {
        int result = 0;
        if("add".equals(action)){
            result = cartDao.addQuantity(userId, productId);
        }else{
            result = cartDao.subQuantity(userId, productId);
        }
        return result == 1;
    }

    @Override
    public Map<String, Object> getTotal(Integer userId, String[] productIds) {
        return cartDao.queryTotal(userId,productIds);
    }

    @Override
    public List<Map<String, Object>> getProducts4Checkout(Integer userId, String[] productIds) {
        return cartDao.queryProduct4Checkout(userId, productIds);
    }
}

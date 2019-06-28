package com.oaec.b2c.service;

import java.util.List;
import java.util.Map;

public interface CartService {

    //查询指定用户的购物车中的商品
    List<Map<String,Object>> getCartProducts(Integer userId);

    /**
     * 添加商品到购物车
     * @param userId 用户编号
     * @param productId 商品编号
     * @param quantity 数量
     * @return
     */
    boolean addCart(Integer userId, Integer productId, Integer quantity);

    /**
     * 删除购物车中的商品
     * @param userId 用户编号
     * @param productId 商品编号
     * @return
     */
    boolean delete(Integer userId, Integer productId);

    /**
     * 修改购物车中商品数量
     * @param action 动作：add:加，sub:减
     * @param userId 用户编号
     * @param productId 商品编号
     * @return
     */
    boolean updateQuantity(String action, Integer userId, Integer productId);

    Map<String,Object> getTotal(Integer userId, String[] productIds);

    List<Map<String,Object>> getProducts4Checkout(Integer userId, String[] productIds);

}

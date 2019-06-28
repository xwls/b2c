package com.oaec.b2c.dao;

import java.util.List;
import java.util.Map;

public interface CartDao {

    /**
     * 根据用户编号查询用户的购物车中的商品
     * @param userId
     * @return
     */
    List<Map<String,Object>> queryByUserId(Integer userId);

    /**
     * 添加商品到购物车（数据层方法如果需要多个参数，一般准备包装类型作为方法的参数）
     * @param param：执行insert需要的参数：userId,productId,quantity
     * @return
     */
    int doInsert(Map<String,Object> param);

    /**
     * 根据用户编号和商品编号查询
     * @param userId
     * @param productId
     * @return
     */
    Map<String,Object> queryByUserIdAndProductId(Integer userId, Integer productId);

    /**
     * 修改购物车中商品的数量
     * @param param
     * @return
     */
    int updateQuantity(Map<String,Object> param);

    /**
     * 从购物车删除商品
     * @param userId 用户编号
     * @param productId 商品编号
     * @return
     */
    int doDelete(Integer userId, Integer productId);

    /**
     * 修改数量的加号按钮
     * @param userId 用户编号
     * @param productId 商品编号
     * @return
     */
    int addQuantity(Integer userId, Integer productId);

    /**
     * 修改数量的减号按钮
     * @param userId 用户编号
     * @param productId 商品编号
     * @return
     */
    int subQuantity(Integer userId, Integer productId);

    /**
     * 购物车统计，统计出要购买的总数量和总价钱
     * @param userId 用户编号
     * @param productIds 商品编号（多个）
     * @return
     */
    Map<String,Object> queryTotal(Integer userId, String[] productIds);

    List<Map<String,Object>> queryProduct4Checkout(Integer userId, String[] productIds);

}

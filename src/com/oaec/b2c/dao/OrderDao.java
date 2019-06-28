package com.oaec.b2c.dao;

import java.util.List;
import java.util.Map;

public interface OrderDao {
    //根据用户编号查询订单
    List<Map<String,Object>> queryByUserId(Integer userId);

    //查询订单包含的商品
    List<Map<String,Object>> queryProductByOrderId(Integer orderId);

    //查询订单的总金额
    Double getTotalPrice(Integer orderId);

    //订单主表插入数据
    int doInsert(Integer userId, Integer addressId);

    //订单明细表插入数据
    int doInsertDetail(Map<String,Object> param);
}

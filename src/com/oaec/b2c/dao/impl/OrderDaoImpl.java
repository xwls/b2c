package com.oaec.b2c.dao.impl;

import com.oaec.b2c.dao.OrderDao;
import com.oaec.b2c.util.CommonDao;

import java.util.List;
import java.util.Map;

public class OrderDaoImpl extends CommonDao implements OrderDao {
    @Override
    public List<Map<String, Object>> queryByUserId(Integer userId) {
        String sql = "SELECT * FROM orders WHERE user_id = ? ORDER BY order_id DESC";
        return query4MapList(sql,userId);
    }

    @Override
    public List<Map<String, Object>> queryProductByOrderId(Integer orderId) {
        String sql = "SELECT order_detail.product_id,order_detail.img_url,order_detail.name,order_detail.quantity,order_detail.price FROM orders,order_detail WHERE orders.order_id = order_detail.order_id AND orders.order_id = ?";
        return query4MapList(sql,orderId);
    }

    @Override
    public Double getTotalPrice(Integer orderId) {
        String sql = "SELECT SUM(order_detail.quantity*order_detail.price) total_price FROM orders,order_detail WHERE orders.order_id = order_detail.order_id AND orders.order_id = ?";
        Map<String, Object> map = query4Map(sql, orderId);
        return Double.parseDouble(map.get("total_price").toString());
    }

    @Override
    public int doInsert(Integer userId, Integer addressId) {
        String sql = "INSERT INTO orders VALUES (?,?,?,1,sysdate)";
        int orderId = getOrderId();
        int i = executeUpdate(sql, orderId, userId, addressId);
        if (i == 1){
            return orderId;
        }
        return 0;
    }

    @Override
    public int doInsertDetail(Map<String, Object> param) {
        String sql = "INSERT INTO order_detail VALUES (seq_order_detail.nextval,?,?,?,?,?,?)";
        return executeUpdate(sql,param.get("order_id"),param.get("product_id"),param.get("name"),param.get("img_url"),param.get("price"),param.get("quantity"));
    }

    private int getOrderId(){
        String sql = "SELECT seq_orders.nextval order_id FROM dual";
        Map<String, Object> map = query4Map(sql);
        return Integer.parseInt(map.get("order_id").toString());
    }
}

package com.oaec.b2c.dao.impl;

import com.oaec.b2c.dao.CartDao;
import com.oaec.b2c.util.CommonDao;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CartDaoImpl extends CommonDao implements CartDao {
    @Override
    public List<Map<String, Object>> queryByUserId(Integer userId) {
        String sql = "SELECT product.pid,product.img_url,product.name,product.price,cart.quantity FROM cart,product WHERE cart.product_id = product.pid AND user_id = ?";
        return query4MapList(sql,userId);
    }

    @Override
    public int doInsert(Map<String,Object> param) {
        String sql = "INSERT INTO cart VALUES (seq_cart.nextval,?,?,?)";
        return executeUpdate(sql,param.get("userId"),param.get("productId"),param.get("quantity"));
    }

    @Override
    public Map<String, Object> queryByUserIdAndProductId(Integer userId, Integer productId) {
        String sql = "SELECT * FROM cart,product WHERE cart.product_id = product.pid AND user_id = ? AND product_id = ?";
        return query4Map(sql,userId,productId);
    }

    @Override
    public int updateQuantity(Map<String, Object> param) {
        String sql = "UPDATE cart SET quantity = quantity + ? WHERE user_id = ? AND product_id = ?";
        return executeUpdate(sql,param.get("quantity"),param.get("userId"),param.get("productId"));
    }

    @Override
    public int doDelete(Integer userId, Integer productId) {
        String sql = "DELETE FROM cart WHERE user_id = ? AND product_id = ?";
        return executeUpdate(sql,userId,productId);
    }

    @Override
    public int addQuantity(Integer userId, Integer productId) {
        String sql = "UPDATE cart SET quantity = quantity + 1 WHERE user_id = ? AND product_id = ?";
        return executeUpdate(sql,userId,productId);
    }

    @Override
    public int subQuantity(Integer userId, Integer productId) {
        String sql = "UPDATE cart SET quantity = quantity - 1 WHERE user_id = ? AND product_id = ?";
        return executeUpdate(sql,userId,productId);
    }

    @Override
    public Map<String, Object> queryTotal(Integer userId, String[] productIds) {
        StringBuilder sql = new StringBuilder("SELECT SUM(quantity) total_quantity,SUM(quantity*price) total_price FROM cart,product WHERE product.pid = cart.product_id AND user_id = ? AND cart.product_id IN(");
        Object[] param = new Object[productIds.length+1];
        param[0] = userId;
        for (int i = 0; i < productIds.length; i++) {
            sql.append("?,");
            param[i+1] = productIds[i];
        }
        sql.deleteCharAt(sql.length()-1);
        sql.append(")");
//        System.out.println(sql);
//        System.out.println(Arrays.toString(param));
        return query4Map(sql.toString(),param);
    }

    @Override
    public List<Map<String, Object>> queryProduct4Checkout(Integer userId, String[] productIds) {
        StringBuilder sql = new StringBuilder("SELECT product.pid,product.img_url,product.name,cart.quantity,product.price FROM cart,product WHERE cart.product_id = product.pid AND user_id = ? AND product_id IN(");
        Object[] param = new Object[productIds.length+1];
        param[0] = userId;
        for (int i = 0; i < productIds.length; i++) {
            sql.append("?,");
            param[i+1] = productIds[i];
        }
        sql.deleteCharAt(sql.length()-1);
        sql.append(")");
        return query4MapList(sql.toString(),param);
    }
}

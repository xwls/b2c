package com.oaec.b2c.service.impl;

import com.alibaba.fastjson.JSON;
import com.oaec.b2c.dao.AddressDao;
import com.oaec.b2c.dao.CartDao;
import com.oaec.b2c.dao.OrderDao;
import com.oaec.b2c.dao.ProductDao;
import com.oaec.b2c.dao.impl.AddressDaoImpl;
import com.oaec.b2c.dao.impl.CartDaoImpl;
import com.oaec.b2c.dao.impl.OrderDaoImpl;
import com.oaec.b2c.dao.impl.ProductDaoImpl;
import com.oaec.b2c.service.OrderService;

import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();
    private AddressDao addressDao = new AddressDaoImpl();
    private CartDao cartDao = new CartDaoImpl();
    private ProductDao productDao = new ProductDaoImpl();

    @Override
    public List<Map<String, Object>> getOrders(Integer userId) {
        //1.根据用户编号查询用户的所有订单
        List<Map<String, Object>> orderList = orderDao.queryByUserId(userId);
        for (Map<String, Object> map : orderList) {
            //获取地址编号
            int address_id = Integer.parseInt(map.get("address_id").toString());
            //2.查询订单对应的地址
            Map<String, Object> address = addressDao.queryById(address_id);
            map.put("address",address);
            //3.查询出订单的总价钱
            int order_id = Integer.parseInt(map.get("order_id").toString());
            Double totalPrice = orderDao.getTotalPrice(order_id);
            map.put("totalPrice",totalPrice);
            //4.查询出订单对应的商品
            List<Map<String, Object>> products = orderDao.queryProductByOrderId(order_id);
            map.put("products",products);

        }
//        System.out.println(JSON.toJSONString(orderList));
        return orderList;
    }

    @Override
    public boolean submit(Integer userId, Integer aid, String[] pids) {
        int result = 0;
        //1.向订单主表插入数据
        int orderId = orderDao.doInsert(userId, aid);
        for (String pid : pids) {
            Integer productId = Integer.parseInt(pid);
            //查询当前编号的商品信息
            Map<String, Object> product = cartDao.queryByUserIdAndProductId(userId, productId);
            product.put("order_id",orderId);
            //2.向订单明细表插入数据
            result += orderDao.doInsertDetail(product);
            //3.在购物车中删除此商品
            result += cartDao.doDelete(userId,productId);
            //4.修改库存和销量
            int quantity = Integer.parseInt(product.get("quantity").toString());
            result += productDao.updateInventoryAndSalesVolume(productId,quantity);
        }
        return result > 0;
    }
}

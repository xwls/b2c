package com.oaec.b2c.service;

import java.util.List;
import java.util.Map;

public interface OrderService {
    //根据用户编号查询用户的订单
    List<Map<String,Object>> getOrders(Integer userId);

    //生成订单
    boolean submit(Integer userId, Integer aid, String[] pids);
}

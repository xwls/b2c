package com.oaec.b2c.service;

import java.util.List;
import java.util.Map;

public interface ProductService {
    //商品检索
    List<Map<String,Object>> query(String name, String cid, String bid);
    List<Map<String,Object>> query(String name, String cid, String bid, int page);
    int getCount(String name, String cid, String bid);

    //根据编号获取一个商品
    Map<String,Object> getProduct(String pid);
}

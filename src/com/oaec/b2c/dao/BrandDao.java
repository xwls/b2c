package com.oaec.b2c.dao;

import java.util.List;
import java.util.Map;

public interface BrandDao {
    //查询全部
    List<Map<String,Object>> queryAll();

    //根据分类查询
    List<Map<String,Object>> queryByCid(Integer cid);

    //根据编号查询品牌
    Map<String,Object> queryByBid(Integer bid);
}

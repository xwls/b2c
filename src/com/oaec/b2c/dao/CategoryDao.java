package com.oaec.b2c.dao;

import java.util.List;
import java.util.Map;

public interface CategoryDao {
    //查询至少有一个商品的分类
    List<Map<String,Object>> queryNav();

    //根据分类编号查询
    Map<String,Object> queryByCid(Integer cid);
}

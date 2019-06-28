package com.oaec.b2c.dao.impl;

import com.oaec.b2c.dao.CategoryDao;
import com.oaec.b2c.util.CommonDao;

import java.util.List;
import java.util.Map;

public class CategoryDaoImpl extends CommonDao implements CategoryDao {
    @Override
    public List<Map<String, Object>> queryNav() {
        String sql = "SELECT * FROM category WHERE cid IN(SELECT DISTINCT cid FROM product) ORDER BY cid";
        return query4MapList(sql);
    }

    @Override
    public Map<String, Object> queryByCid(Integer cid) {
        String sql = "SELECT * FROM category WHERE cid = ?";
        return query4Map(sql,cid);
    }
}

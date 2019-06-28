package com.oaec.b2c.dao.impl;

import com.oaec.b2c.dao.BrandDao;
import com.oaec.b2c.util.CommonDao;

import java.util.List;
import java.util.Map;

public class BrandDaoImpl extends CommonDao implements BrandDao {
    @Override
    public List<Map<String, Object>> queryAll() {
        String sql = "SELECT * FROM brand WHERE bid IN(SELECT bid FROM product WHERE status = 1 GROUP BY bid)";
        return query4MapList(sql);
    }

    @Override
    public List<Map<String, Object>> queryByCid(Integer cid) {
        String sql = "SELECT * FROM brand WHERE bid IN(SELECT bid FROM product WHERE cid = ? AND status = 1 GROUP BY bid)";
        return query4MapList(sql,cid);
    }

    @Override
    public Map<String, Object> queryByBid(Integer bid) {
        String sql = "SELECT * FROM brand WHERE bid = ?";
        return query4Map(sql,bid);
    }
}

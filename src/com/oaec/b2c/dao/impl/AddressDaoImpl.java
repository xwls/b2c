package com.oaec.b2c.dao.impl;

import com.oaec.b2c.dao.AddressDao;
import com.oaec.b2c.util.CommonDao;

import java.util.List;
import java.util.Map;

public class AddressDaoImpl extends CommonDao implements AddressDao {
    @Override
    public Map<String, Object> queryById(Integer aid) {
        String sql = "SELECT * FROM address WHERE aid = ?";
        return query4Map(sql,aid);
    }

    @Override
    public List<Map<String, Object>> queryByUserId(Integer userId) {
        String sql = "SELECT * FROM address WHERE status = 1 AND user_id = ?";
        return query4MapList(sql,userId);
    }
}

package com.oaec.b2c.dao.impl;

import com.oaec.b2c.dao.UserDao;
import com.oaec.b2c.util.CommonDao;

import java.util.Map;

public class UserDaoImpl extends CommonDao implements UserDao {
    @Override
    public Map<String, Object> queryByUsername(String username) {
        String sql = "SELECT * FROM user_info WHERE username = ?";
        return query4Map(sql,username);
    }
}

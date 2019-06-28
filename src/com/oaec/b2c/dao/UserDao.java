package com.oaec.b2c.dao;

import java.util.Map;

public interface UserDao {
    Map<String,Object> queryByUsername(String username);
}

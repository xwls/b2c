package com.oaec.b2c.service;

import java.util.Map;

public interface UserService {
    Map<String,Object> login(String username, String password);
}

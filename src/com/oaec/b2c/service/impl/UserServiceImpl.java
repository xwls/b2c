package com.oaec.b2c.service.impl;

import com.oaec.b2c.dao.UserDao;
import com.oaec.b2c.dao.impl.UserDaoImpl;
import com.oaec.b2c.service.UserService;

import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public Map<String, Object> login(String username, String password) {
        //根据用户名查询用户
        Map<String, Object> map = userDao.queryByUsername(username);
        if(map == null){
            //用户名不存在，登录失败
            map = new HashMap<>();
            map.put("error","用户名不存在");
        }else {
            //判断密码是否一致
            if(map.get("password").equals(password)){
                //登录成功
                return map;
            }else{
                //密码错误，登录失败
                map.clear();
                map.put("error","密码错误");
            }
        }
        return map;
    }
}

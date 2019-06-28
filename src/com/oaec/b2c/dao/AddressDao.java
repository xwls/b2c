package com.oaec.b2c.dao;

import java.util.List;
import java.util.Map;

public interface AddressDao {

    //根据地址编号查询地址
    Map<String,Object> queryById(Integer aid);

    //根据用户编号查询地址
    List<Map<String,Object>> queryByUserId(Integer userId);
}

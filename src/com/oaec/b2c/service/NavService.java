package com.oaec.b2c.service;

import java.util.List;
import java.util.Map;

public interface NavService {
    /**
     * 获取导航数据
     * @return
     */
    List<Map<String,Object>> getNav();
}

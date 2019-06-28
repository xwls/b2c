package com.oaec.b2c.service.impl;

import com.oaec.b2c.dao.CategoryDao;
import com.oaec.b2c.dao.impl.CategoryDaoImpl;
import com.oaec.b2c.service.NavService;

import java.util.List;
import java.util.Map;

public class NavServiceImpl implements NavService {

    //依赖数据层
    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Map<String, Object>> getNav() {
        return categoryDao.queryNav();
    }
}

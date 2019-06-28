package com.oaec.b2c.service.impl;

import com.oaec.b2c.dao.BrandDao;
import com.oaec.b2c.dao.impl.BrandDaoImpl;
import com.oaec.b2c.service.BrandService;

import java.util.List;
import java.util.Map;

public class BrandServiceImpl implements BrandService {

    private BrandDao brandDao = new BrandDaoImpl();

    @Override
    public List<Map<String, Object>> query(String cid) {
        if(cid == null){
            return brandDao.queryAll();
        }else {
            return brandDao.queryByCid(Integer.parseInt(cid));
        }

    }
}

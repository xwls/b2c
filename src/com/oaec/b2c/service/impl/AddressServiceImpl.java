package com.oaec.b2c.service.impl;

import com.oaec.b2c.dao.AddressDao;
import com.oaec.b2c.dao.impl.AddressDaoImpl;
import com.oaec.b2c.service.AddressService;

import java.util.List;
import java.util.Map;

public class AddressServiceImpl implements AddressService {

    private AddressDao addressDao = new AddressDaoImpl();

    @Override
    public List<Map<String, Object>> getAddress(Integer userId) {
        return addressDao.queryByUserId(userId);
    }
}

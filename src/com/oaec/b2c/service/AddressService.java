package com.oaec.b2c.service;

import java.util.List;
import java.util.Map;

public interface AddressService {

    List<Map<String,Object>> getAddress(Integer userId);

}

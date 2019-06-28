package com.oaec.b2c.service;

import java.util.List;
import java.util.Map;

public interface BrandService {
    List<Map<String,Object>> query(String cid);
}

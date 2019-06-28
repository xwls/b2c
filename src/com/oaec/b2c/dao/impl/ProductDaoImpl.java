package com.oaec.b2c.dao.impl;

import com.oaec.b2c.dao.ProductDao;
import com.oaec.b2c.util.CommonDao;

import java.util.List;
import java.util.Map;

public class ProductDaoImpl extends CommonDao implements ProductDao {
    @Override
    public List<Map<String, Object>> queryAll() {
        String sql = "SELECT * FROM product WHERE status = 1";
        return query4MapList(sql);
    }

    @Override
    public List<Map<String, Object>> queryAll(int page) {
        String sql = "SELECT * FROM (SELECT ROWNUM rn,t1.* FROM( SELECT * FROM product WHERE status = 1 ) t1 )t2 WHERE t2.rn > ? AND t2.rn <= ?";
        return query4MapList(sql, (page - 1) * PAGE_SIZE, page * PAGE_SIZE);
    }

    @Override
    public int getCountAll() {
        String sql = "SELECT COUNT(pid) count FROM product WHERE status = 1";
        Map<String, Object> map = query4Map(sql);
        return Integer.parseInt(map.get("count").toString());
    }

    @Override
    public List<Map<String, Object>> queryLike(String name) {
        String sql = "SELECT * FROM product WHERE UPPER(name) LIKE UPPER(?) AND status = 1";
        return query4MapList(sql, "%" + name + "%");
    }

    @Override
    public List<Map<String, Object>> queryByCid(Integer cid) {
        String sql = "SELECT * FROM product WHERE cid = ? AND status = 1";
        return query4MapList(sql, cid);
    }

    @Override
    public List<Map<String, Object>> queryByBid(Integer bid) {
        String sql = "SELECT * FROM product WHERE bid = ? AND status = 1";
        return query4MapList(sql, bid);
    }

    @Override
    public List<Map<String, Object>> queryByBidAndCid(Integer bid, Integer cid) {
        String sql = "SELECT * FROM product WHERE bid = ? AND cid = ? AND status = 1";
        return query4MapList(sql, bid, cid);
    }

    @Override
    public Map<String, Object> queryByPid(Integer pid) {
        String sql = "SELECT * FROM product WHERE pid = ?";
        return query4Map(sql, pid);
    }

    @Override
    public int updateInventoryAndSalesVolume(Integer pid, Integer quantity) {
        String sql = "UPDATE product SET inventory = inventory - ?, sales_volume = sales_volume + ? WHERE pid = ?";
        return executeUpdate(sql, quantity, quantity, pid);
    }
}

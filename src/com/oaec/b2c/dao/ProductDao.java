package com.oaec.b2c.dao;

import java.util.List;
import java.util.Map;

public interface ProductDao {

    int PAGE_SIZE = 4;//没有显示4条

    //查询全部商品
    List<Map<String,Object>> queryAll();
    List<Map<String,Object>> queryAll(int page);
    int getCountAll();

    //模糊查询
    List<Map<String,Object>> queryLike(String name);
//    int getCountLike();

    //根据分类查询
    List<Map<String,Object>> queryByCid(Integer cid);
//    int getCountByCid();

    //根据品牌查询
    List<Map<String,Object>> queryByBid(Integer bid);

    //根据分类及品牌查询
    List<Map<String,Object>> queryByBidAndCid(Integer bid, Integer cid);

    //根据编号查询
    Map<String,Object> queryByPid(Integer pid);

    //修改商品的库存和销量
    int updateInventoryAndSalesVolume(Integer pid, Integer quantity);
}

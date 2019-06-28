package com.oaec.b2c.util;

import com.alibaba.druid.pool.DruidDataSource;

public class JdbcDataSource {

    private static final String URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
    private static final String USERNAME = "b2c";
    private static final String PASSWORD = "123456";

    private static DruidDataSource dataSource;
    static {
        dataSource = new DruidDataSource();
        //可以不设置，当不设置驱动类名时，会根据url自动设置
//        dataSource.setDriverClassName();
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
    }
    public static DruidDataSource getDataSource(){
        return dataSource;
    }
}

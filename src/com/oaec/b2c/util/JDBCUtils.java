package com.oaec.b2c.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC的工具类，负责：加载驱动，建立连接，释放资源
 *
 */
public class JDBCUtils {



    /**
     * 建立和数据库的连接
     *
     * @return 连接
     */
    public Connection getConnection() {
        try {
            return JdbcDataSource.getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 释放资源
     *
     * @param rs
     *            结果集
     * @param stm
     *            语句对象
     * @param conn
     *            连接
     */
    public void close(ResultSet rs, Statement stm, Connection conn) {
        try {
            // 关闭结果集
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭语句对象
                if (stm != null && !stm.isClosed()) {
                    stm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    // 关闭连接
                    if (conn != null && !conn.isClosed()) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 释放资源
     *
     * @param stm
     *            语句对象
     * @param conn
     *            连接
     */
    public void close(Statement stm, Connection conn) {
        close(null, stm, conn);
    }

}

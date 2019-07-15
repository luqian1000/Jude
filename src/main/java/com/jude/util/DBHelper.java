package com.jude.util;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DBHelper {
    //地址，驱动，用户名和密码
    public static final String url = "jdbc:mysql://127.0.0.1:3306/test";
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "password";

    public Connection conn = null;

    public DBHelper() {
        try {
            Class.forName(name);//加载驱动
            conn = DriverManager.getConnection(url, user, password);//获取连接
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ResultSet select(String sql, Object... params) {
        ResultSet rs = null;
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pst.setObject(i + 1, params[i]);
                }
            }
            rs = pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rs;
    }

    public static void main(String[] args) throws SQLException {
        DBHelper dbHelper = new DBHelper();
        String sql = "SELECT * from employee WHERE name = ?";
        ResultSet resultSet = dbHelper.select(sql, "张三");
        Map<String, String> m;
        while (resultSet.next()) {
            m = new HashMap<String, String>();
            ResultSetMetaData rsmd = resultSet.getMetaData();
            for (int i = 0; i < rsmd.getColumnCount(); i++) {
                m.put(rsmd.getColumnName(i), resultSet.getString(rsmd.getColumnName(i)));
            }
        }
    }
}

package com.iweb.day;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Raxcl
 * @date 2024/7/22 15:22
 * pojo 实体类 ORM object relation model
 * DAO接口
 */
public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8";

    private static  final String USER = "root";
    private static  final String PASSWORD = "a12345";
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnect() throws SQLException{
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }

}

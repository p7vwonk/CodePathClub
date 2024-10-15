package main.java.servlet;

import java.sql.*;

public class DBConnection {
    public static Connection connectDB(String DBName) {
        Connection con = null;
        String uri = "jdbc:mysql://localhost:3306/" + DBName +
                "?allowPublicKeyRetrieval=true&useSSL=true&serverTimeZone=CST&characterEncoding=utf-8";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            con = DriverManager.getConnection(uri, "default_user",  "default_password_233");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }
    public static void disconnectDB(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
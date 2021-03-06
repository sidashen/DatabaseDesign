package com.thoughtworks.utils;

import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
  public static Connection getConnection() throws Exception {
    Class driverDemo = Class.forName("com.mysql.jdbc.Driver");
    Driver driver = (Driver)driverDemo.newInstance();
    String url = "jdbc:mysql://localhost:3306/test";
    Properties info = new Properties();
    info.setProperty("user", "root");
    info.setProperty("password", "");
    Connection conn = driver.connect(url, info);
    return conn;
  }

  public static void closeResource(Connection conn, Statement st) {
    if (st != null) {
      try {
        st.close();
      } catch (SQLException var5) {
        var5.printStackTrace();
      }
    }

    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException var4) {
        var4.printStackTrace();
      }
    }
  }

  public static void closeResource(Connection conn, Statement st, ResultSet rs) {
    if (st != null) {
      try {
        st.close();
      } catch (SQLException var5) {
        var5.printStackTrace();
      }
    }

    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException var4) {
        var4.printStackTrace();
      }
    }

    if (rs != null) {   // 关闭记录集
      try {
        rs.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}

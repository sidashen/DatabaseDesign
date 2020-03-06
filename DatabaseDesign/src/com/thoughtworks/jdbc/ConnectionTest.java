package com.thoughtworks.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class ConnectionTest {
  public ConnectionTest() {
  }

  @Test
  public void query() throws Exception {
    Class driverDemo = Class.forName("com.mysql.jdbc.Driver");
    Driver driver = (Driver)driverDemo.newInstance();
    String url = "jdbc:mysql://localhost:3306/test";
    Properties info = new Properties();
    info.setProperty("user", "root");
    info.setProperty("password", "");
    Connection conn = driver.connect(url, info);
    String sql = "SELECT id, name, age, gender FROM student_info";
    PreparedStatement ps = conn.prepareStatement(sql);
    ResultSet resultSet = ps.executeQuery();

    while(resultSet.next()) {
      int id = resultSet.getInt("id");
      String name = resultSet.getString("name");
      int age = resultSet.getInt("age");
      String gender = resultSet.getString("gender");
      System.out.println("学号： " + id + ", 姓名： " + name + ", 年龄： " + age + ", 性别： " + gender);
    }

    Close.closeConnect(resultSet, ps, conn);
  }

}

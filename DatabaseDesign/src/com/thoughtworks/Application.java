package com.thoughtworks;

import com.thoughtworks.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Application {
  public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//    System.out.println("您好，欢迎登陆学生考试系统，请输入您的用户名和密码(用户名:密码)：\n" +
//      "例如：张三:123");
//    String userInfo = scanner.nextLine();

    Connection conn = null;
    PreparedStatement ps = null;
    try {
      conn = JDBCUtils.getConnection();
      String sql = "update student_info set name = ? where id = ?";
      ps = conn.prepareStatement(sql);
      ps.setObject(1, "shasha");
      ps.setObject(2, 20001);
      ps.execute();
      System.out.println("修改成功！");
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.closeResource(conn, ps);
    }
  }
}

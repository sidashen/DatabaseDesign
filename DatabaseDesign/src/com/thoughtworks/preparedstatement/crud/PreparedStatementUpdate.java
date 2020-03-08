package com.thoughtworks.preparedstatement.crud;

import com.thoughtworks.utils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PreparedStatementUpdate {

  public static int update(String sql, Object ...args) {//sql中占位符的个数与可变形参的长度一致
    Connection conn = null;
    PreparedStatement ps = null;
    try {
      conn = JDBCUtils.getConnection();
      ps = conn.prepareStatement(sql);
      for(int i = 0; i < args.length; i++) {
        ps.setObject(i + 1, args[i]);
      }
      return ps.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.closeResource(conn, ps);
    }
    return 0;
  }
}

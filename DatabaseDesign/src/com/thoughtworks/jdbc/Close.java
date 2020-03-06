package com.thoughtworks.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Close {
  public Close() {
  }

  public static void closeConnect(ResultSet rs, Statement st, Connection conn) {
    if (rs != null) {
      try {
        rs.close();
      } catch (SQLException var6) {
        var6.printStackTrace();
      }
    }

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
}

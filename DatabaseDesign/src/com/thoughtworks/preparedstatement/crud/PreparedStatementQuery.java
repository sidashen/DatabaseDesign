package com.thoughtworks.preparedstatement.crud;

import com.thoughtworks.entities.Score;
import com.thoughtworks.entities.Student;
import com.thoughtworks.utils.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class PreparedStatementQuery {

  @Test
  public void test() {
    String sql = "select id, name, age, gender from student_info where id = ?";
    List<Student> list = queryInfoList(Student.class, sql, 20001);
    list.forEach(System.out::println);
  }

  //多条记录
  public <T> List<T> queryInfoList(Class<T> clazz, String sql, Object ...args) {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
      conn = JDBCUtils.getConnection();
      ps = conn.prepareStatement(sql);
      for (int i = 0; i < args.length; i++) {
        ps.setObject(i + 1, args[i]);
      }
      rs = ps.executeQuery();
      ResultSetMetaData rsmd = rs.getMetaData();
      int columnCount = rsmd.getColumnCount();
      //创建集合
      ArrayList<T> list = new ArrayList<T>();

      while (rs.next()) {
        T t = clazz.newInstance();
        //处理结果集一行中的每一个列
        for (int i = 0; i < columnCount; i ++) {
          //获取列值
          Object columnValue = rs.getObject(i + 1);
          //获取每个列的列名
          // String columnName = rsmd.getColumnName(i + 1);
          //获取每个列的别名
          String columnLabel = rsmd.getColumnLabel(i + 1);
          //给score指定的属性赋值，通过反射
          Field field = clazz.getDeclaredField(columnLabel);
          field.setAccessible(true);
          field.set(t, columnValue);
        }
        list.add(t);
      }
      return list;
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.closeResource(conn, ps, rs);
    }
    return null;
  }

  //单条记录
  public <T> T queryInfo(Class<T> clazz, String sql, Object ...args) {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
      conn = JDBCUtils.getConnection();
      ps = conn.prepareStatement(sql);
      for (int i = 0; i < args.length; i++) {
        ps.setObject(i + 1, args[i]);
      }
      rs = ps.executeQuery();
      ResultSetMetaData rsmd = rs.getMetaData();
      int columnCount = rsmd.getColumnCount();

      if(rs.next()) {
        T t = clazz.newInstance();
        //处理结果集一行中的每一个列
        for (int i = 0; i < columnCount; i ++) {
          //获取列值
          Object columnValue = rs.getObject(i + 1);
          //获取每个列的列名
          // String columnName = rsmd.getColumnName(i + 1);
          //获取每个列的别名
          String columnLabel = rsmd.getColumnLabel(i + 1);
          //给score指定的属性赋值，通过反射
          Field field = clazz.getDeclaredField(columnLabel);
          field.setAccessible(true);
          field.set(t, columnValue);
        }
        return t;
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      JDBCUtils.closeResource(conn, ps, rs);
    }
    return null;
  }

}

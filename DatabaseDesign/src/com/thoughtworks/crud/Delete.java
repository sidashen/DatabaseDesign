package com.thoughtworks.crud;

import com.thoughtworks.preparedstatement.crud.PreparedStatementUpdate;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Delete {

  public static void deleteInfo(String instruction, Scanner scanner) {
    switch (instruction) {
      case "4.1":
        System.out.println("删除学生之后，该学生信息将不能恢复，是否要继续删除？\n" +
          "1. 是\n" +
          "2. 否");
        if ("1.".equals(scanner.nextLine())) {
          System.out.println("请输入您需要删除的学生学号：");
          int id = Integer.parseInt(scanner.nextLine());
          String sql = "delete from student_info where id = ?";
          int insertCount = PreparedStatementUpdate.update(sql, id);
          printMessage(insertCount);
        }
        break;
      case "4.2":
        System.out.println("删除课程之后，该课程信息将不能恢复，是否要继续删除？\n" +
          "1. 是\n" +
          "2. 否");
        if ("1.".equals(scanner.nextLine())) {
          System.out.println("请输入您需要删除的课程编号：");
          int id = Integer.parseInt(scanner.nextLine());
          String sql = "delete from subject_info where id = ?";
          int insertCount = PreparedStatementUpdate.update(sql, id);
          printMessage(insertCount);
        }
        break;
      case "4.3":
        System.out.println("删除教师之后，该教师信息将不能恢复，是否要继续删除？\n" +
          "1. 是\n" +
          "2. 否");
        if ("1.".equals(scanner.nextLine())) {
          System.out.println("请输入您需要删除的教师编号：");
          int id = Integer.parseInt(scanner.nextLine());
          String sql = "delete from subject_info where id = ?";
          int insertCount = PreparedStatementUpdate.update(sql, id);
          printMessage(insertCount);
        }
        break;
    }
  }
  public static void printMessage(Integer insertCount){
    if (insertCount > 0) {
      System.out.println("删除成功");
    } else {
      System.out.println("删除失败");
    }
  }
}

package com.thoughtworks.crud;

import com.thoughtworks.preparedstatement.crud.PreparedStatementUpdate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Insert {

  public static void insertInfo(String instruction, Scanner scanner) {
    switch (instruction) {
      case "2.1":
        System.out.println("请输入学生信息(例如：学号：1001, 姓名： 小明, 年龄： 18, 性别： 男)：");
        List<String> infoList = Arrays.asList(scanner.nextLine().split(","));
        int id = Integer.parseInt(infoList.get(0).substring(3));
        String name = infoList.get(1).substring(4);
        int age = Integer.parseInt(infoList.get(2).substring(4));
        String gender = infoList.get(3).substring(4);
        String sql = "insert into student_info values (?, ?, ?, ?)";
        int insertCount = PreparedStatementUpdate.update(sql, id, name, age, gender);
        if (insertCount > 0) {
          System.out.println("添加成功");
        } else {
          System.out.println("添加失败");
        }
        break;
      case "2.2":
        System.out.println("请输入课程信息(例如：编号：1001, 名称: 计算机, 老师: 王老师)：");
        infoList = Arrays.asList(scanner.nextLine().split(","));
        int subjectId = Integer.parseInt(infoList.get(0).substring(3));
        String subjectName = infoList.get(1).substring(3);
        String teacherName = infoList.get(2).substring(4);
        sql = "insert into subject_info values (?, ?, ?)";
        insertCount = PreparedStatementUpdate.update(sql, subjectId, subjectName, teacherName);
        if (insertCount > 0) {
          System.out.println("添加成功");
        } else {
          System.out.println("添加失败");
        }
        break;
      case "2.3":
        System.out.println("请输入教师信息(例如：编号: 1001, 姓名: 小明, 年龄: 18, 性别: 男)：");
        infoList = Arrays.asList(scanner.nextLine().split(","));
        id = Integer.parseInt(infoList.get(0).substring(3));
        name = infoList.get(1).substring(4);
        age = Integer.parseInt(infoList.get(2).substring(4));
        gender = infoList.get(3).substring(4);
        sql = "insert into teacher_info values (?, ?, ?, ?)";
        insertCount = PreparedStatementUpdate.update(sql, id, name, age, gender);
        if (insertCount > 0) {
          System.out.println("添加成功");
        } else {
          System.out.println("添加失败");
        }
        break;
      case "2.4":
        System.out.println("请输入学生信息(例如：学号: 20001, 编号: 1001, 姓名: 小明, 成绩: 80)：");
        infoList = Arrays.asList(scanner.nextLine().split(","));
        int studentId = Integer.parseInt(infoList.get(0).substring(3));
        subjectId = Integer.parseInt(infoList.get(1).substring(4));
        String studentName = infoList.get(2).substring(4);
        float score = Float.parseFloat(infoList.get(1).substring(4));
        sql = "insert into score_info values (?, ?, ?, ?)";
        insertCount = PreparedStatementUpdate.update(sql, studentId, subjectId, studentName, score);
        if (insertCount > 0) {
          System.out.println("添加成功");
        } else {
          System.out.println("添加失败");
        }
        break;
    }
  }
}

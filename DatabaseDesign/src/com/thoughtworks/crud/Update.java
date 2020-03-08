package com.thoughtworks.crud;

import com.thoughtworks.preparedstatement.crud.PreparedStatementUpdate;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Update {

  public static void updateInfo(String instruction, Scanner scanner) {
    switch (instruction) {
      case "3.1":
        System.out.println("请输入修改后的学生信息(例如：学号:1001,姓名:小明,年龄:18,性别:男)：");
        List<String> infoList = Arrays.asList(scanner.nextLine().split(","));
        int id = Integer.parseInt(infoList.get(0).substring(3));
        String name = infoList.get(1).substring(3);
        int age = Integer.parseInt(infoList.get(2).substring(3));
        String gender = infoList.get(3).substring(3);
        String sql = "update student_info set name = ?, age = ?, gender = ? where id = ?";
        int insertCount = PreparedStatementUpdate.update(sql, name, age, gender, id);
        printNotice(insertCount);
        break;
      case "3.2":
        System.out.println("请输入修改后的课程信息(例如：编号:1001,名称:计算机,老师:王老师)：");
        infoList = Arrays.asList(scanner.nextLine().split(","));
        int subjectId = Integer.parseInt(infoList.get(0).substring(3));
        String subjectName = infoList.get(1).substring(3);
        String teacherName = infoList.get(2).substring(3);
        sql = "update subject_info set subject_name = ?, teacher = ? where id = ?";
        insertCount = PreparedStatementUpdate.update(sql, subjectName, teacherName, subjectId);
        printNotice(insertCount);
        break;
      case "3.3":
        System.out.println("请输入修改后的教师信息(例如：编号:1001,姓名:小明,年龄:18,性别:男)：");
        infoList = Arrays.asList(scanner.nextLine().split(","));
        id = Integer.parseInt(infoList.get(0).substring(3));
        name = infoList.get(1).substring(3);
        age = Integer.parseInt(infoList.get(2).substring(3));
        gender = infoList.get(3).substring(3);
        sql = "update teacher_info set name = ?, age = ?, gender = ? where id = ?";
        insertCount = PreparedStatementUpdate.update(sql, name, age, gender, id);
        printNotice(insertCount);
        break;
      case "3.4":
        System.out.println("请输入修改后的学生成绩信息(例如：学号:20001, 编号:1001, 姓名:小明, 成绩:80)：");
        infoList = Arrays.asList(scanner.nextLine().split(","));
        int studentId = Integer.parseInt(infoList.get(0).substring(3));
        subjectId = Integer.parseInt(infoList.get(1).substring(3));
        String studentName = infoList.get(2).substring(3);
        float score = Float.parseFloat(infoList.get(1).substring(3));
        sql = "update score_info set subject_id = ?, student_name = ?, score = ? where student_id = ?";
        insertCount = PreparedStatementUpdate.update(sql, subjectId, studentName, score, studentId);
        printNotice(insertCount);
        break;
    }
  }

  public static void printNotice(Integer insertCount) {
    if (insertCount > 0) {
      System.out.println("修改成功");
    } else {
      System.out.println("修改失败");
    }
  }

}

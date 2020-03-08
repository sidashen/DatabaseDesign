package com.thoughtworks.crud;

import com.thoughtworks.preparedstatement.crud.PreparedStatementUpdate;
import org.junit.Test;

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
    }
  }
}

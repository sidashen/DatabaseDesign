package com.thoughtworks.entities;

import com.thoughtworks.Application;
import com.thoughtworks.crud.Query;

import java.util.Scanner;

public class Manager {
  private int id;
  private String name;
  private int age;
  private String gender;

  public Manager() {
  }

  public Manager(int id, String name, int age, String gender) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  @Override
  public String toString() {
    return "管理者编号：" + this.id + " 管理者姓名：" + this.name +
      " 管理者年龄：" + this.age + " 管理者性别：" + this.gender;
  }

  public static void managerFunction() {
    System.out.println("您好，超级管理员，请选择你需要进行的操作：\n" +
      "1. 查询\n" +
      "\t1.1 查询学生信息以及成绩\n" +
      "\t\t1.1.1 所有学生信息\n" +
      "\t\t1.1.2 指定学生姓名的信息以及所有课程的成绩\n" +
      "\t\t1.1.3 指定老师的所有学生及其成绩\n" +
      "\t\t1.1.4 指定课程的所有学生及其成绩\n" +
      "\t1.2 查询课程信息\n" +
      "\t    1.2.1 所有课程信息\n" +
      "\t    1.2.2 指定课程名称的信息\n" +
      "\t    1.2.3 指定老师的所有课程信息\n" +
      "\t1.3 查询老师信息\n" +
      "\t    1. 所有老师信息\n" +
      "\t    2. 指定老师信息\n" +
      "2. 新增\n" +
      "\t2.1 新增学生信息\n" +
      "\t2.2 新增课程信息\n" +
      "\t2.3 新增老师信息\n" +
      "\t2.4 给指定学生新增成绩\n" +
      "3. 修改\n" +
      "    3.1 修改指定学号的学生\n" +
      "    3.2 修改指定课程的信息\n" +
      "    3.3 修改指定老师的信息\n" +
      "    3.4 修改指定学生的成绩\n" +
      "4. 删除\n" +
      "\t4.1 删除指定学生\n" +
      "\t4.2 删除指定课程\n" +
      "\t4.3 删除指定老师");
    Scanner scanner = new Scanner(System.in);
    String instruction = "";
    while (!Application.isCorrectFormat(instruction)) {
      System.out.println("请输入正确指令");
      instruction = scanner.nextLine();
    }
    
    switch (instruction.substring(0, 2)) {
      case "1.":
        Query.queryInfo(instruction, scanner);
        break;
      case "2.":
        Query.queryInfo(instruction, scanner);
    }
  }
}

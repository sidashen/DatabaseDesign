package com.thoughtworks.entities;

public class Student {
  int id;
  String name;
  int age;
  String gender;

  public Student() {
  }

  public Student(int id, String name, int age, String gender) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  @Override
  public String toString() {
    return "学生学号：" + this.id + " 学生姓名：" + this.name +
      " 学生年龄：" + this.age + " 学生性别：" + this.gender;
  }
}

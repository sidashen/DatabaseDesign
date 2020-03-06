package com.thoughtworks.entities;

public class Teacher {
  int id;
  String name;
  int age;
  String gender;

  public Teacher() {
  }

  public Teacher(int id, String name, int age, String gender) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  @Override
  public String toString() {
    return "教师编号：" + this.id + " 教师姓名：" + this.name +
           " 教师年龄：" + this.age + " 教师性别：" + this.gender;
  }
}

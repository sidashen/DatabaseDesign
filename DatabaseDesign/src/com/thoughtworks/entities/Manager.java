package com.thoughtworks.entities;

public class Manager {
  int id;
  String name;
  int age;
  String gender;

  public Manager() {
  }

  public Manager(int id, String name, int age, String gender) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.gender = gender;
  }

  @Override
  public String toString() {
    return "管理者编号：" + this.id + " 管理者姓名：" + this.name +
      " 管理者年龄：" + this.age + " 管理者性别：" + this.gender;
  }
}

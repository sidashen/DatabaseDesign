package com.thoughtworks.entities;

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
}

package com.thoughtworks.entities;

public class Subject {
  int subjectId;
  String subjectName;
  String teacherName;

  public Subject() {
  }

  public Subject(int subjectId, String subjectName, String teacherName) {
    this.subjectId = subjectId;
    this.subjectName = subjectName;
    this.teacherName = teacherName;
  }

  @Override
  public String toString() {
    return "科目编号：" + this.subjectId + " 科目名称：" + this.subjectName +
      " 授课老师：" + this.teacherName;
  }
}

package com.thoughtworks.entities;

public class Subject {
  private int subjectId;
  private String subjectName;
  private String teacherName;

  public Subject() {
  }

  public Subject(int subjectId, String subjectName, String teacherName) {
    this.subjectId = subjectId;
    this.subjectName = subjectName;
    this.teacherName = teacherName;
  }

  public int getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(int subjectId) {
    this.subjectId = subjectId;
  }

  public String getSubjectName() {
    return subjectName;
  }

  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }

  public String getTeacherName() {
    return teacherName;
  }

  public void setTeacherName(String teacherName) {
    this.teacherName = teacherName;
  }

  @Override
  public String toString() {
    return "科目编号：" + this.subjectId + " 科目名称：" + this.subjectName +
      " 授课老师：" + this.teacherName;
  }
}

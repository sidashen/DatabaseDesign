package com.thoughtworks.entities;

public class Score {
  int studentId;
  int subjectId;
  String studentName;
  Float score;

  public Score() {
  }

  public Score(int studentId, int subjectId, String studentName, Float score) {
    this.studentId = studentId;
    this.subjectId = subjectId;
    this.studentName = studentName;
    this.score = score;
  }


  @Override
  public String toString() {
    return "学生学号：" + this.studentId + " 科目编号：" + this.subjectId +
      " 学生姓名：" + this.studentName + " 考试成绩：" + this.score;
  }
}

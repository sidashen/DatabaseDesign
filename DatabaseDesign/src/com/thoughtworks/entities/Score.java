package com.thoughtworks.entities;

public class Score {
  private int studentId;
  private int subjectId;
  private String studentName;
  private Float score;

  public Score() {
  }

  public Score(int studentId, int subjectId, String studentName, Float score) {
    this.studentId = studentId;
    this.subjectId = subjectId;
    this.studentName = studentName;
    this.score = score;
  }

  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  public int getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(int subjectId) {
    this.subjectId = subjectId;
  }

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public Float getScore() {
    return score;
  }

  public void setScore(Float score) {
    this.score = score;
  }

  @Override
  public String toString() {
    return "学生学号：" + this.studentId + " 科目编号：" + this.subjectId +
      " 学生姓名：" + this.studentName + " 考试成绩：" + this.score;
  }
}

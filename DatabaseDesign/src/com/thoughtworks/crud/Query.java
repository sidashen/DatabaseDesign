package com.thoughtworks.crud;

import com.thoughtworks.entities.Score;
import com.thoughtworks.entities.Student;
import com.thoughtworks.entities.Subject;
import com.thoughtworks.entities.Teacher;
import com.thoughtworks.preparedstatement.crud.PreparedStatementQuery;

import java.util.List;
import java.util.Scanner;

public class Query {

  public static void queryInfo(String instruction, Scanner scanner) {
    switch (instruction) {
      case "1.1.1":
        String sql = "select id, name, age, gender from student_info";
        List<Student> list = PreparedStatementQuery.queryInfoList(Student.class, sql);
        assert list != null;
        list.forEach(System.out::println);
        break;
      case "1.1.2":
        System.out.println("请输入学生姓名");
        String studentName = scanner.nextLine();
        String sql1 = "select name, id, age, gender from student_info where name = ?";
        List<Student> studentList = PreparedStatementQuery.queryInfoList(Student.class, sql1, studentName);
        assert studentList != null;
        studentList.forEach(System.out::println);
        String sql2 = "select score, subject_id subjectId, student_name studentName " +
          "from score_info where student_name = ?";
        List<Score> scoreList = PreparedStatementQuery.queryInfoList(Score.class, sql2, studentName);
        assert scoreList != null;
        scoreList.forEach(System.out::println);
        break;
      case "1.1.3":
        System.out.println("请输入老师姓名");
        String teacherName = scanner.nextLine();
        sql = "select student_id studentId, student_name studentName, score from score_info " +
          "where subject_id = (select id from subject_info where teacher = ?)";
        scoreList = PreparedStatementQuery.queryInfoList(Score.class, sql, teacherName);
        assert scoreList != null;
        scoreList.forEach(System.out::println);
        break;
      case "1.1.4":
        System.out.println("请输入科目编号");
        String subjectName = scanner.nextLine();
        sql = "select student_id studentId, subject_id subjectId, student_name studentName, score " +
          "from score_info where subject_id = ?";
        scoreList = PreparedStatementQuery.queryInfoList(Score.class, sql, subjectName);
        assert scoreList != null;
        scoreList.forEach(System.out::println);
        break;
      case "1.2.1":
        sql = "select id subjectId, subject_name subjectName, teacher teacherName from subject_info";
        List<Subject> subjectList = PreparedStatementQuery.queryInfoList(Subject.class, sql);
        assert subjectList != null;
        subjectList.forEach(System.out::println);
        break;
      case "1.2.2":
        System.out.println("请输入科目名称");
        subjectName = scanner.nextLine();
        sql = "select id subjectId, subject_name subjectName, teacher teacherName " +
          "from subject_info where subject_name = ?";
        subjectList = PreparedStatementQuery.queryInfoList(Subject.class, sql, subjectName);
        assert subjectList != null;
        subjectList.forEach(System.out::println);
        break;
      case "1.2.3":
        System.out.println("请输入教师姓名");
        teacherName = scanner.nextLine();
        sql = "select id subjectId, subject_name subjectName, teacher teacherName " +
          "from subject_info where teacher = ?";
        subjectList = PreparedStatementQuery.queryInfoList(Subject.class, sql, teacherName);
        assert subjectList != null;
        subjectList.forEach(System.out::println);
        break;
      case "1.":
        sql = "select id, name, age, gender from teacher_info";
        List<Teacher> teacherList = PreparedStatementQuery.queryInfoList(Teacher.class, sql);
        assert teacherList != null;
        teacherList.forEach(System.out::println);
        break;
      case "2.":
        System.out.println("请输入教师姓名");
        teacherName = scanner.nextLine();
        sql = "select name, id, age, gender from student_info where name = ?";
        teacherList = PreparedStatementQuery.queryInfoList(Teacher.class, sql, teacherName);
        assert teacherList != null;
        teacherList.forEach(System.out::println);
        break;
    }
  }
}

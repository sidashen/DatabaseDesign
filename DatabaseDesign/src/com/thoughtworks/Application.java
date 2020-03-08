package com.thoughtworks;

import com.thoughtworks.entities.Score;
import com.thoughtworks.entities.Student;
import com.thoughtworks.preparedstatement.crud.PreparedStatementQuery;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("您好，欢迎登陆学生考试系统，请输入您的用户名和密码(用户名:密码)：\n" +
      "例如：张三:123");
    List<String> userInfo = Arrays.asList(scanner.nextLine().split(":"));
    String username = "";
    String password = "";
    while (userInfo.size() != 2) {
      System.out.println("您好，请按照正确格式输入您的用户名和密码(用户名:密码)：\n" +
        "例如：张三:123");
      userInfo = Arrays.asList(scanner.nextLine().split(":"));
    }
    username = userInfo.get(0);
    password = userInfo.get(1);

    if ("林老师".equals(username) && "123".equals(password)) {
      managerFunction();
    }
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
    while (! isCorrectFormat(instruction)) {
      System.out.println("请输入正确指令");
      instruction = scanner.nextLine();
    }

    if (instruction.substring(0, 3).equals("1.1")) {
      queryInfo(instruction, scanner);
    }
  }

  public static Boolean isCorrectFormat(String input) {
    String rexp = "(\\d{1,4}\\.|\\d{1,4}\\.\\d{1,4}|\\d{1,4}\\.\\d{1,4}\\.\\d{1,4})";
    Pattern pat = Pattern.compile(rexp);
    Matcher mat = pat.matcher(input);
    return mat.find();
  }

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
    }
  }

}

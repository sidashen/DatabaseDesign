package com.thoughtworks;

import java.util.Scanner;

public class Application {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("您好，欢迎登陆学生考试系统，请输入您的用户名和密码(用户名:密码)：\n" +
      "例如：张三:123");
    String userInfo = scanner.nextLine();
  }
}

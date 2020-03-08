package com.thoughtworks;

import com.thoughtworks.entities.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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
      Manager.managerFunction();
    }
  }

}

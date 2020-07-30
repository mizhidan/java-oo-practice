package com.twu.Admin;

import java.util.Scanner;

public class AdminMenu {
    public static void verifyAdmin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的管理员用户名");
        String adminName = sc.next();
        System.out.println("请输入您的密码");
        String adminPwd = sc.next();
        if (adminName.equals("admin") && adminPwd.equals("admin123")) {
            showMenu();
        } else {
            System.out.println("用户名或密码错误");
        }

    }

    public static void showMenu() {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("你好，admin，你可以：");
            System.out.println("1.查看热搜排行榜");
            System.out.println("2.添加热搜");
            System.out.println("3.添加超级热搜");
            System.out.println("4.退出");
            switch (sc.next()) {
                case "1": break;
            }
        }
    }
}

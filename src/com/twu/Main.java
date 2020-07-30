package com.twu;

import com.twu.Admin.AdminMenu;
import com.twu.RankList.RankList;
import com.twu.Users.User;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RankList trendingList = new RankList();
        while(true) {
            System.out.println("欢迎来到热搜排行榜，你是？");
            System.out.println("1.用户");
            System.out.println("2.管理员");
            System.out.println("3.退出");
            switch (sc.next()) {
                case "1":
                    User user = new User();
                    user.showMenu(trendingList);
                    break;
                case "2":
                    AdminMenu.verifyAdmin();
                    break;
                case "3":
                    break;
                default:
                    break;
            }
        }
    }
}

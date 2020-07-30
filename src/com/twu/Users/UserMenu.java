package com.twu.Users;

import com.twu.RankList.RankList;

import java.util.Scanner;

public class UserMenu {
    private static String username;
//    private String username;
    private int voteNum = 10;

    public static void showMenu(RankList trendingList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的昵称");
        username = sc.next();
        while(true) {
            System.out.println("你好，" + username + ",你可以：");
            System.out.println("1.查看热搜排行榜");
            System.out.println("2.给热搜事件投票");
            System.out.println("3.购买热搜");
            System.out.println("4.添加热搜");
            System.out.println("5.退出");
            switch (sc.next()) {
                case "1": trendingList.showList();
                break;
//                case "2": voteForTrending();
            }
        }
    }

    public void voteForTrending() {

    }
}

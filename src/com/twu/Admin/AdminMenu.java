package com.twu.Admin;

import com.twu.RankList.RankList;
import com.twu.RankList.Trending;

import java.util.Scanner;

public class AdminMenu {
    public static void verifyAdmin(RankList trendingList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的管理员用户名");
        String adminName = sc.next();
        System.out.println("请输入您的密码");
        String adminPwd = sc.next();
        if (adminName.equals("admin") && adminPwd.equals("admin123")) {
            showMenu(trendingList);
        } else {
            System.out.println("用户名或密码错误");
        }

    }

    public static void showMenu(RankList trendingList) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("你好，admin，你可以：");
            System.out.println("1.查看热搜排行榜");
            System.out.println("2.添加热搜");
            System.out.println("3.添加超级热搜");
            System.out.println("4.退出");
            switch (sc.next()) {
                case "1": trendingList.showList();
                break;
                case "2": addTrending(trendingList);
                break;
                case "3": addSuperTrending(trendingList);
                break;
                case "4": return;
            }
        }
    }

    //添加热搜
    public static void addTrending(RankList trendingList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要添加的热搜名称：");
        String addedTrending = sc.next();
        for (Trending trending : trendingList.getList()) {
            if (addedTrending.equals(trending.getTrendingName())) {
                System.out.println("热搜已存在，不能再添加啦~");
                return;
            }
        }
        trendingList.addTrendingToList(new Trending(addedTrending, false));
    }

    //购买热搜
    public static void addSuperTrending(RankList trendingList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要添加的超级热搜名称：");
        String superTrendingName = sc.next();
        for (Trending trending : trendingList.getList()) {
            if (superTrendingName.equals(trending.getTrendingName())) {
                trending.setSuperTrending(true);
                return;
            }
        }
        trendingList.addTrendingToList(new Trending(superTrendingName, true));
    }
}

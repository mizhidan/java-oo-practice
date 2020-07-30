package com.twu.Users;

import com.twu.RankList.RankList;
import com.twu.RankList.Trending;

import java.util.Scanner;

public class User {
    private static String username;
//    private String username;
    private int voteNum = 10;

    public void showMenu(RankList trendingList) {
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
                case "2": voteForTrending(trendingList);
                break;
                case "3":
            }
        }
    }

    public void voteForTrending(RankList trendingList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要投票的热搜名称：");
        String boughtTrending = sc.next();
        System.out.println("请输入投票数量：");
        int voteForNum = sc.nextInt();
        if(voteForNum > voteNum) {
            System.out.println("票数不够啦");
            return;
        }
        for (Trending trending : trendingList.getList()) {
            if (boughtTrending.equals(trending.getTrendingName())) {
                trending.buyTrending(voteForNum);
                voteNum -= voteForNum;
                return;
            }
        }
        System.out.println("没有找到要投票的热搜");
    }

    public void buyTrending(RankList trendingList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要购买的热搜名称：");
        String boughtTrending = sc.next();
        System.out.println("请输入购买金额：");
        int voteForNum = sc.nextInt();
    }
}

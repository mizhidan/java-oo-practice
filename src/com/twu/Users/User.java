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
                case "3": buyTrending(trendingList);
                    break;
                case "4": addTrending(trendingList);
                    break;
                default:
                    break;
            }
        }
    }

    public void voteForTrending(RankList trendingList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要投票的热搜名称：");
        String votedTrending = sc.next();
        System.out.println("请输入投票数量：");
        int voteForNum = sc.nextInt();
        if(voteForNum > voteNum) {
            System.out.println("票数不够啦");
            return;
        }
        for (Trending trending : trendingList.getList()) {
            if (votedTrending.equals(trending.getTrendingName())) {
                trending.buyTrending(voteForNum);
                voteNum -= voteForNum;
                return;
            }
        }
        System.out.println("没有找到要投票的热搜");
    }

    public void addTrending(RankList trendingList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要添加的热搜名称：");
        String addedTrending = sc.next();
        for (Trending trending : trendingList.getList()) {
            if (addedTrending.equals(trending.getTrendingName())) {
                System.out.println("热搜已存在，不能再添加啦~");
                return;
            }
        }
        trendingList.addTrendingToList(new Trending(addedTrending));
    }

    public void buyTrending(RankList trendingList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你要购买的热搜名称：");
        String boughtTrendingName = sc.next();
        System.out.println("请输入你要购买的热搜排名：");
        int boughtForRanking = sc.nextInt() - 1;
        System.out.println("请输入购买金额：");
        int boughtPrice = sc.nextInt();
        Trending boughtTrending = new Trending(boughtTrendingName);
        boughtTrending.setIsBought();
        boughtTrending.setBoughtPrice(boughtPrice);
        int count = 0;
        for (Trending trending : trendingList.getList()) {
            if (boughtTrendingName.equals(trending.getTrendingName())) {
                boughtTrending.setVoteNum(trending.getVoteNum());
                break;
            }
            ++count;
        }
        if (trendingList.getList().get(boughtForRanking).getTrendingName().equals(boughtTrendingName)) {
            if (trendingList.getList().get(boughtForRanking).getBought()){
                if (trendingList.getList().get(boughtForRanking).getBoughtPrice() < boughtPrice) {
                    trendingList.getList().get(boughtForRanking).setBoughtPrice(boughtPrice);
                } else {
                    System.out.println("你付的钱没人家的多，买不了");
                }
            } else {
                trendingList.getList().get(boughtForRanking).setIsBought();
                trendingList.getList().get(boughtForRanking).setBoughtPrice(boughtPrice);
            }
        } else {
            if (trendingList.getList().get(boughtForRanking).getBought()) {
                if (trendingList.getList().get(boughtForRanking).getBoughtPrice() < boughtPrice) {
                    trendingList.getList().remove(boughtForRanking);
                    trendingList.getList().add(boughtForRanking, boughtTrending);
                    trendingList.getList().remove(count);
                } else {
                    System.out.println("你付的钱没人家的多，买不了");
                }
            } else {
                if (count < boughtForRanking) {
                    trendingList.getList().remove(count);
                    trendingList.getList().add(boughtForRanking, boughtTrending);
                } else {
                    trendingList.getList().add(boughtForRanking, boughtTrending);
                    trendingList.getList().remove(count + 1);
                }
            }
        }
    }
}

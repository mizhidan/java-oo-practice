package com.twu.RankList;

import java.util.*;

public class RankList {
    List<Trending> list = new ArrayList<>();

    public void showList() {
        int number = 1;
        for (Trending trending : list) {
            System.out.println(number + "." + trending.getTrendingName() + " " + trending.getVoteNum());
            ++number;
        }
    }



    public void addTrendingToList(Trending trending){
        list.add(trending);
    }

    public List<Trending> getList() {
        return list;
    }
}

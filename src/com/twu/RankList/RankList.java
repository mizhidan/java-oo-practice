package com.twu.RankList;

import java.util.*;

public class RankList {
    List<Trending> list = new ArrayList<>();

    public void showList() {
        for (Trending trending : list) {
            int number = 1;
            System.out.println(number + "." + trending.getTrendingName() + " " + trending.getVoteNum());
            ++number;
        }
    }

    public List<Trending> getList() {
        return list;
    }
}

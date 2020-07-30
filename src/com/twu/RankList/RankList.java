package com.twu.RankList;

import java.util.*;
import java.util.stream.Collectors;

public class RankList {
    List<Trending> list = new ArrayList<>();

    public void showList() {
        int number = 1;
        for (Trending trending : list) {
            System.out.println(number + "." + trending.getTrendingName() + " " + trending.getVoteNum());
            ++number;
        }
    }

    public void sorted() {
        List<Trending> sortedList = this.list.stream().filter((Trending trending) -> !trending.getBought())
                .collect(Collectors.toList());
        Collections.sort(sortedList, new Comparator<Trending>() {
            @Override
            public int compare(Trending o1, Trending o2) {
                return o2.getVoteNum() - o1.getVoteNum();
            }
        });
        for (Trending trending : this.list) {
            if (trending.getBought()) {
                sortedList.add(trending.getBoughtRanking(), trending);
            }
        }
        this.list = sortedList;
    }

    public void addTrendingToList(Trending trending){
        list.add(trending);
    }

    public List<Trending> getList() {
        return list;
    }
}

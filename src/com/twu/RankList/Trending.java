package com.twu.RankList;

public class Trending {
    private String trendingName;
    private int voteNum = 0;
    private Boolean isBought = false;
    private int boughtPrice = 0;

    public Trending(String trendingName, int voteNum, Boolean isBought) {
        this.trendingName = trendingName;
        this.voteNum = voteNum;
        this.isBought = isBought;
    }

    public void buyTrending(int buyNumber) {
        voteNum += buyNumber;
    }

    public void setIsBought() {
        this.isBought = true;
    }

    public String getTrendingName() {
        return trendingName;
    }

    public int getVoteNum() {
        return voteNum;
    }
}

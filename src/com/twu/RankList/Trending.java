package com.twu.RankList;

public class Trending {
    private String trendingName;
    private int voteNum = 0;
    private Boolean isBought = false;
    private int boughtPrice = 0;
    private Boolean isSuperTrending = false;
    private int boughtRanking;

    public Trending(String trendingName, Boolean isSuperTrending) {
        this.trendingName = trendingName;
        this.isSuperTrending = isSuperTrending;
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

    public void setVoteNum(int voteNum) {
        this.voteNum = voteNum;
    }

    public int getVoteNum() {
        return voteNum;
    }

    public void setBoughtPrice(int boughtPrice) {
        this.boughtPrice = boughtPrice;
    }

    public int getBoughtPrice() {
        return boughtPrice;
    }

    public Boolean getBought() {
        return isBought;
    }

    public int getBoughtRanking() {
        return boughtRanking;
    }

    public void setBoughtRanking(int boughtRanking) {
        this.boughtRanking = boughtRanking;
    }

    public Boolean getSuperTrending() {
        return isSuperTrending;
    }

    public void setSuperTrending(Boolean superTrending) {
        isSuperTrending = superTrending;
    }
}

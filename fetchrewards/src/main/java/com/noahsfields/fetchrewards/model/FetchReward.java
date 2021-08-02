package com.noahsfields.fetchrewards.model;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

public class FetchReward implements Comparable<FetchReward> {
    private String payer;
    private Integer points;
    private Instant timestamp;

    public FetchReward(String payer, int points, Instant timestamp) {
        this.payer = payer;
        this.points = points;
        this.timestamp = timestamp;
    }

    public String getPayer() {
        return payer;
    }

    public Integer getPoints() {
        return points;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    @Override
    public int compareTo(FetchReward o) {
        return this.timestamp.compareTo(o.timestamp);
    }

    public int subtractPoints(int amount) {
        int p = points;
        this.points = points - amount;
        if (this.points < 0){
            this.points = 0;
        }
        return amount - p > 0? amount- p : 0;
    }
}


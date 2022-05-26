package com.example.assignment.models;

public class Stats {
    private long tipCount;
    private long usersCount;
    private long checkinsCount;

    public long getTipCount() {
        return tipCount;
    }

    public void setTipCount(long value) {
        this.tipCount = value;
    }

    public long getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(long value) {
        this.usersCount = value;
    }

    public long getCheckinsCount() {
        return checkinsCount;
    }

    public void setCheckinsCount(long value) {
        this.checkinsCount = value;
    }
}

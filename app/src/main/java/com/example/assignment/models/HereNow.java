package com.example.assignment.models;

public class HereNow {
    private long count;
    private Summary summary;
    private Object[] groups;

    public long getCount() {
        return count;
    }

    public void setCount(long value) {
        this.count = value;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary value) {
        this.summary = value;
    }

    public Object[] getGroups() {
        return groups;
    }

    public void setGroups(Object[] value) {
        this.groups = value;
    }
}

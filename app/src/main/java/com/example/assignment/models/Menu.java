package com.example.assignment.models;

public class Menu {
    private String type;
    private String label;
    private String anchor;
    private String url;
    private String mobileURL;

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String value) {
        this.label = value;
    }

    public String getAnchor() {
        return anchor;
    }

    public void setAnchor(String value) {
        this.anchor = value;
    }

    public String getURL() {
        return url;
    }

    public void setURL(String value) {
        this.url = value;
    }

    public String getMobileURL() {
        return mobileURL;
    }

    public void setMobileURL(String value) {
        this.mobileURL = value;
    }
}

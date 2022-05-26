package com.example.assignment.models;

public class Category {
    private String id;
    private String name;
    private String pluralName;
    private String shortName;
    private Icon icon;
    private boolean primary;

    public String getID() {
        return id;
    }

    public void setID(String value) {
        this.id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getPluralName() {
        return pluralName;
    }

    public void setPluralName(String value) {
        this.pluralName = value;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String value) {
        this.shortName = value;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon value) {
        this.icon = value;
    }

    public boolean getPrimary() {
        return primary;
    }

    public void setPrimary(boolean value) {
        this.primary = value;
    }
}

package com.example.assignment.models;

public class SavedMatches_Model {
    String Name;
    String Address;
    float Stars;

    public SavedMatches_Model(String name, String address, float stars) {
        Name = name;
        Address = address;
        Stars = stars;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public float getStars() {
        return Stars;
    }

    public void setStars(Integer stars) {
        Stars = stars;
    }
}

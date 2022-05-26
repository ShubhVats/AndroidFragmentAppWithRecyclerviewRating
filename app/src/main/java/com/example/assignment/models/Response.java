package com.example.assignment.models;

public class Response {
    private Venue[] venues;
    private boolean confident;

    public Venue getVenues(Integer integer) {
        return venues[integer];
    }

    public Venue[] getVenues() {
        return venues;
    }

    public void setVenues(Venue[] value) {
        this.venues = value;
    }

    public boolean getConfident() {
        return confident;
    }

    public void setConfident(boolean value) {
        this.confident = value;
    }
}

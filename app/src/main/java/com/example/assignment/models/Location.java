package com.example.assignment.models;

public class Location {
    private String address;
    private String crossStreet;
    private double lat;
    private double lng;
    private LabeledLatLng[] labeledLatLngs;
    private long distance;
    private String postalCode;
    private Cc cc;
    private City city;
    private State state;
    private Country country;
    private String[] formattedAddress;
    private String neighborhood;

    public String getAddress() {
        return address;
    }

    public void setAddress(String value) {
        this.address = value;
    }

    public String getCrossStreet() {
        return crossStreet;
    }

    public void setCrossStreet(String value) {
        this.crossStreet = value;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double value) {
        this.lat = value;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double value) {
        this.lng = value;
    }

    public LabeledLatLng[] getLabeledLatLngs() {
        return labeledLatLngs;
    }

    public void setLabeledLatLngs(LabeledLatLng[] value) {
        this.labeledLatLngs = value;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long value) {
        this.distance = value;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String value) {
        this.postalCode = value;
    }

    public Cc getCc() {
        return cc;
    }

    public void setCc(Cc value) {
        this.cc = value;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City value) {
        this.city = value;
    }

    public State getState() {
        return state;
    }

    public void setState(State value) {
        this.state = value;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country value) {
        this.country = value;
    }

    public String[] getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String[] value) {
        this.formattedAddress = value;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String value) {
        this.neighborhood = value;
    }
}

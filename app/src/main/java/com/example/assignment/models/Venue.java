package com.example.assignment.models;

public class Venue {
    private String id;
    private String name;
    private Contact contact;
    private Location location;
    private Category[] categories;
    private boolean verified;
    private Stats stats;
    private BeenHere beenHere;
    private VenuePage venuePage;
    private HereNow hereNow;
    private ReferralID referralID;
    private Object[] venueChains;
    private boolean hasPerk;
    private String url;
    private Boolean venueRatingBlacklisted;
    private String storeID;
    private Boolean allowMenuURLEdit;
    private Boolean hasMenu;
    private Menu menu;

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

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact value) {
        this.contact = value;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location value) {
        this.location = value;
    }

    public Category[] getCategories() {
        return categories;
    }

    public void setCategories(Category[] value) {
        this.categories = value;
    }

    public boolean getVerified() {
        return verified;
    }

    public void setVerified(boolean value) {
        this.verified = value;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats value) {
        this.stats = value;
    }

    public BeenHere getBeenHere() {
        return beenHere;
    }

    public void setBeenHere(BeenHere value) {
        this.beenHere = value;
    }

    public VenuePage getVenuePage() {
        return venuePage;
    }

    public void setVenuePage(VenuePage value) {
        this.venuePage = value;
    }

    public HereNow getHereNow() {
        return hereNow;
    }

    public void setHereNow(HereNow value) {
        this.hereNow = value;
    }

    public ReferralID getReferralID() {
        return referralID;
    }

    public void setReferralID(ReferralID value) {
        this.referralID = value;
    }

    public Object[] getVenueChains() {
        return venueChains;
    }

    public void setVenueChains(Object[] value) {
        this.venueChains = value;
    }

    public boolean getHasPerk() {
        return hasPerk;
    }

    public void setHasPerk(boolean value) {
        this.hasPerk = value;
    }

    public String getURL() {
        return url;
    }

    public void setURL(String value) {
        this.url = value;
    }

    public Boolean getVenueRatingBlacklisted() {
        return venueRatingBlacklisted;
    }

    public void setVenueRatingBlacklisted(Boolean value) {
        this.venueRatingBlacklisted = value;
    }

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String value) {
        this.storeID = value;
    }

    public Boolean getAllowMenuURLEdit() {
        return allowMenuURLEdit;
    }

    public void setAllowMenuURLEdit(Boolean value) {
        this.allowMenuURLEdit = value;
    }

    public Boolean getHasMenu() {
        return hasMenu;
    }

    public void setHasMenu(Boolean value) {
        this.hasMenu = value;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu value) {
        this.menu = value;
    }
}

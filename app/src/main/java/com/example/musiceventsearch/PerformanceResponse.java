package com.example.musiceventsearch;

public class PerformanceResponse {
    private ArtistResponse artist;
    private String displayName;
    private int billingIndex;
    private int id;
    private String billing;

    public PerformanceResponse() {
    }

    public ArtistResponse getArtist() {
        return artist;
    }

    public void setArtist(ArtistResponse artist) {
        this.artist = artist;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public int getBillingIndex() {
        return billingIndex;
    }

    public void setBillingIndex(int billingIndex) {
        this.billingIndex = billingIndex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBilling() {
        return billing;
    }

    public void setBilling(String billing) {
        this.billing = billing;
    }
}

package com.example.musiceventsearch;


import android.location.Location;

import java.lang.reflect.Array;


public class EventResponse {
    private int id;
    private String type;
    private String uri;
    private String displayName;
    private DateTime start;
    private DateTime end;
    private Array performance;
    private LocationResponse location;
    private VenueResponse venue;
    private String status;
    private String ageRestriction;

    public EventResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public DateTime getStart() {
        return start;
    }

    public void setStart(DateTime start) {
        this.start = start;
    }

    public DateTime getEnd() {
        return end;
    }

    public void setEnd(DateTime end) {
        this.end = end;
    }

    public Array getPerformance() {
        return performance;
    }

    public void setPerformance(Array performance) {
        this.performance = performance;
    }

    public LocationResponse getLocation() {
        return location;
    }

    public void setLocation(LocationResponse location) {
        this.location = location;
    }

    public VenueResponse getVenue() {
        return venue;
    }

    public void setVenue(VenueResponse venue) {
        this.venue = venue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAgeRestriction() {
        return ageRestriction;
    }

    public void setAgeRestriction(String ageRestriction) {
        this.ageRestriction = ageRestriction;
    }
}

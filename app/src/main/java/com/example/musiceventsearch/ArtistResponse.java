package com.example.musiceventsearch;

import java.lang.reflect.Array;
import java.util.Date;

public class ArtistResponse {
    private int id;
    private String displayName;
    private String uri;
    private Array identifier;
    private Date onTourUntil;

    public ArtistResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Array getIdentifier() {
        return identifier;
    }

    public void setIdentifier(Array identifier) {
        this.identifier = identifier;
    }

    public Date getOnTourUntil() {
        return onTourUntil;
    }

    public void setOnTourUntil(Date onTourUntil) {
        this.onTourUntil = onTourUntil;
    }
}

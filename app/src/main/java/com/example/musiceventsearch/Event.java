package com.example.musiceventsearch;

import java.lang.reflect.Array;
import java.util.List;

public class Event {
    private String displayName;

    public Event() {
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }

}

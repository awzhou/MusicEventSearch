package com.example.musiceventsearch;

import java.util.List;

public class Results {
    private List<Event> event;

    public Results() {
    }

    public List<Event> getEvent() {
        return event;
    }

    public void setEvent(List<Event> event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return event.toString();
    }
}

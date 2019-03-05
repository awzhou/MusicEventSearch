package com.example.musiceventsearch;


import android.location.Location;

import java.lang.reflect.Array;
import java.util.List;


public class ResultsPage {
    private String status;
    private List<Event> results;

    public ResultsPage() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Event> getResults() {
        return results;
    }

    public void setResults(List<Event> results) {
        this.results = results;
    }
}

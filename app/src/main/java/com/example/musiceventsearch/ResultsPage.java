package com.example.musiceventsearch;


import android.location.Location;

import java.lang.reflect.Array;
import java.util.List;


public class ResultsPage {
    private Results results;

    public ResultsPage() {
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return results.toString();
    }
}

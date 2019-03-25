package com.example.musiceventsearch;

public class ResultsResponse {
    private ResultsPage resultsPage;

    public ResultsResponse() {
    }

    public ResultsPage getResultsPage() {
        return resultsPage;
    }

    public void setResultsPage(ResultsPage resultsPage) {
        this.resultsPage = resultsPage;
    }

    @Override
    public String toString() {
        return resultsPage.toString();
    }
}

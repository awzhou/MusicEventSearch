package com.example.musiceventsearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

public class ResultsActivity extends AppCompatActivity {

    private ListView listViewResults;
    private Results results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        results = MainActivity.eve

        listViewResults = findViewById(R.id.listView_results);
        populateListView();
    }

    private void populateListView() {
        ResultsAdapter adapter = new ResultsAdapter(ResultsActivity.this, R.layout.item_eventlist, results.getEvent());
        listViewResults.setAdapter(adapter);
        Toast.makeText(ResultsActivity.this, "Data Successfully Loaded", Toast.LENGTH_SHORT).show();
    }
}

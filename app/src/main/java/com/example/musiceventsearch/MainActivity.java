package com.example.musiceventsearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    // apikey=G5gsLNsWUaocEC2p
    private static final String API_KEY = "G5gsLNsWUaocEC2p";

    private String artistName;
    private String location;
    private String minDate;
    private String maxDate;
    private String type;
    private String page;
    private String perPage;

    private EditText editTextQuery;
    private RadioGroup radioGroupEventType;
    private ListView listViewResults;
    private Button buttonSubmit;

    private static final int PER_PAGE = 50;

    public static final String EXTRA = "events";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get values
                getValues();

                // perform tests
                if (artistName.length() == 0) {
                    Toast.makeText(MainActivity.this, "Please input a query.", Toast.LENGTH_SHORT).show();
                }
                else if (type == null) {
                    Toast.makeText(MainActivity.this, "Please select an event type.", Toast.LENGTH_SHORT).show();
                }
                else {
                    searchEvents();
                }
            }
        });
    }

    private void getValues() {
        artistName = editTextQuery.getText().toString().toLowerCase();

        if(radioGroupEventType.getCheckedRadioButtonId()!=-1) {
            int id = radioGroupEventType.getCheckedRadioButtonId();
            View radioButton = radioGroupEventType.findViewById(id);
            int radioId = radioGroupEventType.indexOfChild(radioButton);
            RadioButton btn = (RadioButton) radioGroupEventType.getChildAt(radioId);
            type = (String) btn.getText();
        }

        perPage = PER_PAGE + "";
    }

    private void wireWidgets() {
        editTextQuery = findViewById(R.id.editText_main_artist);
        radioGroupEventType = findViewById(R.id.radioGroup);
        listViewResults = findViewById(R.id.listView_main);
        buttonSubmit = findViewById(R.id.button_main_submit);
    }

    private void searchEvents() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.songkick.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SongKickService service =
                retrofit.create(SongKickService.class);

        Call<ResultsResponse> resultsPageCall =
                service.searchByEvent(API_KEY, artistName);

        resultsPageCall.enqueue(new Callback<ResultsResponse>() {
            @Override
            public void onResponse(Call<ResultsResponse> call, Response<ResultsResponse> response) {
                List<Event> events = response.body().getResultsPage().getResults().getEvent();

                populateListView(events);

                // Log.d("BODY", response.body().getResults() + "");
                Log.d("ENQUEUE", "onResponse: " + events.toString());
            }

            @Override
            public void onFailure(Call<ResultsResponse> call, Throwable t) {
                Log.d("ENQUEUE", "onFailure: " + t.getMessage());
            }
        });

    }

    private void populateListView(List<Event> events) {
        ResultsAdapter adapter = new ResultsAdapter(MainActivity.this, R.layout.item_eventlist, events);
        listViewResults.setAdapter(adapter);
    }
}

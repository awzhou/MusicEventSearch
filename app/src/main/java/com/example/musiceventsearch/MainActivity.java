package com.example.musiceventsearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

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
    // private EditText editTextWhere;
    private EditText editTextStartDate;
    private EditText editTextEndDate;
    private RadioGroup radioGroupEventType;
    private EditText editTextPageNumber;
    private Button buttonSubmit;

    private static final int PER_PAGE = 50;

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
                else if ((minDate == null && maxDate != null) || (minDate != null && maxDate == null)) {
                    Toast.makeText(MainActivity.this, "You must provide both a minimum date ad a maximum date.", Toast.LENGTH_SHORT).show();
                }
                else if (type == null) {
                    Toast.makeText(MainActivity.this, "Please select an event type.", Toast.LENGTH_SHORT).show();
                }
                else if (page == null) {
                    page = 1 + "";
                    searchEvents();
                }
                else {
                    searchEvents();
                }
            }
        });
    }

    private void getValues() {
        String artistNameQuery = editTextQuery.getText().toString();
        for (int i = 0; i < artistNameQuery.length(); i++) {
            if (artistNameQuery.substring(i, i).equals(" ")) {
                artistName += "+";
            }
            else {
                artistName += artistNameQuery.substring(i, i+ 1);
            }
        }

        location = "sk:17835";

        minDate = editTextStartDate.getText().toString();
        maxDate = editTextEndDate.getText().toString();

        if(radioGroupEventType.getCheckedRadioButtonId()!=-1) {
            int id = radioGroupEventType.getCheckedRadioButtonId();
            View radioButton = radioGroupEventType.findViewById(id);
            int radioId = radioGroupEventType.indexOfChild(radioButton);
            RadioButton btn = (RadioButton) radioGroupEventType.getChildAt(radioId);
            type = (String) btn.getText();
        }

        page = editTextPageNumber.getText().toString();
        perPage = PER_PAGE + "";
    }

    private void wireWidgets() {
        editTextQuery = findViewById(R.id.editText_main_artist);
        editTextStartDate = findViewById(R.id.editText_main_minDate);
        editTextEndDate = findViewById(R.id.editText_main_maxDate);
        radioGroupEventType = findViewById(R.id.radioGroup);
        editTextPageNumber = findViewById(R.id.editText_main_page);
        buttonSubmit = findViewById(R.id.button_main_submit);
    }

    private void searchEvents() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.songkick.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SongKickService service =
                retrofit.create(SongKickService.class);

        // Call<EventResponse> eventResponseCall =
                // service.searchByEvent(API_KEY, artistName, location, minDate, maxDate, type, page, perPage);
        Call<ResultsPage> resultsPageCall =
                service.searchByEvent(API_KEY, artistName);

        resultsPageCall.enqueue(new Callback<ResultsPage>() {
            @Override
            public void onResponse(Call<ResultsPage> call, Response<ResultsPage> response) {
                List<Event> events = response.body().getResults();
                Log.d("ENQUEUE", "onResponse: " + events.toString());
            }

            @Override
            public void onFailure(Call<ResultsPage> call, Throwable t) {
                Log.d("ENQUEUE", "onFailure: " + t.getMessage());
            }
        });

    }
}

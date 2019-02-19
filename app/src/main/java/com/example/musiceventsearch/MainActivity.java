package com.example.musiceventsearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    // apikey=G5gsLNsWUaocEC2p

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchEvents();
    }

    private void searchEvents() {

        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl("https://api.songkick.com/api/3.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        SongKickService service =
                retrofit.create(SongKickService.class);

    }
}

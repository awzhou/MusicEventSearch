package com.example.musiceventsearch;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SongKickService {

    @GET("api/3.0/events.json")
    Call<ResultsResponse> searchByEvent(
       @Query("apikey") String apiKey,
       @Query("artist_name") String artistName
//       @Query("location") String location,
//       @Query("min_date") String minDate,
//       @Query("max_date") String maxDate,
//       @Query("type") String type,
//       @Query("page") String page,
//       @Query("per_page") String perPage
    );
}

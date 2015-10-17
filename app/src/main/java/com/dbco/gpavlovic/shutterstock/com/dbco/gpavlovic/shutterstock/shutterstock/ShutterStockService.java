package com.dbco.gpavlovic.shutterstock.com.dbco.gpavlovic.shutterstock.shutterstock;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;

public interface ShutterStockService
{
    @GET("/v2/images/search")
    Call<ShutterResponse> searchImages(@Query("query") String query);

    @GET("/v2/images/search")
    Call<ShutterResponse> recentImages(@Query("added_date_start") String date);
}

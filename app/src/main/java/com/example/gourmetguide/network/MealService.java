package com.example.gourmetguide.network;

import com.example.gourmetguide.model.MealResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MealService {
    @GET("json/v1/1/random.php")
    Call<MealResponse> getMeals();
}

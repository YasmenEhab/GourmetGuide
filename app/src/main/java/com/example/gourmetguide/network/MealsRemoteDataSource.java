package com.example.gourmetguide.network;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public interface MealsRemoteDataSource {
    void makeNetworkCall(NetworkCallback networkCallback);
    void makeNetworkCall2(NetworkCallback networkCallback, ApiType apiType);
    public void getMealsByNameFromNetwork(NetworkCallback networkCallback, String mealName);
    public void getMealsByCategoryFromNetwork(NetworkCallback networkCallback, String category);
    public void getMealsByCountryFromNetwork(NetworkCallback networkCallback, String country);
    public void getMealsByIngredientFromNetwork(NetworkCallback networkCallback, String ingredient);

    enum ApiType {
        RANDOM_MEAL,
        CATEGORY,
        COUNTRY
    }

}

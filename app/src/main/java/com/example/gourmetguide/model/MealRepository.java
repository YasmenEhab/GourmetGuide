package com.example.gourmetguide.model;

import androidx.lifecycle.LiveData;

import com.example.gourmetguide.network.NetworkCallback;

import java.util.List;

public interface MealRepository {
    LiveData<List<Meal>> getStoredMeals(); //from room database
    void deleteMeal(Meal meal);
    void insertMeal(Meal meal);
    void fetchMealFromAPI  (NetworkCallback callback);
    public void fetchCategoryFromAPI(NetworkCallback callback);


}

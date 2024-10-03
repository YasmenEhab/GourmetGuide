package com.example.gourmetguide.model;

import androidx.lifecycle.LiveData;

import com.example.gourmetguide.network.NetworkCallback;

import java.util.Date;
import java.util.List;

public interface MealRepository {
    LiveData<List<Meal>> getStoredMeals(); //from room database
    void deleteMeal(Meal meal);
    void insertMeal(Meal meal);
    void fetchMealFromAPI  (NetworkCallback callback);
    public void fetchCategoryFromAPI(NetworkCallback callback);
    public void getMealsByName(NetworkCallback networkCallback, String mealName);
    public void getMealsByCategory(NetworkCallback networkCallback, String category);
    public void getMealsByCountry(NetworkCallback networkCallback, String country);
    public void getMealsByIngredient(NetworkCallback networkCallback, String ingredient);
    public LiveData<List<MealPlan>> getPlannedMeals();
    public LiveData<List<MealPlan>> getPlanMeals(Date date);
    public void insertMealToPlan(MealPlan meal, Date date);
}

package com.example.gourmetguide.db;

import androidx.lifecycle.LiveData;

import com.example.gourmetguide.model.Meal;
import com.example.gourmetguide.model.MealPlan;

import java.util.Date;
import java.util.List;

public interface MealsLocalDataSource {
    void insertMeal(Meal meal);
    void deleteMeal(Meal meal);
    LiveData<List<Meal>> getStoredData();
    public LiveData<List<MealPlan>> getPlannedMeals();
    public LiveData<List<MealPlan>> getPlanMeals(Date date);
    public void insertMealToPlan(MealPlan meal, Date date);

}

package com.example.gourmetguide.db;

import androidx.lifecycle.LiveData;

import com.example.gourmetguide.model.Meal;

import java.util.List;

public interface MealsLocalDataSource {
    void insertMeal(Meal meal);
    void deleteMeal(Meal meal);
    LiveData<List<Meal>> getStoredData();
}

package com.example.gourmetguide.mealFav.presenter;

import androidx.lifecycle.LiveData;

import com.example.gourmetguide.model.Meal;

import java.util.List;

public interface MealFavPresenter {
    public LiveData<List<Meal>> getMeals();
    public void deleteFromFav(Meal meal);
}

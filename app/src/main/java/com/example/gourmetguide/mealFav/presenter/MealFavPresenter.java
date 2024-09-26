package com.example.gourmetguide.mealFav.presenter;

import androidx.lifecycle.LiveData;

import com.example.gourmetguide.model.Meal;

import java.util.List;

public interface MealFavPresenter {
    public LiveData<List<Meal>> getProducts();
    public void deleteFromFav(Meal meal);
}

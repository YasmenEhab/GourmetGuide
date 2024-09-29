package com.example.gourmetguide.mealFav.view;

import com.example.gourmetguide.model.Meal;

import java.util.List;

public interface MealFavView {
    public void showData(List<Meal> meals);
    public void showErrMsg (String error);
}

package com.example.gourmetguide.mealDetail.presenter;

import com.example.gourmetguide.model.Meal;

public interface MealDetailPresenter {
    public void getMeals();
    public void addToFav(Meal meal);

}

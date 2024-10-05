package com.example.gourmetguide.mealDetail.presenter;

import com.example.gourmetguide.model.Meal;
import com.example.gourmetguide.model.MealPlan;

public interface MealDetailPresenter {

    public void addToFav(Meal meal);
    public void addToPlan(Meal meal, long dateInMillis);
    public void getByMealName(String mealName) ;

}
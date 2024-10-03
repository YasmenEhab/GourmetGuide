package com.example.gourmetguide.mealplan.presenter;

import androidx.lifecycle.LiveData;

import com.example.gourmetguide.model.Meal;
import com.example.gourmetguide.model.MealPlan;

import java.util.Date;
import java.util.List;

public interface PlanPresenter {
    public LiveData<List<MealPlan>> getPlannedMeals(Date date);
    //public void deleteFromFav(MealPlan meal);
}

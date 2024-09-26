package com.example.gourmetguide.mealDetail.viewer;

import com.example.gourmetguide.model.Meal;

import java.util.List;

public interface MealDetailView {
    public void showData(List<Meal> meals);
    public void showErrMsg (String error);

}

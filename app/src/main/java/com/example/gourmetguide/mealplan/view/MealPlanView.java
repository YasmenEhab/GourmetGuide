package com.example.gourmetguide.mealplan.view;

import com.example.gourmetguide.model.MealPlan;

import java.util.List;

public interface MealPlanView {
    public void showData(List<MealPlan> meals);
    public void showErrMsg(String error);
}

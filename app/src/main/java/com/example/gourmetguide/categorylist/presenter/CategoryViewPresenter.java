package com.example.gourmetguide.categorylist.presenter;

import com.example.gourmetguide.model.Meal;

public interface CategoryViewPresenter {
    public void getMeals(String category);
    public void ShowDetails(Meal meal);
}

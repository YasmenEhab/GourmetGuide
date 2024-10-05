package com.example.gourmetguide.arealist.presenter;

import com.example.gourmetguide.model.Meal;

public interface AreaListPresenter {
    public void getMeals(String country);
    public void ShowDetails(Meal meal);
}

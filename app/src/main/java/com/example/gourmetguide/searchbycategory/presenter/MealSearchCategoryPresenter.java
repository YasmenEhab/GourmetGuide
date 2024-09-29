package com.example.gourmetguide.searchbycategory.presenter;

import com.example.gourmetguide.model.Meal;

public interface MealSearchCategoryPresenter {
    public void getMeals();
    public void ShowDetails(Meal meal);
    public void getCategories();

}

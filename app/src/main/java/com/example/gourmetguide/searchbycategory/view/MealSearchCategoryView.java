package com.example.gourmetguide.searchbycategory.view;

import com.example.gourmetguide.model.Category;
import com.example.gourmetguide.model.Meal;

import java.util.List;

public interface MealSearchCategoryView {
    public void showData(List<Meal> meals);
    public void showErrMsg (String error);
    public void showCategory(List<Category> categories);
}

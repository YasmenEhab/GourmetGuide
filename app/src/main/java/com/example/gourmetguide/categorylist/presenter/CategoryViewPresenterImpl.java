package com.example.gourmetguide.categorylist.presenter;

import com.example.gourmetguide.categorylist.view.CategoryView;
import com.example.gourmetguide.model.Area;
import com.example.gourmetguide.model.Category;
import com.example.gourmetguide.model.Meal;
import com.example.gourmetguide.model.MealRepository;
import com.example.gourmetguide.network.NetworkCallback;
import com.example.gourmetguide.search.view.MealSearchView;

import java.util.List;

public class CategoryViewPresenterImpl implements CategoryViewPresenter , NetworkCallback
{
    private CategoryView _view;
    private MealRepository _repo;

    public CategoryViewPresenterImpl(CategoryView _view, MealRepository _repo) {
        this._view = _view;
        this._repo = _repo;
    }
    @Override
    public void getMeals(String category) {
        _repo.getMealsByCategory(this, category);

    }

    @Override
    public void ShowDetails(Meal meal) {

    }

    @Override
    public void onSuccessfulResponse(List<Meal> meals) {
        _view.showData(meals);
    }

    @Override
    public void onSuccessfulResponseCategory(List<Category> categories) {
        _view.showCategory(categories);
    }

    @Override
    public void onSuccessfulResponseArea(List<Area> areas) {

    }

    @Override
    public void onFailureResponse(String errorMessage) {
        _view.showErrMsg(errorMessage);
    }
}

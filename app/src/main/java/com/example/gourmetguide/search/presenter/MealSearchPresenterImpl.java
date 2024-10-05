package com.example.gourmetguide.search.presenter;

import android.util.Log;

import com.example.gourmetguide.mealOfTheDay.presenter.MealDayPresenter;
import com.example.gourmetguide.mealOfTheDay.view.MealDayView;
import com.example.gourmetguide.model.Area;
import com.example.gourmetguide.model.Category;
import com.example.gourmetguide.model.Meal;
import com.example.gourmetguide.model.MealRepository;
import com.example.gourmetguide.network.NetworkCallback;
import com.example.gourmetguide.search.view.MealSearchView;

import java.util.List;

public class MealSearchPresenterImpl implements MealSearchPresenter, NetworkCallback {

    private MealSearchView _view;
    private MealRepository _repo;

    public MealSearchPresenterImpl(MealSearchView _view, MealRepository _repo) {
        this._view = _view;
        this._repo = _repo;
    }

    @Override
    public void getMeals() {
        _repo.fetchMealFromAPI(this);
    }

    @Override
    public void getCategories() {
        Log.e("SearchCategoryPresenter", "  _repo.fetchCategoryFromAPI ");
        _repo.fetchCategoryFromAPI(this);
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


    public void serchByCountry(String country) {
        _repo.getMealsByCountry(this, country);
    }

    public void serchByCategory(String category) {
        _repo.getMealsByCategory(this, category);
    }

    public void serchByIngredient(String ingredient) {
        _repo.getMealsByIngredient(this, ingredient);
    }

    public void serchByMealName(String mealName) {
        _repo.getMealsByName(this, mealName);
    }


}

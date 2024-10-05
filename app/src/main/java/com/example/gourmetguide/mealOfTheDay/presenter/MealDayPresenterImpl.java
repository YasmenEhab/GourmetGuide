package com.example.gourmetguide.mealOfTheDay.presenter;

import android.util.Log;

import com.example.gourmetguide.mealOfTheDay.view.MealDayView;
import com.example.gourmetguide.model.Area;
import com.example.gourmetguide.model.Category;
import com.example.gourmetguide.model.Meal;
import com.example.gourmetguide.model.MealRepository;
import com.example.gourmetguide.network.NetworkCallback;

import java.util.List;

public class MealDayPresenterImpl implements MealDayPresenter, NetworkCallback {

    private MealDayView _view;
    private MealRepository _repo;

    public MealDayPresenterImpl(MealDayView _view,MealRepository _repo)
    {
        this._repo = _repo;
        this._view = _view;
    }

    @Override
    public void getMeals() {
        _repo.fetchMealFromAPI(this);
        Log.i("MealDayPresenter", "  _repo.fetchCategoryFromAPI ");
    }

    @Override
    public void getCategories() {
        Log.e("SearchCategoryPresenter", "  _repo.fetchCategoryFromAPI ");
        _repo.fetchCategoryFromAPI(this);
    }

    @Override
    public void getAreas() {
        Log.e("SearchCategoryPresenter", "  _repo.fetchCategoryFromAPI ");
        _repo.fetchCountryFromAPI(this);
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
        _view.showCountry(areas);
    }

    @Override
    public void onFailureResponse(String errorMessage) {
        _view.showErrMsg(errorMessage);

    }
}

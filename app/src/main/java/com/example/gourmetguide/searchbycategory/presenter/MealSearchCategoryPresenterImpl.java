package com.example.gourmetguide.searchbycategory.presenter;

import android.util.Log;

import com.example.gourmetguide.mealFav.view.MealFavView;
import com.example.gourmetguide.model.Category;
import com.example.gourmetguide.model.Meal;
import com.example.gourmetguide.model.MealRepository;
import com.example.gourmetguide.network.NetworkCallback;
import com.example.gourmetguide.searchbycategory.view.MealSearchCategoryView;

import java.util.List;

public class MealSearchCategoryPresenterImpl implements MealSearchCategoryPresenter , NetworkCallback {

    private MealSearchCategoryView _view;
    private MealRepository _repo;

    public MealSearchCategoryPresenterImpl(MealSearchCategoryView _view,MealRepository _repo)
    {
        this._repo = _repo;
        this._view = _view;
    }

    @Override
    public void getMeals() {
        _repo.fetchMealFromAPI(this);
    }

    @Override
    public void ShowDetails(Meal meal) {

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
    public void onFailureResponse(String errorMessage) {
        _view.showErrMsg(errorMessage);
    }
}

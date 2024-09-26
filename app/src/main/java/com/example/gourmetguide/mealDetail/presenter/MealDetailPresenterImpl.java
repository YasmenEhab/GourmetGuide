package com.example.gourmetguide.mealDetail.presenter;

import com.example.gourmetguide.mealDetail.viewer.MealDetailView;
import com.example.gourmetguide.mealOfTheDay.view.MealDayView;
import com.example.gourmetguide.model.Meal;
import com.example.gourmetguide.model.MealRepository;
import com.example.gourmetguide.network.NetworkCallback;

import java.util.Collections;
import java.util.List;

public class MealDetailPresenterImpl implements MealDetailPresenter , NetworkCallback {

    private MealDetailView _view;
    private MealRepository _repo;

    public MealDetailPresenterImpl(MealDetailView _view, MealRepository _repo)
    {
        this._repo = _repo;
        this._view = _view;
    }

    @Override
    public void getMeals() {
        _repo.fetchMealFromAPI(this);
    }

    @Override
    public void addToFav(Meal meal) {
        _repo.insertMeal(meal);
    }






    @Override
    public void onSuccessfulResponse(List<Meal> meals) {
        _view.showData(meals);
    }

    @Override
    public void onFailureResponse(String errorMessage) {
        _view.showErrMsg(errorMessage);
    }
}

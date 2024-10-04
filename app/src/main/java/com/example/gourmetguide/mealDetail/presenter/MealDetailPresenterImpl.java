package com.example.gourmetguide.mealDetail.presenter;

import com.example.gourmetguide.mealDetail.viewer.MealDetailView;
import com.example.gourmetguide.mealOfTheDay.view.MealDayView;
import com.example.gourmetguide.model.Category;
import com.example.gourmetguide.model.Converters;
import com.example.gourmetguide.model.Meal;
import com.example.gourmetguide.model.MealPlan;
import com.example.gourmetguide.model.MealRepository;
import com.example.gourmetguide.network.NetworkCallback;

import java.util.Collections;
import java.util.Date;
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
    public void addToFav(Meal meal) {
        _repo.insertMeal(meal);
    }

    @Override
    public void addToPlan(Meal meal, long dateInMillis) {
        Date selectedDate = Converters.fromLong(dateInMillis);
        MealPlan mealPlan = new MealPlan(meal, selectedDate);
        _repo.insertMealToPlan(mealPlan ,selectedDate );
        _view.showConfirmationMessage("Meal added to plan for the selected date.");
    }

    @Override
    public void onSuccessfulResponse(List<Meal> meals) {
        _view.showData(meals);
    }

    @Override
    public void onSuccessfulResponseCategory(List<Category> categories) {

    }

    @Override
    public void onFailureResponse(String errorMessage) {
        _view.showErrMsg(errorMessage);
    }
}
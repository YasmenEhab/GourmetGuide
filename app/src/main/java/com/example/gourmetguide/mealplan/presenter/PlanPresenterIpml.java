package com.example.gourmetguide.mealplan.presenter;

import androidx.lifecycle.LiveData;

import com.example.gourmetguide.mealFav.view.MealFavView;
import com.example.gourmetguide.mealplan.view.MealPlanView;
import com.example.gourmetguide.model.Meal;
import com.example.gourmetguide.model.MealPlan;
import com.example.gourmetguide.model.MealRepository;

import java.util.Date;
import java.util.List;

public class PlanPresenterIpml implements  PlanPresenter{

    private MealPlanView _view;
    private MealRepository _repo;


    public PlanPresenterIpml(MealPlanView _view, MealRepository _repo)
    {
        this._repo = _repo;
        this._view = _view;
    }
    @Override
    public LiveData<List<MealPlan>> getPlannedMeals(Date date) {
        return _repo.getPlanMeals(date);
    }

}
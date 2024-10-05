package com.example.gourmetguide.arealist.presenter;

import com.example.gourmetguide.arealist.view.AreaView;
import com.example.gourmetguide.categorylist.view.CategoryView;
import com.example.gourmetguide.model.Area;
import com.example.gourmetguide.model.Category;
import com.example.gourmetguide.model.Meal;
import com.example.gourmetguide.model.MealRepository;
import com.example.gourmetguide.network.NetworkCallback;

import java.util.List;

public class AreaListPresenterImpl implements  AreaListPresenter , NetworkCallback {

    private AreaView _view;
    private MealRepository _repo;

    public AreaListPresenterImpl(AreaView _view, MealRepository _repo) {
        this._view = _view;
        this._repo = _repo;
    }

    @Override
    public void getMeals(String country) {
        _repo.getMealsByCountry(this, country);

    }
//    public void getAreaList ()
//    {
//        _repo.getAreaList(this);
//    }

    @Override
    public void ShowDetails(Meal meal) {

    }

    @Override
    public void onSuccessfulResponse(List<Meal> meals) {
        _view.showData(meals);
    }

    @Override
    public void onSuccessfulResponseCategory(List<Category> categories) {

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

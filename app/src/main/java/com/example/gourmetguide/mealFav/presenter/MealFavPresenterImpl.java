package com.example.gourmetguide.mealFav.presenter;

import androidx.lifecycle.LiveData;

import com.example.gourmetguide.mealFav.view.MealFavView;
import com.example.gourmetguide.mealOfTheDay.view.MealDayView;
import com.example.gourmetguide.model.Meal;
import com.example.gourmetguide.model.MealRepository;

import java.util.List;

public class MealFavPresenterImpl implements MealFavPresenter{


    private MealFavView _view;
    private MealRepository _repo;


    public MealFavPresenterImpl(MealFavView _view,MealRepository _repo)
    {
        this._repo = _repo;
        this._view = _view;
    }
    @Override
    public LiveData<List<Meal>> getMeals() {
        return _repo.getStoredMeals();
    }

    @Override
    public void deleteFromFav(Meal meal) {
        _repo.deleteMeal(meal);
    }
}

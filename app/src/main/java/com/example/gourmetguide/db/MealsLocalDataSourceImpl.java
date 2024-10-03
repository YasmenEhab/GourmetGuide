package com.example.gourmetguide.db;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.gourmetguide.mealOfTheDay.view.MealDayFragment;
import com.example.gourmetguide.model.Meal;
import com.example.gourmetguide.model.MealPlan;

import java.util.Date;
import java.util.List;

public class MealsLocalDataSourceImpl implements MealsLocalDataSource{
    private MealDAO dao;
    private static MealsLocalDataSourceImpl localSource = null;
    private LiveData<List<Meal>> storedProducts;
    private LiveData<List<MealPlan>> plannedMeals;

    private MealsLocalDataSourceImpl (Context context)
    {
        AppDataBase db = AppDataBase.getInstance(context.getApplicationContext());
        dao = db.getProductDAO();
        storedProducts = dao.getAllProducts();
    }

    public static MealsLocalDataSourceImpl getInstance(Context context)
    {
        if(localSource == null)
        {
            localSource = new MealsLocalDataSourceImpl(context);
        }
        return localSource;
    }

    @Override
    public void insertMeal(Meal meal) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.insertMeal(meal);
            }
        }).start();
    }

    @Override
    public void deleteMeal(Meal meal) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                dao.deleteMeal(meal);
            }
        }).start();

    }

    @Override
    public LiveData<List<Meal>> getStoredData() {
        return storedProducts;
    }
    @Override
    public LiveData<List<MealPlan>> getPlannedMeals() {

        return plannedMeals;
    }
    @Override
    public LiveData<List<MealPlan>> getPlanMeals(Date date) {

        plannedMeals = dao.getAllPlanMeals(date);
        return plannedMeals;
    }
    @Override
    public void insertMealToPlan(MealPlan meal, Date date){
        new Thread(new Runnable() {
            @Override
            public void run() {
                meal.setDate(date);
                dao.insertMealToPlan(meal);
            }
        }).start();
    }

}

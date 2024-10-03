package com.example.gourmetguide.model;

import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.gourmetguide.db.MealsLocalDataSource;
import com.example.gourmetguide.network.MealsRemoteDataSource;
import com.example.gourmetguide.network.NetworkCallback;

import java.util.Date;
import java.util.List;

public class MealRepositoryImpl implements MealRepository {

    private MealsRemoteDataSource remoteDataSource;
    private MealsLocalDataSource localDataSource;

    private static MealRepositoryImpl repo = null;

    private MealRepositoryImpl (MealsRemoteDataSource remoteDataSource ,MealsLocalDataSource localDataSource )
    {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    public static MealRepositoryImpl getInstance(MealsRemoteDataSource remoteDataSource ,MealsLocalDataSource localDataSource)
    {
        if(repo == null){
            repo = new MealRepositoryImpl(remoteDataSource , localDataSource);
        }
        return repo;
    }

    @Override
    public LiveData<List<Meal>> getStoredMeals() {
        // Fetches data from local storage
        return localDataSource.getStoredData();
    }
    @Override
    public LiveData<List<MealPlan>> getPlannedMeals()
    {
        return localDataSource.getPlannedMeals();
    }
    public LiveData<List<MealPlan>> getPlanMeals(Date date)
    {
        return localDataSource.getPlanMeals(date);
    }

    @Override
    public void deleteMeal(Meal meal) {
        localDataSource.deleteMeal(meal);
    }

    @Override
    public void insertMeal(Meal meal) {
        localDataSource.insertMeal(meal);
    }
    @Override
    public void insertMealToPlan(MealPlan meal, Date date)
    {
        localDataSource.insertMealToPlan(meal,  date);
    }

    @Override
    public void fetchMealFromAPI(NetworkCallback callback) {
        //remoteDataSource.makeNetworkCall2(callback);
        Log.i("repo","fetch random meal ");
        remoteDataSource.makeNetworkCall2(callback, MealsRemoteDataSource.ApiType.RANDOM_MEAL);
    }
    @Override
    public void fetchCategoryFromAPI(NetworkCallback callback) {
        remoteDataSource.makeNetworkCall2(callback, MealsRemoteDataSource.ApiType.CATEGORY);
    }

//    public void getIngredients(NetworkCallback networkCallback)
//    {
//        remoteDataSource.getIngredientsFromNetwork(networkCallback);
//    }
    public void getMealsByCategory(NetworkCallback networkCallback, String category)
    {
        remoteDataSource.getMealsByCategoryFromNetwork(networkCallback, category);
    }
    public void getMealsByCountry(NetworkCallback networkCallback, String country)
    {
        remoteDataSource.getMealsByCountryFromNetwork(networkCallback, country);
    }
    public void getMealsByIngredient(NetworkCallback networkCallback, String ingredient)
    {
        remoteDataSource.getMealsByIngredientFromNetwork(networkCallback, ingredient);
    }
    public void getMealsByName(NetworkCallback networkCallback, String mealName)
    {
        remoteDataSource.getMealsByNameFromNetwork(networkCallback, mealName);
    }




}

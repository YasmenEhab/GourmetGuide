package com.example.gourmetguide.model;

import androidx.lifecycle.LiveData;

import com.example.gourmetguide.db.MealsLocalDataSource;
import com.example.gourmetguide.network.MealsRemoteDataSource;
import com.example.gourmetguide.network.NetworkCallback;

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
    public LiveData<List<Meal>> getStoredProducts() {
        // Fetches data from local storage
        return localDataSource.getStoredData();
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
    public void fetchMealFromAPI(NetworkCallback callback) {
        remoteDataSource.makeNetworkCall(callback);
    }


}

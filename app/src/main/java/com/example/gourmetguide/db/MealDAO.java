package com.example.gourmetguide.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.gourmetguide.model.Meal;

import java.util.List;

@Dao
public interface MealDAO {
    @Query("SELECT*FROM Meals_table")
    LiveData<List<Meal>> getAllProducts();

    @Insert
    void insertMeal(Meal meal);

    @Delete
    void deleteMeal(Meal meal);

}

package com.example.gourmetguide.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.gourmetguide.model.Meal;
import com.example.gourmetguide.model.MealPlan;

import java.util.Date;
import java.util.List;

@Dao
public interface MealDAO {
    @Query("SELECT*FROM Meals_table")
    LiveData<List<Meal>> getAllProducts();

    @Insert
    void insertMeal(Meal meal);

    @Delete
    void deleteMeal(Meal meal);

    @Query("SELECT * FROM MealPlan_table")
    LiveData<List<MealPlan>>getAllPlannedMeals();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMealToPlan(MealPlan mealPlan);

    @Delete
    void deleteMealFromPlan(MealPlan mealPlan);

    @Query("SELECT * FROM MealPlan_table WHERE date = :planDate")
    LiveData<List<MealPlan>>getAllPlanMeals(Date planDate);
}

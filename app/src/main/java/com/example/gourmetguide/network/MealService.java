package com.example.gourmetguide.network;

import com.example.gourmetguide.model.AreaResponse;
import com.example.gourmetguide.model.CategoryResponse;
import com.example.gourmetguide.model.MealResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MealService {
    @GET("json/v1/1/random.php")
    Call<MealResponse> getMeals();

    @GET("json/v1/1/categories.php")
    Call<CategoryResponse> getMealCategories();

    @GET("json/v1/1/list.php?a=list")
    Call<AreaResponse> getAreas();

    @GET("json/v1/1/lookup.php")
    Call<MealResponse> getMealbyID(@Query("i") String id);

    @GET("json/v1/1/search.php")
    Call<MealResponse> getMealsbyName(@Query("s") String mealName);

    @GET("json/v1/1/filter.php")
    Call<MealResponse> getMealsbyCategory(@Query("c") String category);

    @GET("json/v1/1/filter.php")
    Call<MealResponse> getMealsbyIngredient(@Query("i") String ingredient);

    @GET("json/v1/1/filter.php")
    Call<MealResponse> getMealsbyCountry(@Query("a") String country);
}

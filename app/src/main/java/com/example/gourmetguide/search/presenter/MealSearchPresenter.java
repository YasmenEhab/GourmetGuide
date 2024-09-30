package com.example.gourmetguide.search.presenter;

public interface MealSearchPresenter {

    public void getMeals();
    public void getCategories();

        public void serchByCountry(String country) ;

    public void serchByCategory(String category) ;


    public void serchByIngredient(String ingredient) ;


    public void serchByMealName(String mealName) ;


}

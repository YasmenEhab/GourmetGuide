package com.example.gourmetguide.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Meals_table")
public class Meal implements Serializable {

    @PrimaryKey
    @NonNull
    private String idMeal;
    private String strMeal;

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    private String strCategory;
    private String strArea; // Country of origin
    private String strInstructions;
    private String strMealThumb; // Image URL
    public String strYoutube; // Embedded video
    //private String[] strIngredients; // Array of ingredients

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public void setStrArea(String strArea) {
        this.strArea = strArea;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    public void setStrYoutube(String strYoutube) {
        this.strYoutube = strYoutube;
    }

    public void setIdMeal(@NonNull String idMeal) {
        this.idMeal = idMeal;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public String getStrArea() {
        return strArea;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

//    public String[] getStrIngredients() {
//        return strIngredients;
//    }

    // Add getters and setters
    public String getIdMeal() { return idMeal; }

    public String getStrMeal() { return strMeal; }

    public String getStrMealThumb() { return strMealThumb; }
    public String getStrYoutube() { return strYoutube; }
}

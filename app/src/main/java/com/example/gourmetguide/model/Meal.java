package com.example.gourmetguide.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "Meals_table")
public class Meal implements Serializable {

    @PrimaryKey
    @NonNull
    private String idMeal;
    private String strMeal;
    private String strCategory;
    private String strArea; // Country of origin
    //private String drinkAlternate;
    //private String category;
    private String strInstructions;
    private String strMealThumb; // Image URL
    public String strYoutube; // Embedded video

//    private String ingredient1;
//    private String ingredient2;
//    private String ingredient3;
//
//    private String ingredient4;
//
//    private String ingredient5;
//
//    private String ingredient6;
//
//    private String ingredient7;
//    @SerializedName("strIngredient8")
//    private String ingredient8;
//    @SerializedName("strIngredient9")
//    private String ingredient9;
//    @SerializedName("strIngredient10")
//    private String ingredient10;
//    @SerializedName("strIngredient11")
//    private String ingredient11;
//    @SerializedName("strIngredient12")
//    private String ingredient12;
//    @SerializedName("strIngredient13")
//    private String ingredient13;
//    @SerializedName("strIngredient14")
//    private String ingredient14;
//    @SerializedName("strIngredient15")
//    private String ingredient15;
//    @SerializedName("strIngredient16")
//    private String ingredient16;
//    @SerializedName("strIngredient17")
//    private String ingredient17;
//    @SerializedName("strIngredient18")
//    private String ingredient18;
//    @SerializedName("strIngredient19")
//    private String ingredient19;
//    @SerializedName("strIngredient20")
//    private String ingredient20;
//    @SerializedName("strMeasure1")
//    private String measure1;
//    @SerializedName("strMeasure2")
//    private String measure2;
//    @SerializedName("strMeasure3")
//    private String measure3;
//    @SerializedName("strMeasure4")
//    private String measure4;
//    @SerializedName("strMeasure5")
//    private String measure5;
//    @SerializedName("strMeasure6")
//    private String measure6;
//    @SerializedName("strMeasure7")
//    private String measure7;
//    @SerializedName("strMeasure8")
//    private String measure8;
//    @SerializedName("strMeasure9")
//    private String measure9;
//    @SerializedName("strMeasure10")
//    private String measure10;
//    @SerializedName("strMeasure11")
//    private String measure11;
//    @SerializedName("strMeasure12")
//    private String measure12;
//    @SerializedName("strMeasure13")
//    private String measure13;
//    @SerializedName("strMeasure14")
//    private String measure14;
//    @SerializedName("strMeasure15")
//    private String measure15;
//    @SerializedName("strMeasure16")
//    private String measure16;
//    @SerializedName("strMeasure17")
//    private String measure17;
//    @SerializedName("strMeasure18")
//    private String measure18;
//    @SerializedName("strMeasure19")
//    private String measure19;
//    @SerializedName("strMeasure20")
//    private String measure20;

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public void setStrArea(String strArea) {
        this.strArea = strArea;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }
    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
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

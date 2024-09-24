package com.example.gourmetguide.model;

public class Meal {
    private String idMeal;
    private String strMeal;
    private String strCategory;
    private String strArea; // Country of origin
    private String strInstructions;
    private String strMealThumb; // Image URL
    private String strYoutube; // Embedded video
    private String[] strIngredients; // Array of ingredients

    public String getStrCategory() {
        return strCategory;
    }

    public String getStrArea() {
        return strArea;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public String[] getStrIngredients() {
        return strIngredients;
    }

    // Add getters and setters
    public String getIdMeal() { return idMeal; }

    public String getStrMeal() { return strMeal; }

    public String getStrMealThumb() { return strMealThumb; }
    public String getStrYoutube() { return strYoutube; }
}

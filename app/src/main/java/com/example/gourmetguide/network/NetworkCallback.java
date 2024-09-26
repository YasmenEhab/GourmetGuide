package com.example.gourmetguide.network;

import com.example.gourmetguide.model.Meal;

import java.util.List;

public interface NetworkCallback {
    public void onSuccessfulResponse(List<Meal> meals);
    public void onFailureResponse(String errorMessage);
}

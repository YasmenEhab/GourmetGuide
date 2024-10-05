package com.example.gourmetguide.network;

import com.example.gourmetguide.model.Area;
import com.example.gourmetguide.model.Category;
import com.example.gourmetguide.model.Meal;

import java.util.List;

public interface NetworkCallback {
    public void onSuccessfulResponse(List<Meal> meals);
    public void onSuccessfulResponseCategory(List<Category> categories);
    public void onSuccessfulResponseArea(List<Area> areas);
    public void onFailureResponse(String errorMessage);
}

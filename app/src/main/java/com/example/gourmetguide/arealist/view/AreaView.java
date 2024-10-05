package com.example.gourmetguide.arealist.view;

import com.example.gourmetguide.model.Area;
import com.example.gourmetguide.model.Category;
import com.example.gourmetguide.model.Meal;

import java.util.List;

public interface AreaView {
    public void showData(List<Meal> meals);
    public void showErrMsg (String error);
    public void showCountry(List<Area> areas);
}

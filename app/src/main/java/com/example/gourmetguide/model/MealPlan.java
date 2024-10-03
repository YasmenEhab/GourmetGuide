package com.example.gourmetguide.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity(tableName = "MealPlan_table")
public class MealPlan implements Serializable {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id ;

    @Embedded
    Meal meal;

    private Date date;

    public MealPlan(Meal meal, Date date) {
        this.meal = meal;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

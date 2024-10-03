package com.example.gourmetguide.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.gourmetguide.model.Converters;
import com.example.gourmetguide.model.Meal;
import com.example.gourmetguide.model.MealPlan;

@Database(entities ={Meal.class, MealPlan.class},version =1)
@TypeConverters(Converters.class)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase instance=null;
    public static synchronized AppDataBase getInstance(Context context){
        if(instance == null)
        {
            instance= Room.databaseBuilder(context.getApplicationContext(),AppDataBase.class,"productsdb").build();
        }
        return instance;
    }
    //room will implement this method
    public abstract MealDAO getProductDAO();


}

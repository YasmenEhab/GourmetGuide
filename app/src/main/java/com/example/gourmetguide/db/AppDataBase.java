package com.example.gourmetguide.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.gourmetguide.model.Meal;

@Database(entities ={Meal.class},version =1)
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

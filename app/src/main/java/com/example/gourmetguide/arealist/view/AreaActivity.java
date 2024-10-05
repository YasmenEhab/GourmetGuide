package com.example.gourmetguide.arealist.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gourmetguide.R;
import com.example.gourmetguide.arealist.presenter.AreaListPresenter;
import com.example.gourmetguide.arealist.presenter.AreaListPresenterImpl;
import com.example.gourmetguide.categorylist.presenter.CategoryViewPresenter;
import com.example.gourmetguide.categorylist.presenter.CategoryViewPresenterImpl;
import com.example.gourmetguide.categorylist.view.CategoryViewAdapter;
import com.example.gourmetguide.db.MealsLocalDataSourceImpl;
import com.example.gourmetguide.mealDetail.viewer.MealDetailActivity;
import com.example.gourmetguide.model.Area;
import com.example.gourmetguide.model.Meal;
import com.example.gourmetguide.model.MealRepositoryImpl;
import com.example.gourmetguide.network.MealsRemoteDataSourceImpl;

import java.util.ArrayList;
import java.util.List;

public class AreaActivity extends AppCompatActivity implements onAreaClickLIstener , AreaView{

    private AreaListPresenter presenter;

    RecyclerView recyclerView;
    LinearLayoutManager linearLayout;
    AreaListAdapter mealAdapter;

    private String AreaName;
    private static final String TAG = "AreaListActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area);

        recyclerView =findViewById(R.id.recycler_view_meals_2);
        recyclerView.setHasFixedSize(true);

        linearLayout = new LinearLayoutManager(this);
        mealAdapter = new AreaListAdapter(new ArrayList<>(),this,  this);

        presenter = new AreaListPresenterImpl(this, MealRepositoryImpl.getInstance(MealsRemoteDataSourceImpl.getInstance(), MealsLocalDataSourceImpl.getInstance(this)));

        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setAdapter(mealAdapter);
        Log.d(TAG, "setAdapter ");
        Intent intent = getIntent();
        Log.d(TAG, "intent " + (intent != null));
        Log.d(TAG, "intent " + intent.hasExtra("COUNTRY_NAME"));
        Log.d(TAG, "intent " + intent.getSerializableExtra("COUNTRY_NAME"));

        if (intent != null && intent.hasExtra("COUNTRY_NAME")) {
            AreaName = (String) intent.getSerializableExtra("COUNTRY_NAME");
            Log.d(TAG, "Category received: " + AreaName);

            presenter.getMeals(AreaName);
        }

    }

    @Override
    public void showData(List<Meal> meals) {
        mealAdapter.setList(meals);
        mealAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrMsg(String error) {
        Log.e(TAG, "Error occurred: " + error); // Log error messages
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(error).setTitle("an error occurred");
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void showCountry(List<Area> areas) {

    }

    @Override
    public void onClick(Meal meal) {
        //presenter.ShowDetails(meal);

       Intent intent = new Intent(AreaActivity.this, MealDetailActivity.class);
       intent.putExtra("meal", meal.getStrMeal());
        Log.d(TAG, "Meal data displayed: " + meal.getStrMeal());
        Log.d("MealDetails", "Ingredients: " + meal.getIngredients());
        Log.d("MealDetails", "Measures: " + meal.getMeasures());
        startActivity(intent);
    }
}
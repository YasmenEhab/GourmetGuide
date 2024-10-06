package com.example.gourmetguide.categorylist.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gourmetguide.R;
import com.example.gourmetguide.arealist.view.AreaActivity;
import com.example.gourmetguide.categorylist.presenter.CategoryViewPresenter;
import com.example.gourmetguide.categorylist.presenter.CategoryViewPresenterImpl;
import com.example.gourmetguide.db.MealsLocalDataSourceImpl;
import com.example.gourmetguide.mealDetail.viewer.MealDetailActivity;
import com.example.gourmetguide.mealFav.presenter.MealFavPresenter;
import com.example.gourmetguide.mealFav.presenter.MealFavPresenterImpl;
import com.example.gourmetguide.mealFav.view.MealFavAdapter;
import com.example.gourmetguide.model.Category;
import com.example.gourmetguide.model.Meal;
import com.example.gourmetguide.model.MealRepositoryImpl;
import com.example.gourmetguide.network.MealsRemoteDataSourceImpl;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity implements CategoryView , onCategoryClickListener{

    private CategoryViewPresenter presenter;

    RecyclerView recyclerView;
    LinearLayoutManager linearLayout;
    CategoryViewAdapter mealAdapter;
    private String categoryName;

    private static final String TAG = "CategoryActivity";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_category);

        recyclerView =findViewById(R.id.recycler_view_meals);
        recyclerView.setHasFixedSize(true);
        //GridLayoutManager linearLayout = new GridLayoutManager(this, 2);
        linearLayout = new LinearLayoutManager(this);
        mealAdapter = new CategoryViewAdapter(new ArrayList<>(),this,  this);

        presenter = new CategoryViewPresenterImpl(this, MealRepositoryImpl.getInstance(MealsRemoteDataSourceImpl.getInstance(), MealsLocalDataSourceImpl.getInstance(this)));

        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setAdapter(mealAdapter);
        Log.d(TAG, "setAdapter ");
        Intent intent = getIntent();
        Log.d(TAG, "intent " + (intent != null));
        Log.d(TAG, "intent " + intent.hasExtra("CATEGORY_NAME"));
        Log.d(TAG, "intent " + intent.getSerializableExtra("CATEGORY_NAME"));

        if (intent != null && intent.hasExtra("CATEGORY_NAME")) {
            categoryName = (String) intent.getSerializableExtra("CATEGORY_NAME");
            Log.d(TAG, "Category received: " + categoryName);

            presenter.getMeals(categoryName);
        }

    }

    @Override
    public void onClick(Meal meal) {
        Intent intent = new Intent(CategoryActivity.this, MealDetailActivity.class);
        intent.putExtra("meal", meal.getStrMeal());
        Log.d(TAG, "Meal data displayed: " + meal.getStrMeal());
        Log.d("MealDetails", "Ingredients: " + meal.getIngredients());
        Log.d("MealDetails", "Measures: " + meal.getMeasures());
        startActivity(intent);
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
    public void showCategory(List<Category> categories) {

    }
}
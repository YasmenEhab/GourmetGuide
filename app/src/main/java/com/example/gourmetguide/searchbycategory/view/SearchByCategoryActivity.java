package com.example.gourmetguide.searchbycategory.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import android.widget.TextView;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gourmetguide.R;
import com.example.gourmetguide.db.MealsLocalDataSourceImpl;
import com.example.gourmetguide.model.Category;
import com.example.gourmetguide.model.Meal;
import com.example.gourmetguide.model.MealRepositoryImpl;
import com.example.gourmetguide.network.MealsRemoteDataSourceImpl;
import com.example.gourmetguide.searchbycategory.presenter.MealSearchCategoryPresenter;
import com.example.gourmetguide.searchbycategory.presenter.MealSearchCategoryPresenterImpl;

import java.util.ArrayList;
import java.util.List;

public class SearchByCategoryActivity extends AppCompatActivity implements onMealSearchCategoryClickListener , MealSearchCategoryView{

    private ProgressBar loadingIndicator;
    private TextView emptyStateMessage;
    private SearchView searchViewCategory;

    private RecyclerView recyclerViewCategory;
    private SearchByCategoryAdapter mealAdapter;
    private SearchByCategoryAdapter2 mealAdapter2;
    LinearLayoutManager linearLayout;
    private LiveData<List<Category>> categoryList;

    private MealSearchCategoryPresenter presenter;

    private Button btnShowDetails;

    private static final String TAG = "MealSearchCategoryFragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search_by_category);
        // Setup Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerViewCategory = findViewById(R.id.recycler_view_categories);
        loadingIndicator = findViewById(R.id.loading_indicator);
        emptyStateMessage = findViewById(R.id.empty_state_message);
        searchViewCategory = findViewById(R.id.search_view_category);

        // Setup RecyclerView
        recyclerViewCategory.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false); // Horizontal layout
        recyclerViewCategory.setLayoutManager(layoutManager);
        Log.e(TAG, " categories adapter ");
        mealAdapter2 = new SearchByCategoryAdapter2(new ArrayList<>(), this, this);
        recyclerViewCategory.setAdapter(mealAdapter2);

        // Set up the presenter
        presenter = new MealSearchCategoryPresenterImpl(this, MealRepositoryImpl.getInstance(MealsRemoteDataSourceImpl.getInstance(), MealsLocalDataSourceImpl.getInstance(this))) ;
        Log.e(TAG, " presenter.getCategories ");
        presenter.getCategories();

        // Setup search functionality
       // setupSearchView();


    }

    // SearchView configuration
//    private void setupSearchView() {
//        searchViewCategory.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                presenter.searchMealsByCategory(query);
//                return true;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                presenter.searchMealsByCategory(newText); // Real-time search
//                return true; // Indicate that the search action has been handled
//            }
//        });
//    }

    @Override
    public void showData(List<Meal> meals) {
        loadingIndicator.setVisibility(View.GONE); // Hide loading indicator
        emptyStateMessage.setVisibility(View.GONE); // Hide empty state message
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
        mealAdapter2.setList(categories);
        mealAdapter2.notifyDataSetChanged();
    }

    @Override
    public void onClick(Meal meal) {

    }
}
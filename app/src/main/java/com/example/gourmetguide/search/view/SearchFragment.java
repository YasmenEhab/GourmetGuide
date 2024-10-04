package com.example.gourmetguide.search.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.gourmetguide.R;
import com.example.gourmetguide.db.MealsLocalDataSourceImpl;
import com.example.gourmetguide.mealDetail.viewer.MealDetailActivity;
import com.example.gourmetguide.mealFav.presenter.MealFavPresenterImpl;
import com.example.gourmetguide.mealFav.view.MealFavAdapter;
import com.example.gourmetguide.model.Category;
import com.example.gourmetguide.model.Meal;
import com.example.gourmetguide.model.MealRepositoryImpl;
import com.example.gourmetguide.network.MealsRemoteDataSourceImpl;
import com.example.gourmetguide.search.presenter.MealSearchPresenter;
import com.example.gourmetguide.search.presenter.MealSearchPresenterImpl;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class SearchFragment extends Fragment implements onMealSearchClickListener , MealSearchView {
    private MealSearchPresenter presenter;

    RecyclerView recyclerView;
    LinearLayoutManager linearLayout;
    SearchAdapter mealAdapter;

    private static final String TAG = "SearchFragment";
   // private String currentFilterType = "country";
    int position = 0;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search2, container, false);

        // Initialize RecyclerView
        recyclerView =view.findViewById(R.id.search_results_recycler);
        recyclerView.setHasFixedSize(true);
        linearLayout = new LinearLayoutManager(requireContext());
        mealAdapter = new SearchAdapter(new ArrayList<>(),requireContext(),  this);
        recyclerView.setLayoutManager(linearLayout);
        recyclerView.setAdapter(mealAdapter);

        // Initialize presenter
        presenter = new MealSearchPresenterImpl(this, MealRepositoryImpl.getInstance(MealsRemoteDataSourceImpl.getInstance(), MealsLocalDataSourceImpl.getInstance(requireContext())));

        // Initialize search view and chips
        SearchView searchView = view.findViewById(R.id.search_bar);
        TabLayout tabLayout = view.findViewById(R.id.tabLayout);

       // presenter.getMeals();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Get the selected tab position
                position = tab.getPosition();

                // Perform different actions based on the selected tab
                switch (position) {
                    case 0:
                        searchView.setQueryHint("Enter Meal Name");
                        break;
                    case 1:
                        searchView.setQueryHint("Enter Country Name");
                        break;
                    case 2:
                        searchView.setQueryHint("Enter Ingredient Name");
                        break;
                    case 3:
                        searchView.setQueryHint("Enter Category Name");
                        break;
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });






        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                switch (position) {
                    case 0:
                        presenter.serchByMealName(query);
                        //searchPresenter.serchByMealName(searchView.getQuery().toString());
                        break;
                    case 1:
                        presenter.serchByCountry(searchView.getQuery().toString());
                        break;
                    case 2:
                        presenter.serchByIngredient(searchView.getQuery().toString());
                        break;
                    case 3:
                        presenter.serchByCategory(searchView.getQuery().toString());
                        break;
                }
                return true; // Return true to indicate the query has been handled
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(position == 0)
                {
                    presenter.serchByMealName(newText);
                }

                return true; // Return true to indicate the change has been handled
            }
        });
        return view;
    }

    @Override
    public void onClick(Meal meal) {
        Intent intent = new Intent(requireContext(), MealDetailActivity.class);
        intent.putExtra("meal", meal); // Pass the meal object to the details screen
        startActivity(intent);
    }

    @Override
    public void showData(List<Meal> meals) {
        Log.d(TAG, "showData called with meals: " + meals.size());
        Meal firstMeal = meals.get(0);
        List<String> ingredients = firstMeal.getIngredients();
        String firstIngredient = ingredients.get(0);
        Toast.makeText(getContext(), "First Ingredient: " + firstIngredient, Toast.LENGTH_SHORT).show();
        mealAdapter.setList(meals);

        mealAdapter.notifyDataSetChanged();
    }

    @Override
    public void showErrMsg(String error) {
        Log.e(TAG, "Error occurred: " + error);
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show(); // Show actual error message
    }

    @Override
    public void showCategory(List<Category> categories) {

    }
}
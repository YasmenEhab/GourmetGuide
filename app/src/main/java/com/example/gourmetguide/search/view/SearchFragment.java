package com.example.gourmetguide.search.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.gourmetguide.R;
import com.example.gourmetguide.mealOfTheDay.view.onMealClickListener;
import com.example.gourmetguide.model.Meal;
import com.example.gourmetguide.searchbycategory.view.SearchByCategoryActivity;


public class SearchFragment extends Fragment implements onMealSearchClickListener {

    private Button searchByCategoryButton;
    private Button searchByIngredientButton;
    private Button searchByCountryButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search2, container, false);

        // Initialize the buttons
        searchByCategoryButton = view.findViewById(R.id.btnCategorySearch);
        searchByIngredientButton = view.findViewById(R.id.btnIngredientsSearch);
        searchByCountryButton = view.findViewById(R.id.btnCountrySearch);

        // Set the click listener for the "Search by Category" button
        searchByCategoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to the CategorySearchActivity
                Intent intent = new Intent(getActivity(), SearchByCategoryActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onClick(Meal meal) {

    }
}
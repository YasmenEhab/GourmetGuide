package com.example.gourmetguide;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.gourmetguide.databinding.ActivityMainBinding;
import com.example.gourmetguide.mealFav.view.MealFavFragment;
import com.example.gourmetguide.mealOfTheDay.view.MealDayFragment;
import com.example.gourmetguide.mealplan.view.MealPlanFragment;
import com.example.gourmetguide.search.view.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    MealDayFragment mealDayFragment;

    SearchFragment fragment;

    ActivityMainBinding binding;

    public static final String DYNAMIC_FRAGMENT_TAG = "Dynamic Fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new MealDayFragment());
        binding.bottomNavigationView.setOnItemSelectedListener(item ->
        {

            if (item.getItemId() == R.id.nav_home) {
                replaceFragment(new MealDayFragment());
            } else if (item.getItemId() == R.id.nav_plan) {
                replaceFragment(new MealPlanFragment());
            } else if (item.getItemId() == R.id.nav_search) {
                replaceFragment(new SearchFragment());
            } else if (item.getItemId() == R.id.nav_favorites) {
                replaceFragment(new MealFavFragment());
            }


            return true;
        });


    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainLayout, fragment);
        fragmentTransaction.commit();
    }
}



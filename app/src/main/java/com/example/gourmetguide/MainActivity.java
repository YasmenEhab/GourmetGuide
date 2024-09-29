package com.example.gourmetguide;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.gourmetguide.mealFav.view.MealFavFragment;
import com.example.gourmetguide.mealOfTheDay.view.MealDayFragment;
import com.example.gourmetguide.search.view.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    MealDayFragment mealDayFragment;
    MealFavFragment mealFavFragment;
    SearchFragment fragment;

    public static final String DYNAMIC_FRAGMENT_TAG = "Dynamic Fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        //bottomNavigationView.setSelectedItemId(R.id.nav_meal); // Set default selected item
        bottomNavigationView.setSelectedItemId(R.id.nav_favorites); // Set default selected item


        // Initialize and display the MealDayFragment
//        if (savedInstanceState == null) {
//            mealDayFragment = new MealDayFragment();
//            loadFragment(mealDayFragment); // Load the fragment by default
//        }
        // Initialize and display the MealDayFragment
        if (savedInstanceState == null) {
            fragment = new SearchFragment();
            loadFragment(fragment); // Load the fragment by default
        }



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Check if the selected item is the 'meal' icon
//        if (item.getItemId() == R.id.nav_meal) {
//            // Show MealDayFragment when 'meal' icon is selected
//            if (mealDayFragment == null) {
//                mealDayFragment = new MealDayFragment();
//            }
//            loadFragment(mealDayFragment); // Load the fragment
//            return true; // Return true to indicate the item was selected
//        }

        // You can add other if conditions for different fragments here
        // Example:
        // else if (item.getItemId() == R.id.nav_favorites) {
        //     // Load FavoritesFragment
        // }

        return false; // Return false if no valid item is selected
    }

//    private void loadFragment(MealDayFragment fragment) {
//        // Replace the current fragment with the new one
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.flFragment, fragment, DYNAMIC_FRAGMENT_TAG);
//        fragmentTransaction.commit();
//    }
    private void loadFragment(SearchFragment fragment) {
        // Replace the current fragment with the new one
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.flFragment, fragment, DYNAMIC_FRAGMENT_TAG);
        fragmentTransaction.commit();
    }
}

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

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    MealDayFragment mealDayFragment;
   // MealFavFragment mealFavFragment;
    SearchFragment fragment;

    ActivityMainBinding binding;

    public static final String DYNAMIC_FRAGMENT_TAG = "Dynamic Fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new MealDayFragment());
        binding.bottomNavigationView.setOnItemSelectedListener( item ->
        {

           if(item.getItemId() == R.id.nav_home)
           {
               replaceFragment(new MealDayFragment());
           }
           else if (item.getItemId() == R.id.nav_plan)
           {
               replaceFragment(new MealPlanFragment());
           }
           else if (item.getItemId() == R.id.nav_search)
           {
               replaceFragment(new SearchFragment());
           }
           else if (item.getItemId() == R.id.nav_favorites)
           {
               replaceFragment(new MealFavFragment());
           }


            return true;
        });

//        bottomNavigationView = findViewById(R.id.bottomNavigationView);
//        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        //bottomNavigationView.setSelectedItemId(R.id.nav_meal); // Set default selected item
       // bottomNavigationView.setSelectedItemId(R.id.nav_home); // Set default selected item


        // Initialize and display the MealDayFragment
//        if (savedInstanceState == null) {
//            mealDayFragment = new MealDayFragment();
//            loadFragment(mealDayFragment); // Load the fragment by default
//        }
        // Initialize and display the MealDayFragment
//        if (savedInstanceState == null) {
//            fragment = new SearchFragment();
//            loadFragment(fragment); // Load the fragment by default
//        }



    }

    private void replaceFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainLayout , fragment);
        fragmentTransaction.commit();
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
    private void loadFragment(MealDayFragment fragment) {
        // Replace the current fragment with the new one
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.flFragment, fragment, DYNAMIC_FRAGMENT_TAG);
//        fragmentTransaction.commit();
    }
}

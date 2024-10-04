package com.example.gourmetguide.mealOfTheDay.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.gourmetguide.R;
import com.example.gourmetguide.db.MealsLocalDataSourceImpl;
import com.example.gourmetguide.mealDetail.viewer.MealDetailActivity;
import com.example.gourmetguide.mealOfTheDay.presenter.MealDayPresenter;
import com.example.gourmetguide.mealOfTheDay.presenter.MealDayPresenterImpl;
import com.example.gourmetguide.model.Category;
import com.example.gourmetguide.model.Meal;
import com.example.gourmetguide.model.MealRepositoryImpl;
import com.example.gourmetguide.network.MealsRemoteDataSourceImpl;
import com.example.gourmetguide.searchbycategory.view.SearchByCategoryAdapter2;

import java.util.ArrayList;
import java.util.List;


public class MealDayFragment extends Fragment implements onMealClickListener ,MealDayView  {

    private MealDayPresenter presenter;
    private TextView tvMealName, tvMealOrigin;
    private ImageView mealImage;
    private Button btnViewDetails;
    private Meal currentMeal;

    private RecyclerView recyclerViewCategory;
    private MealDayAdapter mealCategoryAdapter;
    LinearLayoutManager linearLayout;



    private static final String TAG = "MealDayFragment"; // Log tag


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "Fragment created"); // Log onCreate

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_meal_day, container, false);

        // Initialize views
        tvMealName = view.findViewById(R.id.tv_meal_name);
        tvMealOrigin = view.findViewById(R.id.tv_meal_origin);
        mealImage = view.findViewById(R.id.meal_image);
        btnViewDetails = view.findViewById(R.id.btn_view_details);
        recyclerViewCategory = view.findViewById(R.id.recycler_view_categories);

        // Setup RecyclerView
        recyclerViewCategory.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false); // Horizontal layout
        recyclerViewCategory.setLayoutManager(layoutManager);
        Log.i(TAG, " categories adapter ");
        mealCategoryAdapter = new MealDayAdapter(new ArrayList<>(), requireContext(), this);
        recyclerViewCategory.setAdapter(mealCategoryAdapter);

        // Set up the presenter
        presenter = new MealDayPresenterImpl(this, MealRepositoryImpl.getInstance(MealsRemoteDataSourceImpl.getInstance(), MealsLocalDataSourceImpl.getInstance(requireContext())));
        presenter.getMeals();
        presenter.getCategories();

        // Set up button click listener to trigger onClick(Meal meal) method
        btnViewDetails.setOnClickListener(v -> {
            if (currentMeal != null) {
                Log.d(TAG, "View details button clicked for meal: " + currentMeal.getStrMeal());
                onClick(currentMeal); // Use the onClick handler for the meal
            }
            else {
                Log.d(TAG, "No meals received to display");

            }
        });


        Log.d(TAG, "Presenter initialized and meals requested"); // Log presenter setup

        return view;
    }


    @Override
    public void showData(List<Meal> meals) {
        if (meals != null && !meals.isEmpty()) {
            Log.d(TAG, "showData called with meals: " + meals.size());
            currentMeal = meals.get(0);
            Log.d("MealDay", "Ingredients: " + currentMeal.getIngredients());
            Log.d("MealDay", "Measures: " + currentMeal.getMeasures());
            // Update UI with meal details
            tvMealName.setText(currentMeal.getStrMeal());
            tvMealOrigin.setText(currentMeal.getStrArea());
            Glide.with(requireContext())
                    .load(currentMeal.getStrMealThumb()).apply(new RequestOptions().override(200,200)).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_foreground)
                    .into(mealImage);
            Log.d(TAG, "Meal data displayed: " + currentMeal.getStrMeal());
        }
        else
        {
            Log.d(TAG, "No meals received to display");
        }


    }

    @Override
    public void showErrMsg(String error) {
        Log.e(TAG, "Error occurred: " + error); // Log error messages
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setMessage(error).setTitle("an error occurred");
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    @Override
    public void showCategory(List<Category> categories) {
        mealCategoryAdapter.setList(categories);
        mealCategoryAdapter.notifyDataSetChanged();
    }


    @Override
    public void onClick(Meal meal) {
        Log.d(TAG, "onClick triggered for meal: " + meal.getStrMeal());
        // Handle the click event to navigate to the MealDetailActivity
        Intent intent = new Intent(requireContext(), MealDetailActivity.class);
       //Ensure that the  Meal implements Serializable or Parcelable. This is necessary for Android to be able to serialize the object and pass it between activities.
        intent.putExtra("meal", meal); // Pass the meal object to the details screen
        Log.d(TAG, "Meal object added to intent: " + meal.getStrMeal());
        startActivity(intent);
        Log.d(TAG, "Started MealDetailActivity with meal: " + meal.getStrMeal());

    }
}
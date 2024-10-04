package com.example.gourmetguide.mealplan.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.gourmetguide.R;
import com.example.gourmetguide.db.MealsLocalDataSourceImpl;
import com.example.gourmetguide.mealDetail.viewer.MealDetailActivity;
import com.example.gourmetguide.mealplan.presenter.PlanPresenter;
import com.example.gourmetguide.mealplan.presenter.PlanPresenterIpml;
import com.example.gourmetguide.model.Meal;
import com.example.gourmetguide.model.MealPlan;
import com.example.gourmetguide.model.MealRepositoryImpl;
import com.example.gourmetguide.network.MealsRemoteDataSourceImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class MealPlanFragment extends Fragment  implements onMealPlanClickListener , MealPlanView{
    private CalendarView calendarView;
    private RecyclerView mealPlanRecyclerView;
    private MealPlanAdapter mealPlanAdapter;
    LinearLayoutManager linearLayout;
    PlanPresenter presenter;
    private LiveData<List<MealPlan>> planList;
    private static final String TAG = "MealPlanFragment";
    Button btnViewDetails;
    MealPlan currentMeal;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_meal_plan, container, false);

        // Initialize CalendarView
        calendarView = view.findViewById(R.id.calendarView);
        // Set the minimum date to today
        Calendar calendar = Calendar.getInstance();
        calendarView.setMinDate(calendar.getTimeInMillis());


        // Initialize RecyclerView
        mealPlanRecyclerView = view.findViewById(R.id.recyclerViewMeals);
        mealPlanRecyclerView.setHasFixedSize(true);
        linearLayout = new LinearLayoutManager(getContext());
        mealPlanAdapter = new MealPlanAdapter(new ArrayList<>(),requireContext(),  this);
        presenter = new PlanPresenterIpml(this , MealRepositoryImpl.getInstance(MealsRemoteDataSourceImpl.getInstance(), MealsLocalDataSourceImpl.getInstance(requireContext())));
        mealPlanRecyclerView.setLayoutManager(linearLayout);
        mealPlanRecyclerView.setAdapter(mealPlanAdapter);


        // Handle date change and show meals for that day
        calendarView.setOnDateChangeListener((view1, year, month, dayOfMonth) -> {
            Calendar selectedDate = Calendar.getInstance();
            selectedDate.set(year, month, dayOfMonth, 0, 0, 0);
            selectedDate.set(Calendar.MILLISECOND, 0);

            Log.d(TAG, "Selected date: " + selectedDate.getTime());

            if (!selectedDate.before(Calendar.getInstance()))
            {
                planList=presenter.getPlannedMeals(selectedDate.getTime());
                planList.observe(getViewLifecycleOwner(), new Observer<List<MealPlan>>() {
                    @Override
                    public void onChanged(List<MealPlan> mealPlans) {
                        Log.d(TAG, "Meal plans fetched: " + (mealPlans != null ? mealPlans.size() : 0)); // Log number of meal plans
                        if(mealPlans != null)
                        {
                            showData(mealPlans);
                        }
                        else
                        {
                            Log.d(TAG, "Selected date is in the past.");
                            showErrMsg("There are no meals");
                        }
                    }
                });
            }


        });


//        btnViewDetails.setOnClickListener(v -> {
//            if (currentMeal != null) {
//               // Log.d(TAG, "View details button clicked for meal: " + currentMeal.getStrMeal());
//                onClick(currentMeal); // Use the onClick handler for the meal
//            }
//            else {
//                Log.d(TAG, "No meals received to display");
//
//            }
//        });

        return view;
    }

    @Override
    public void onClick(MealPlan mealPlan) {
        Meal meal = mealPlan.getMeal();
        Intent intent = new Intent(getContext(), MealDetailActivity.class);
        intent.putExtra("meal", meal);
        startActivity(intent);

    }

    @Override
    public void showData(List<MealPlan> meals) {
        Log.d(TAG, "Showing meals: " + meals);
        mealPlanAdapter.setList(meals);
    }

    @Override
    public void showErrMsg(String error) {
        Log.e(TAG, error);
        Toast.makeText(getContext(), "An Error Occurred", Toast.LENGTH_SHORT).show();
    }
}
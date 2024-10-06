package com.example.gourmetguide.mealFav.view;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gourmetguide.R;
import com.example.gourmetguide.db.MealsLocalDataSourceImpl;
import com.example.gourmetguide.mealFav.presenter.MealFavPresenter;
import com.example.gourmetguide.mealFav.presenter.MealFavPresenterImpl;
import com.example.gourmetguide.model.Meal;
import com.example.gourmetguide.model.MealRepositoryImpl;
import com.example.gourmetguide.network.MealsRemoteDataSourceImpl;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;


public class MealFavFragment extends Fragment implements onMealFavClickListener , MealFavView {

    private MealFavPresenter favPresenter;

    private Button btnDelete;


    private LiveData<List<Meal>> mealList;

    RecyclerView favRecyclerView;
    LinearLayoutManager linearLayout;
    MealFavAdapter mealFavAdapter;


    private static final String TAG = "MealFavFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_meal_fav, container, false);

        favRecyclerView =view.findViewById(R.id.recyclerView2);
        favRecyclerView.setHasFixedSize(true);

        linearLayout = new LinearLayoutManager(requireContext());
        mealFavAdapter = new MealFavAdapter(new ArrayList<>(),requireContext(),  this);
        favPresenter = new MealFavPresenterImpl(this, MealRepositoryImpl.getInstance(MealsRemoteDataSourceImpl.getInstance(), MealsLocalDataSourceImpl.getInstance(requireContext())));
        favRecyclerView.setLayoutManager(linearLayout);
        favRecyclerView.setAdapter(mealFavAdapter);
        mealList = favPresenter.getMeals();

        mealList.observe(getViewLifecycleOwner(), new Observer<List<Meal>>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onChanged(List<Meal> meals) {
                if (meals != null) {
                    showData(meals);
                }
                else {
                    showErrMsg("There are no meals");
                }
            }
        });

        return view;
    }

    @Override
    public void showData(List<Meal> meals) {
        mealFavAdapter.setList(meals);
        mealFavAdapter.notifyDataSetChanged();
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
    public void onClick(Meal meal) {
        favPresenter.deleteFromFav(meal);
        showUndoSnackbar(meal);
        //favPresenter.addToFav(meal);
    }
    private void showUndoSnackbar(Meal deletedMeal) {
        Snackbar snackbar = Snackbar.make(favRecyclerView, "Meal deleted", Snackbar.LENGTH_LONG);
        snackbar.setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favPresenter.addToFav(deletedMeal);  // Add the meal back if undo is clicked
            }
        });
        snackbar.show();
    }


}
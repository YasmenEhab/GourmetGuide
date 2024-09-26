package com.example.gourmetguide.mealDetail.viewer;

import static androidx.core.content.ContentProviderCompat.requireContext;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.gourmetguide.R;
import com.example.gourmetguide.db.MealsLocalDataSourceImpl;
import com.example.gourmetguide.mealDetail.presenter.MealDetailPresenter;
import com.example.gourmetguide.mealDetail.presenter.MealDetailPresenterImpl;
import com.example.gourmetguide.mealOfTheDay.presenter.MealDayPresenter;
import com.example.gourmetguide.mealOfTheDay.presenter.MealDayPresenterImpl;
import com.example.gourmetguide.model.Meal;
import com.example.gourmetguide.model.MealRepositoryImpl;
import com.example.gourmetguide.network.MealsRemoteDataSourceImpl;

import android.widget.VideoView;
import android.net.Uri;
import android.widget.MediaController;

import java.util.List;

public class MealDetailActivity extends AppCompatActivity implements onMealDetailClickListener , MealDetailView {
    private MealDetailPresenter presenter;
    private TextView tvMealName, tvMealOrigin;
    private ImageView mealImage;
    private Button btnAddFav;
    private Meal currentMeal;
    private WebView webView;

    private static final String TAG = "MealDetailActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_meal_detail);

        // Initialize views
        tvMealName   = findViewById(R.id.tv_meal_name_detail);
        tvMealOrigin = findViewById(R.id.tv_meal_origin_detail);
        mealImage    = findViewById(R.id.meal_image_detail);
        btnAddFav    = findViewById(R.id.btn_add_favorite);
        webView = findViewById(R.id.webview);

        // Retrieve the Meal object from the intent
        Intent intent = getIntent();
        currentMeal = (Meal) intent.getSerializableExtra("meal");
        Log.d(TAG, "Intent extras: " + intent.getExtras());
        if (currentMeal == null) {
            Log.e(TAG, "Current meal is null, check the intent data");
        }
        else {
            tvMealName.setText(currentMeal.getStrMeal());
            tvMealOrigin.setText(currentMeal.getStrArea());

            webView.getSettings().setJavaScriptEnabled(true);
            String videoUrl =currentMeal.strYoutube.replace("watch?v=", "embed/");
            Log.d(TAG, "Video URL: " + videoUrl);
            webView.loadUrl(videoUrl);

            Glide.with(this)
                    .load(currentMeal.getStrMealThumb()).apply(new RequestOptions().override(200,200)).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_foreground)
                    .into(mealImage);
            Log.d(TAG, "Meal data displayed: " + currentMeal.getStrMeal());
        }




        // Set up the presenter
        presenter = new MealDetailPresenterImpl(this, MealRepositoryImpl.getInstance(MealsRemoteDataSourceImpl.getInstance(), MealsLocalDataSourceImpl.getInstance(this))) ;
        //presenter.getMeals();

        btnAddFav.setOnClickListener(v -> {
            if (currentMeal != null) {
                presenter.addToFav(currentMeal); // Add the meal to favorites
                Toast.makeText(this, "Added to favorites", Toast.LENGTH_SHORT).show();
            }
        });

    }



    // shall i remove the implementation
    @Override
    public void showData(List<Meal> meals) {
            if (meals != null && !meals.isEmpty()) {
            Log.d(TAG, "showData called with meals: " + meals.size());
            currentMeal = meals.get(0);

            // Update UI with meal details
            tvMealName.setText(currentMeal.getStrMeal());
            tvMealOrigin.setText(currentMeal.getStrArea());

            Glide.with(this)
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
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(error).setTitle("an error occurred");
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}
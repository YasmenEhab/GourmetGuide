package com.example.gourmetguide.network;

import com.example.gourmetguide.model.CategoryResponse;
import com.example.gourmetguide.model.MealResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MealsRemoteDataSourceImpl implements MealsRemoteDataSource {
    private static final String TAG = "MealClient";
    private static final String BASE_URL = "https://www.themealdb.com/api/";
    private static MealsRemoteDataSourceImpl client = null;
    private MealService mealService;


    // Private constructor for Singleton pattern
    private MealsRemoteDataSourceImpl() {
        // Converts JSON to Java objects
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create an implementation of the API endpoint interface
        mealService = retrofit.create(MealService.class);
    }

    // Singleton instance
    public static MealsRemoteDataSourceImpl getInstance() {
        if (client == null) {
            client = new MealsRemoteDataSourceImpl();
        }
        return client;
    }

    @Override
    public void makeNetworkCall(NetworkCallback networkCallback) {
        Call<MealResponse> call = mealService.getMeals();

        // Enqueue the call for async response
        call.enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Assuming meals is a public field in MealResponse or accessed via getter
                    networkCallback.onSuccessfulResponse(response.body().meals);
                } else {
                    networkCallback.onFailureResponse("Error: Response body is null or not successful");
                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable throwable) {
                networkCallback.onFailureResponse(throwable.getMessage());
            }
        });
    }

    @Override
    public void makeNetworkCall2(NetworkCallback networkCallback, ApiType apiType) {
        switch (apiType) {
            case RANDOM_MEAL:
                Call<MealResponse> mealCall = mealService.getMeals(); // Adjust to your random meal API method
                mealCall.enqueue(new Callback<MealResponse>() {
                    @Override
                    public void onResponse(Call<MealResponse> call, Response<MealResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            networkCallback.onSuccessfulResponse(response.body().meals);
                        } else {
                            networkCallback.onFailureResponse("Error: Response not successful");
                        }
                    }

                    @Override
                    public void onFailure(Call<MealResponse> call, Throwable throwable) {
                        networkCallback.onFailureResponse(throwable.getMessage());
                    }
                });
                break;

            case CATEGORY:
                Call<CategoryResponse> categoryCall = mealService.getMealCategories();
                categoryCall.enqueue(new Callback<CategoryResponse>() {
                    @Override
                    public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            networkCallback.onSuccessfulResponseCategory(response.body().categories);
                        } else {
                            networkCallback.onFailureResponse("Error: Response not successful");
                        }
                    }

                    @Override
                    public void onFailure(Call<CategoryResponse> call, Throwable throwable) {
                        networkCallback.onFailureResponse(throwable.getMessage());
                    }
                });
                break;

            default:
                throw new IllegalArgumentException("Unknown API type");
        }
    }
}

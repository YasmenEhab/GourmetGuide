package com.example.gourmetguide.mealOfTheDay.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gourmetguide.model.Meal;

import java.util.List;

//public class MealDayAdapter extends RecyclerView.Adapter<MealDayAdapter.ViewHolder> {
//
//    private final Context context;
//    private List<Meal> p;
//    private static final String TAG = "Recycler viewer";
//    private  onMealClickListener listener;
//
//    public MealDayAdapter(List<Meal> c, Context context, onMealClickListener _listener ) {
//        this.context = (Context) context;
//        this.p = c;
//        this.listener=_listener;
//    }
//
///   public class ViewHolder extends RecyclerView.ViewHolder {
////        TextView titleview, priceview, desview;
////        //public ArrayList<Product> productlist;
////        RatingBar ratingbar;
////        ImageView thumbnailimg;
////        ConstraintLayout constraintlayout;
////        View layout;
////        Button addfav;
//
//
//
//        public ViewHolder(@NonNull View v) {
//            super(v);
////            layout = v;
////            titleview = v.findViewById(R.id.titleview);
////            priceview = v.findViewById(R.id.priceview);
////            desview = v.findViewById(R.id.desview);
////            ratingbar = v.findViewById(R.id.ratingBar);
////            thumbnailimg = v.findViewById(R.id.thumbnailimg);
////            constraintlayout = v.findViewById(R.id.consLayout);
////            addfav = v.findViewById(R.id.btnAddFav);
////
////
//        }
//    }
//
//    @NonNull
//    @Override
//    public MealDayAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MealDayAdapter.ViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//}

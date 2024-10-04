package com.example.gourmetguide.mealFav.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.gourmetguide.R;
import com.example.gourmetguide.mealOfTheDay.view.onMealClickListener;
import com.example.gourmetguide.model.Meal;

import java.util.List;

public class MealFavAdapter extends RecyclerView.Adapter<MealFavAdapter.ViewHolder>{

    private final Context context;
    private List<Meal> p;
    private static final String TAG = "Fav Recycler viewer";
    private onMealFavClickListener listener;

    public MealFavAdapter(List<Meal> c, Context context, onMealFavClickListener _listener ) {
        this.context = (Context) context;
        this.p = c;
        this.listener=_listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleview, tvMealOrigin;
        ImageView thumbnailimg;
        LinearLayout linearLayout;
        View layout;
        Button addDelFav;



        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
            titleview = v.findViewById(R.id.fav_meal_name);
            tvMealOrigin = v.findViewById(R.id.fav_meal_origin);
            thumbnailimg = v.findViewById(R.id.fav_image);
            addDelFav = v.findViewById(R.id.btn_delete);


        }
    }
    public void setList(List<Meal> meals) {
        this.p=meals;
    }
    @NonNull
    @Override
    public MealFavAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.fav_item, parent, false);
        MealFavAdapter.ViewHolder vh = new MealFavAdapter.ViewHolder(v);
        Log.i(TAG, "===== onCreateViewHolder =====");
        Log.i(TAG, "deals with inflation of the card layout as item for recycler view");
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MealFavAdapter.ViewHolder holder, int position) {
        holder.titleview.setText(p.get(position).getStrMeal());
        holder.tvMealOrigin.setText(p.get(position).getStrArea());
        Glide.with(context)
                .load(p.get(position).getStrMealThumb()).apply(new RequestOptions().override(200,200)).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_foreground)
                .into(holder.thumbnailimg);

        holder.addDelFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick( p.get(position));
                Toast.makeText(context,p.get(position).getStrMeal(),Toast.LENGTH_SHORT).show();

            }

        });
        Log.i(TAG, "***** onBindViewHolder **************");
        Log.i(TAG, "deals with different data and methods related to click on particular item for recycler view");

    }

    @Override
    public int getItemCount() {
        //Log.i(TAG, "***** getItemCount **************");
        //Log.i(TAG, "return length of recycler view ");
        return p.size();
    }
}

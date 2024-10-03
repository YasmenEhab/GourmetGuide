package com.example.gourmetguide.mealplan.view;

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
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.gourmetguide.R;
import com.example.gourmetguide.mealFav.view.MealFavAdapter;
import com.example.gourmetguide.mealFav.view.onMealFavClickListener;
import com.example.gourmetguide.model.Meal;
import com.example.gourmetguide.model.MealPlan;

import java.util.List;

public class MealPlanAdapter extends RecyclerView.Adapter<MealPlanAdapter.ViewHolder>{

    private final Context context;
    private List<MealPlan> p;
    private static final String TAG = "Recycler viewer";
    private onMealPlanClickListener listener;

    public MealPlanAdapter(List<MealPlan> c, Context context, onMealPlanClickListener _listener ) {
        this.context = (Context) context;
        this.p = c;
        this.listener=_listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleview, tvMealOrigin;
        ImageView thumbnailimg;
        LinearLayout linearLayout;
        View layout;
        Button btnShowDetail;



        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
            titleview = v.findViewById(R.id.txtMealPlanName);
            //tvMealOrigin = v.findViewById(R.id.fav_meal_origin);
            thumbnailimg = v.findViewById(R.id.imgMealPlan);
            btnShowDetail = v.findViewById(R.id.btnMealPlanShowDetails);


        }
    }
    public void setList(List<MealPlan> meals) {
        this.p.clear(); // Clear the existing list
        if (meals != null) {
            this.p.addAll(meals); // Add new meals if not null
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public MealPlanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.plan_item, parent, false);
        MealPlanAdapter.ViewHolder vh = new MealPlanAdapter.ViewHolder(v);
        Log.i(TAG, "===== onCreateViewHolder =====");
        Log.i(TAG, "deals with inflation of the card layout as item for recycler view");
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MealPlanAdapter.ViewHolder holder, int position) {
        holder.titleview.setText(p.get(position).getMeal().getStrMeal());
        Glide.with(context)
                .load(p.get(position).getMeal().getStrMealThumb()).apply(new RequestOptions().override(200,200)).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_foreground)
                .into(holder.thumbnailimg);

        holder.btnShowDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick( p.get(position));
                Toast.makeText(context,p.get(position).getMeal().getStrMeal(),Toast.LENGTH_SHORT).show();

            }
        });
    }


    @Override
    public int getItemCount() {
         //   Log.i(TAG, "***** getItemCount **************");
           // Log.i(TAG, "return length of recycler view ");
            return p.size();
    }
}

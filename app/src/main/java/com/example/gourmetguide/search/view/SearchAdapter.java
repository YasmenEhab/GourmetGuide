package com.example.gourmetguide.search.view;

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
import com.example.gourmetguide.model.Meal;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>{

    private final Context context;
    private List<Meal> p;
    private static final String TAG = "Recycler viewer";
    private onMealSearchClickListener listener;

    public SearchAdapter(List<Meal> c, Context context, onMealSearchClickListener _listener ) {
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
            titleview = v.findViewById(R.id.meal_name);
            tvMealOrigin = v.findViewById(R.id.meal_origin);
            thumbnailimg = v.findViewById(R.id.image);
            btnShowDetail = v.findViewById(R.id.btn_show_detail);


        }
    }

    public void setList(List<Meal> meals) {
        this.p=meals;
    }
    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item, parent, false);
        SearchAdapter.ViewHolder vh = new SearchAdapter.ViewHolder(v);
        Log.i(TAG, "===== onCreateViewHolder =====");
        Log.i(TAG, "deals with inflation of the card layout as item for recycler view");
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder holder, int position) {
        holder.titleview.setText(p.get(position).getStrMeal());
        holder.tvMealOrigin.setText(p.get(position).getStrArea());
        Glide.with(context)
                .load(p.get(position).getStrMealThumb()).apply(new RequestOptions().override(200,200)).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_foreground)
                .into(holder.thumbnailimg);

        holder.btnShowDetail.setOnClickListener(new View.OnClickListener() {
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
        Log.i(TAG, "***** getItemCount **************");
        Log.i(TAG, "return length of recycler view ");
        return p.size();
    }
}

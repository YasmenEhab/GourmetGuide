package com.example.gourmetguide.mealOfTheDay.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.gourmetguide.R;
import com.example.gourmetguide.arealist.view.AreaActivity;
import com.example.gourmetguide.categorylist.view.CategoryActivity;
import com.example.gourmetguide.model.Area;

import java.util.List;

public class AreaAdapter extends RecyclerView.Adapter<AreaAdapter.ViewHolder>{

    private final Context context;
    private List<Area> p;
    private static final String TAG = "Area Recycler viewer";
    private onMealClickListener listener;

    public AreaAdapter(List<Area> c, Context context, onMealClickListener _listener ) {
        this.context = (Context) context;
        this.p = c;
        this.listener=_listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView strArea;
        ImageView strAreaThumb;
        LinearLayout linearLayout;
        View layout;
        //Button viewDetail;



        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
            strArea = v.findViewById(R.id.country_name);
            strAreaThumb = v.findViewById(R.id.country_image);
            //linearLayout = v.findViewById(R.id.linLayout);
            // viewDetail = v.findViewById(R.id.btn_show_detail);

        }
    }
    public void setList(List<Area> areas) {
        this.p =areas;
    }
    @NonNull
    @Override
    public AreaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.country_item, parent, false);
        AreaAdapter.ViewHolder vh = new AreaAdapter.ViewHolder(v);
        Log.i(TAG, "===== onCreateViewHolder =====");
        Log.i(TAG, "deals with inflation of the card layout as item for recycler view");
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AreaAdapter.ViewHolder holder, int position) {
        Area area = p.get(position);
        holder.strArea.setText(p.get(position).getStrArea());
//        Glide.with(context)
//                .load(p.get(position).getStrCategoryThumb()).apply(new RequestOptions().override(200,200)).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_foreground)
//                .into(holder.strAreaThumb);
        holder.layout.setOnClickListener(v -> {
            // Intent to navigate to the new activity
            Intent intent = new Intent(context, AreaActivity.class);
            intent.putExtra("COUNTRY_NAME", area.getStrArea());
            Log.i(TAG, "send country" + area.getStrArea());
            context.startActivity(intent);
        });

        Log.i(TAG, "***** onBindViewHolder **************");
        Log.i(TAG, "deals with different data and methods related to click on particular item for recycler view");

    }

    @Override
    public int getItemCount() {
        return p.size();
    }
}

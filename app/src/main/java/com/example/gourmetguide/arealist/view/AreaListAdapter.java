package com.example.gourmetguide.arealist.view;

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
import com.example.gourmetguide.categorylist.view.CategoryViewAdapter;
import com.example.gourmetguide.categorylist.view.onCategoryClickListener;
import com.example.gourmetguide.model.Meal;

import java.util.List;

public class AreaListAdapter extends RecyclerView.Adapter<AreaListAdapter.ViewHolder>{

    private final Context context;
    private List<Meal> p;
    private static final String TAG = "Country Recycler viewer";
    private onAreaClickLIstener listener;

    public AreaListAdapter(List<Meal> c, Context context, onAreaClickLIstener _listener ) {
        this.context = (Context) context;
        this.p = c;
        this.listener=_listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleview;
        ImageView thumbnailimg;
        LinearLayout linearLayout;
        View layout;
        Button btnShowDetail;



        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
            titleview = v.findViewById(R.id.tv_meal_name_in_country);
            thumbnailimg = v.findViewById(R.id.meal_image_in_country);
            btnShowDetail = v.findViewById(R.id.btn_view_details_in_country);

        }
    }
    public void setList(List<Meal> meals) {
        this.p=meals;
    }

    @NonNull
    @Override
    public AreaListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.country_list_item, parent, false);
        AreaListAdapter.ViewHolder vh = new AreaListAdapter.ViewHolder(v);
        Log.i(TAG, "===== onCreateViewHolder =====");
        Log.i(TAG, "deals with inflation of the card layout as item for recycler view");
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AreaListAdapter.ViewHolder holder, int position) {
        holder.titleview.setText(p.get(position).getStrMeal());
        String[] countryCodes = {
                "us", // American
                "gb", // British
                "ca", // Canadian
                "cn", // Chinese
                "hr", // Croatian
                "nl", // Dutch
                "eg", // Egyptian
                "ph", // Filipino
                "fr", // French
                "gr", // Greek
                "in", // Indian
                "ie", // Irish
                "it", // Italian
                "jm", // Jamaican
                "jp", // Japanese
                "ke", // Kenyan
                "my", // Malaysian
                "mx", // Mexican
                "ma", // Moroccan
                "pl", // Polish
                "pt", // Portuguese
                "ru", // Russian
                "es", // Spanish
                "th", // Thai
                "tn", // Tunisian
                "tr", // Turkish
                "ua",
                "",// Ukrainian
                "vn"  // Vietnamese
        };
        String url = "https://flagcdn.com/160x120/"+countryCodes[position]+".png";

        //Glide.with(context).load(url).into(holder.thumbnailimg);
        Glide.with(context).load(url)
                .apply(new RequestOptions().override(200, 200)
                        .placeholder(R.drawable.ic_launcher_background)
                        .error(R.drawable.ic_launcher_foreground))
                .into(holder.thumbnailimg);



//        Glide.with(context)
//                .load(p.get(position).getStrMealThumb()).apply(new RequestOptions().override(200,200)).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_foreground)
//                .into(holder.thumbnailimg);
        holder.btnShowDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick( p.get(position));
                Toast.makeText(context,p.get(position).getStrMeal(),Toast.LENGTH_SHORT).show();

            }

        });
    }

    @Override
    public int getItemCount() {
        return p.size();
    }
}

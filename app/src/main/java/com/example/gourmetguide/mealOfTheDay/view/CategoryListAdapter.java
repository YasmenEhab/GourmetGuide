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
import com.example.gourmetguide.categorylist.view.CategoryActivity;
import com.example.gourmetguide.model.Category;

import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder>{

    private final Context context;
    private List<Category> p;
    private static final String TAG = "Category Recycler viewer";
    private onMealClickListener listener;

    public CategoryListAdapter(List<Category> c, Context context, onMealClickListener _listener ) {
        this.context = (Context) context;
        this.p = c;
        this.listener=_listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView strCategory ;
        ImageView strCategoryThumb;
        LinearLayout linearLayout;
        View layout;
        //Button viewDetail;



        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
            strCategory = v.findViewById(R.id.category_name);
            strCategoryThumb = v.findViewById(R.id.category_image);
            //linearLayout = v.findViewById(R.id.linLayout);
            // viewDetail = v.findViewById(R.id.btn_show_detail);


        }
    }

    public void setList(List<Category> categories) {
        this.p =categories;
    }

    @NonNull
    @Override
    public CategoryListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.category_item, parent, false);
        CategoryListAdapter.ViewHolder vh = new CategoryListAdapter.ViewHolder(v);
        Log.i(TAG, "===== onCreateViewHolder =====");
        Log.i(TAG, "deals with inflation of the card layout as item for recycler view");
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryListAdapter.ViewHolder holder, int position) {
        Category category = p.get(position);
        holder.strCategory.setText(p.get(position).getStrCategory());
        Glide.with(context)
                .load(p.get(position).getStrCategoryThumb()).apply(new RequestOptions().override(200,200)).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_foreground)
                .into(holder.strCategoryThumb);
        holder.layout.setOnClickListener(v -> {
            // Intent to navigate to the new activity
            Intent intent = new Intent(context, CategoryActivity.class);
            intent.putExtra("CATEGORY_NAME", category.getStrCategory());
            Log.i(TAG, "send category" + category.getStrCategory());
            context.startActivity(intent);
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

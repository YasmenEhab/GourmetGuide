package com.example.gourmetguide.mealOfTheDay.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gourmetguide.R;
import com.example.gourmetguide.model.Category;
import com.example.gourmetguide.searchbycategory.view.SearchByCategoryAdapter2;
import com.example.gourmetguide.searchbycategory.view.onMealSearchCategoryClickListener;

import java.util.List;

//public class MealDayAdapter extends RecyclerView.Adapter<MealDayAdapter.RecyclerView.ViewHolder>{
//
//    private final Context context;
//    private List<Category> p;
//    private static final String TAG = "Recycler viewer";
//    private onMealClickListener listener;
//
//    public MealDayAdapter(List<Category> c, Context context, onMealClickListener _listener ) {
//        this.context = (Context) context;
//        this.p = c;
//        this.listener=_listener;
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        TextView strCategory ;
//        ImageView strCategoryThumb;
//        LinearLayout linearLayout;
//        View layout;
//        //Button viewDetail;
//
//
//
//        public ViewHolder(@NonNull View v) {
//            super(v);
//            layout = v;
//            strCategory = v.findViewById(R.id.category_name);
//            strCategoryThumb = v.findViewById(R.id.category_image);
//            //linearLayout = v.findViewById(R.id.linLayout);
//            // viewDetail = v.findViewById(R.id.btn_show_detail);
//
//
//        }
//    }
//
//    public void setList(List<Category> categories) {
//        this.p =categories;
//    }
//
//    @NonNull
//    @Override
//    public MealDayAdapter.RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        View v = inflater.inflate(R.layout.category_item, parent, false);
//        MealDayAdapter.ViewHolder vh = new MealDayAdapter.ViewHolder(v);
//        Log.i(TAG, "===== onCreateViewHolder =====");
//        Log.i(TAG, "deals with inflation of the card layout as item for recycler view");
//        return vh;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MealDayAdapter.RecyclerView.ViewHolder holder, int position) {
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//}

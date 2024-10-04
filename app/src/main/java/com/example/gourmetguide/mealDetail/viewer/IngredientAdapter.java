package com.example.gourmetguide.mealDetail.viewer;

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
import java.util.stream.Collectors;

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.ViewHolder>{
    private final Context context;
    private List<Meal> p;
    private  List<String> ingredients;
    private List<String> measures;
    String imageUrl;
    private static final String TAG = "Ingredient Recycler viewer";

    public IngredientAdapter( List<String> ingredients, List<String> measures, Context context ) {
        this.context = (Context) context;
        this.ingredients = ingredients;
        this.measures = measures;

       // this.p = c;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView igredientName, indredientMeasure;
        ImageView thumbnailimg;
        LinearLayout linearLayout;
        View layout;



        public ViewHolder(@NonNull View v) {
            super(v);
            layout = v;
            igredientName = v.findViewById(R.id.txt_ingredient_name);
            indredientMeasure = v.findViewById(R.id.txt_ingredient_measure);
            thumbnailimg = v.findViewById(R.id.img_ingredient);

        }
    }

    public void setList(List<String> ingredients) {
        this.ingredients=ingredients;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public IngredientAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_ingredient, parent, false);
        IngredientAdapter.ViewHolder vh = new IngredientAdapter.ViewHolder(v);
        Log.i(TAG, "===== onCreateViewHolder =====");
        Log.i(TAG, "deals with inflation of the card layout as item for recycler view");
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull IngredientAdapter.ViewHolder holder, int position) {
//        Meal meal =p.get(position);
//        List<String> nonNullIngredients = meal.getNonNullIngredients();
//        String ingredientsString = nonNullIngredients.stream().collect(Collectors.joining(", "));
//
//        holder.igredientName.setText(ingredientsString);
      //  holder.igredientName.setText(ingredients.get(position));
       // holder.indredientMeasure.setText(p.get(position).getStrArea());
//        Glide.with(context)
//                .load(p.get(position).getStrMealThumb()).apply(new RequestOptions().override(200,200)).placeholder(R.drawable.ic_launcher_background).error(R.drawable.ic_launcher_foreground)
//                .into(holder.thumbnailimg);

        if(ingredients.get(position) != null && !ingredients.get(position).isEmpty()) {
            imageUrl = "https://www.themealdb.com/images/ingredients/" + ingredients.get(position) + ".png";
            Glide.with(context).load(imageUrl)
                    .apply(new RequestOptions().override(200, 200)
                            .placeholder(R.drawable.ic_launcher_background)
                            .error(R.drawable.ic_launcher_foreground))
                    .into(holder.thumbnailimg);
            holder.igredientName.setText(ingredients.get(position));
            holder.indredientMeasure.setText(measures.get(position));


        }
        else {
            holder.igredientName.setText("");
            holder.indredientMeasure.setText("");  // Clear both ingredient and measure fields
            holder.thumbnailimg.setImageDrawable(null);  // Optionally clear the image

        }


            Log.i(TAG, "***** onBindViewHolder **************");
        Log.i(TAG, "deals with different data and methods related to click on particular item for recycler view");

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}

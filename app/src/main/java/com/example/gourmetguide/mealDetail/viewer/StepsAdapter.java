package com.example.gourmetguide.mealDetail.viewer;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gourmetguide.R;

import java.util.List;

public class StepsAdapter extends RecyclerView.Adapter<StepsAdapter.ViewHolder>{

    private List<String> steps;
    private static final String TAG = "step Recycler viewer";
    public StepsAdapter(List<String> steps) {
        this.steps = steps;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvStep;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvStep = itemView.findViewById(R.id.tv_step_description);
        }
    }
    @NonNull
    @Override
    public StepsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_step, parent, false);
        StepsAdapter.ViewHolder vh = new StepsAdapter.ViewHolder(v);
        Log.i(TAG, "===== onCreateViewHolder =====");
        Log.i(TAG, "deals with inflation of the card layout as item for recycler view");
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull StepsAdapter.ViewHolder holder, int position) {
        holder.tvStep.setText(steps.get(position));
    }

    @Override
    public int getItemCount() {
        return steps.size();
    }
}

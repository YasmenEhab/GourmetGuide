package com.example.gourmetguide.mealDetail.viewer;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.example.gourmetguide.R;
import com.example.gourmetguide.model.Meal;
import com.example.gourmetguide.model.MealPlan;

import java.util.Calendar;
import java.util.Date;


public class DatePickerDialogFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private OnDateSelectedListener listener;

    public interface OnDateSelectedListener {
        void onDateSelected(long dateInMillis);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use current date as default values for picker
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Create a DatePickerDialog with today's date as minimum
        DatePickerDialog dialog = new DatePickerDialog(requireContext(), this, year, month, day);
        dialog.getDatePicker().setMinDate(calendar.getTimeInMillis()); // Disable past dates
        return dialog;
    }

    public void setOnDateSelectedListener(OnDateSelectedListener listener) {
        this.listener = listener;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day,0,0,0);
        calendar.set(calendar.MILLISECOND , 0);
        long dateInMillis = calendar.getTimeInMillis();
        if (listener != null) {
            listener.onDateSelected(dateInMillis);
        }
    }
}

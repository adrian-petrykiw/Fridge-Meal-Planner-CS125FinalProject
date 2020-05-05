package com.example.mealplannercs125.ui.notifications;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mealplannercs125.R;
import com.example.mealplannercs125.ui.dashboard.DashboardFragment;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends DashboardFragment {

    private Spinner mondaybreakfastspinner;
    private Spinner mondaylunchspinner;
    private Spinner mondaydinnerspinner;

    private Spinner tuesdaybreakfastspinner;
    private Spinner tuesdaylunchspinner;
    private Spinner tuesdaydinnerspinner;

    private Spinner wednesdaybreakfastspinner;
    private Spinner wednesdaylunchspinner;
    private Spinner wednesdaydinnerspinner;

    private Spinner thursdaybreakfastspinner;
    private Spinner thursdaylunchspinner;
    private Spinner thursdaydinnerspinner;

    private Spinner fridaybreakfastspinner;
    private Spinner fridaylunchspinner;
    private Spinner fridaydinnerspinner;

    private Spinner saturdaybreakfastspinner;
    private Spinner saturdaylunchspinner;
    private Spinner saturdaydinnerspinner;

    private Spinner sundaybreakfastspinner;
    private Spinner sundaylunchspinner;
    private Spinner sundaydinnerspinner;


    private NotificationsViewModel notificationsViewModel;
    @Nullable
    @Override
    public Context getContext() {
        return context;
    }

    private Context context;

    TextView textView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        textView = root.findViewById(R.id.mealplan);
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText("Meal Plan");
            }
        });

        mondaybreakfastspinner = root.findViewById(R.id.mondaybreakfast);
        mondaylunchspinner = root.findViewById(R.id.mondaylunch);
        mondaydinnerspinner = root.findViewById(R.id.mondaydinner);
        tuesdaybreakfastspinner = root.findViewById(R.id.tuesdaybreakfast);
        tuesdaylunchspinner = root.findViewById(R.id.tuesdaylunch);
        tuesdaydinnerspinner = root.findViewById(R.id.tuesdaydinner);
        wednesdaybreakfastspinner = root.findViewById(R.id.wednesdaybreakfast);
        wednesdaylunchspinner = root.findViewById(R.id.wednesdaylunch);
        wednesdaydinnerspinner = root.findViewById(R.id.wednesdaydinner);
        thursdaybreakfastspinner = root.findViewById(R.id.thursdaybreakfast);
        thursdaylunchspinner = root.findViewById(R.id.thursdaylunch);
        thursdaydinnerspinner = root.findViewById(R.id.thursdaydinner);
        fridaybreakfastspinner = root.findViewById(R.id.fridaybreakfast);
        fridaylunchspinner = root.findViewById(R.id.fridaylunch);
        fridaydinnerspinner = root.findViewById(R.id.fridaydinner);
        saturdaybreakfastspinner = root.findViewById(R.id.saturdaybreakfast);
        saturdaylunchspinner = root.findViewById(R.id.saturdaylunch);
        saturdaydinnerspinner = root.findViewById(R.id.saturdaydinner);
        sundaybreakfastspinner = root.findViewById(R.id.sundaybreakfast);
        sundaylunchspinner = root.findViewById(R.id.sundaylunch);
        sundaydinnerspinner = root.findViewById(R.id.sundaydinner);

        List<String> currentList = getRecipeList();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(textView.getContext(), android.R.layout.simple_spinner_item, currentList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mondaybreakfastspinner.setAdapter(adapter);
        mondaylunchspinner.setAdapter(adapter);
        mondaydinnerspinner.setAdapter(adapter);
        tuesdaybreakfastspinner.setAdapter(adapter);
        tuesdaylunchspinner .setAdapter(adapter);
        tuesdaydinnerspinner.setAdapter(adapter);
        wednesdaybreakfastspinner.setAdapter(adapter);
        wednesdaylunchspinner.setAdapter(adapter);
        wednesdaydinnerspinner.setAdapter(adapter);
        thursdaybreakfastspinner.setAdapter(adapter);
        thursdaylunchspinner.setAdapter(adapter);
        thursdaydinnerspinner.setAdapter(adapter);
        fridaybreakfastspinner.setAdapter(adapter);
        fridaylunchspinner.setAdapter(adapter);
        fridaydinnerspinner.setAdapter(adapter);
        saturdaybreakfastspinner.setAdapter(adapter);
        saturdaylunchspinner.setAdapter(adapter);
        saturdaydinnerspinner.setAdapter(adapter);
        sundaybreakfastspinner.setAdapter(adapter);
        sundaylunchspinner.setAdapter(adapter);
        sundaydinnerspinner.setAdapter(adapter);

        return root;
    }

}

package com.example.mealplannercs125.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mealplannercs125.R;
import com.example.mealplannercs125.ui.dashboard.DashboardFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.generate_recipes);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        Button recipegen = (Button) root.findViewById(R.id.generate_recipes);
        recipegen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startDash = new Intent(getActivity(), DashboardFragment.class);
                startActivity(startDash);
            }
        });

        return root;
    }
}

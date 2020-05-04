package com.example.mealplannercs125.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mealplannercs125.R;
//import com.spoonacular.DefaultApi;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private String BASE_URL = "https://api.spoonacular.com/recipes/findByIngredients";
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        /*
        DefaultApi apiInstance = new DefaultApi();
        String ingredients = apples,flour,sugar; // String | A comma-separated list of ingredients that the recipes should contain.
        BigDecimal number = 10; // BigDecimal | The maximum number of recipes to return (between 1 and 100). Defaults to 10.
        Boolean limitLicense = true; // Boolean | Whether the recipes should have an open license that allows display with proper attribution.
        BigDecimal ranking = 1; // BigDecimal | Whether to maximize used ingredients (1) or minimize missing ingredients (2) first.
        Boolean ignorePantry = true; // Boolean | Whether to ignore typical pantry items, such as water, salt, flour, etc.
        try {
            Object result = apiInstance.searchRecipesByIngredients(ingredients, number, limitLicense, ranking, ignorePantry);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling DefaultApi#searchRecipesByIngredients");
            e.printStackTrace();
        }
         */
        return root;
    }
}

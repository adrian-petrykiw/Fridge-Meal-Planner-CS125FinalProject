package com.example.mealplannercs125.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mealplannercs125.MainActivity;
import com.example.mealplannercs125.R;
import com.example.mealplannercs125.ui.dashboard.DashboardFragment;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.skyhope.materialtagview.TagView;
import com.skyhope.materialtagview.enums.TagSeparator;
import com.skyhope.materialtagview.model.TagModel;
import org.json.JSONObject;


import java.util.List;

import cz.msebera.android.httpclient.entity.mime.Header;

public class HomeFragment extends Fragment{

    private HomeViewModel homeViewModel;
    private String BASE_URL = "https://api.spoonacular.com/recipes/findByIngredients";
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        //added from here
        TagView tagView = root.findViewById(R.id.text_view_show_more);
        tagView.addTagSeparator(TagSeparator.AT_SEPARATOR);
        String[] tagList = new String[]{"aroma", "bagel", "batter", "beans", "beer", "biscuit",
                "bread", "broth", "burger", "butter", "cake", "candy", "caramel", "caviar",
                "cheese", "chili", "chocolate", "cider", "cobbler", "cocoa", "coffee",
                "cookie", "cream", "croissant", "crumble", "cuisine", "curd",
                "dessert", "dish", "drink", "eggs", "entree", "filet", "fish",
                "flour", "foie gras", "food", "glaze", "grill", "hamburger", "ice", "juice",
                "ketchup", "kitchen", "lard", "liquor", "margarine", "marinade", "mayo",
                "mayonnaise", "meat", "milk", "mousse", "muffin", "mushroom", "noodle", "nut",
                "oil", "olive", "omelette", "pan", "pasta", "paste", "pastry", "pie", "pizza",
                "plate", "pot", "poutine", "pudding", "raclette", "recipe", "rice", "salad",
                "salsa", "sandwich", "sauce", "seasoning", "skillet", "soda", "soup", "soy",
                "spice", "steak", "stew", "syrup", "tartar", "taste", "tea", "toast", "vinegar",
                "waffle", "water", "wheat", "wine", "wok", "yeast", "yogurt"};
        String[] tagList2 = new String[]{"aroma", "bagel"};
        tagView.setTagList(tagList);
        List<TagModel> selected = tagView.getSelectedTags();
        // to here
        Button recipegen = (Button) root.findViewById(R.id.generate_recipes);
        recipegen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startDash = new Intent(getActivity(), DashboardFragment.class);
                requestData(BASE_URL);
                startActivity(startDash);
            }
        });

        return root;
    }
    public void requestData(String url) {
        Unirest.get(https://api.spoonacular.com/recipes/findByIngredients?apiKey=dfe9b7f8ec604ff4a8542d687cb49953&includeNutrition=true&ingredients=apples,+flour,+sugar&number=2);
        /*
        AsyncHttpClient client = new AsyncHttpClient();

        client.get(url, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers,
                                  JSONObject response) {
                // called when response HTTP status is "200 OK"
                Log.d("Bitcoin", "JSON: " + response.toString());
                try {
                } catch (Exception e) {
                    Log.e("Bitcoin", e.toString());
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable e,
                                  JSONObject response) {

                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                Toast.makeText(HomeFragment.onAttach(this), "Request Failed", Toast.LENGTH_SHORT).show();
            }
        });


         */
    }
}

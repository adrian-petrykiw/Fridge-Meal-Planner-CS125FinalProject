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
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.example.mealplannercs125.MainActivity;
import com.example.mealplannercs125.R;
import com.example.mealplannercs125.ui.dashboard.DashboardFragment;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;
import com.mashape.unirest.request.HttpRequest;
import com.skyhope.materialtagview.TagView;
import com.skyhope.materialtagview.enums.TagSeparator;
import com.skyhope.materialtagview.model.TagModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import javax.security.auth.callback.Callback;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

public class HomeFragment extends Fragment{
    private RequestQueue mRequestQueue;
    private String url = "http://www.mocky.io/v2/597c41390f0000d002f4dbd1";
    private HomeViewModel homeViewModel;
    private String BASE_URL = "https://api.spoonacular.com/recipes/findByIngredients?apiKey=dfe9b7f8ec604ff4a8542d687cb49953&includeNutrition=true&ingredients=apples,+flour,+sugar&number=1";
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
        // to test a smaller list
        String[] tagList2 = new String[]{"aroma", "bagel"};
        tagView.setTagList(tagList);
        List<TagModel> selected = tagView.getSelectedTags();
//        HttpRequest request = Unirest.get(BASE_URL);
//        System.out.print(request.toString());
        // to here
//        Button recipegen = (Button) root.findViewById(R.id.generate_recipes);
//        recipegen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String json = null;
//                try {
//                    json = outpu
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(json);
////                Intent startDash = new Intent(getActivity(), DashboardFragment.class);
//////                startActivity(startDash);
//////                DashboardFragment nextFrag= new DashboardFragment();
//////                getActivity().getSupportFragmentManager().beginTransaction()
//////                        .replace(R.id.text_home, nextFrag, "findThisFragment")
//////                        .addToBackStack(null)
//////                        .commit();
//            }
//        });

        return root;
    }



}

package com.example.mealplannercs125.ui.dashboard;

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
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.example.mealplannercs125.R;

import org.json.JSONException;
import org.json.JSONObject;


public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private String BASE_URL = "https://api.spoonacular.com/recipes/findByIngredients";
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        final TextView textView = root.findViewById(R.id.textView);
//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        Button button = (Button) root.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String json = null;
                try {
                    JSONObject jsonobject = outputapi();
                    JsonParser jsonParser = new JsonParser();
                    JsonObject gsonObject = (JsonObject)jsonParser.parse(jsonobject.toString());
                    json = gsonObject.get("title").getAsString();
                    System.out.println(json);
                    textView.setText(json);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                System.out.println(json);
//                Intent startDash = new Intent(getActivity(), DashboardFragment.class);
////                startActivity(startDash);
////                DashboardFragment nextFrag= new DashboardFragment();
////                getActivity().getSupportFragmentManager().beginTransaction()
////                        .replace(R.id.text_home, nextFrag, "findThisFragment")
////                        .addToBackStack(null)
////                        .commit();
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
    public JSONObject outputapi() throws JSONException {
        // json string
        String jsonStr = "{\"id\":534573,\"title\":\"Brown Butter Apple Crumble\",\"image\":\"https://spoonacular.com/recipeImages/534573-312x231.jpg\",\"imageType\":\"jpg\",\"usedIngredientCount\":1,\"missedIngredientCount\":2,\"missedIngredients\":[{\"id\":2010,\"amount\":0.5,\"unit\":\"tsp\",\"unitLong\":\"teaspoons\",\"unitShort\":\"tsp\",\"aisle\":\"Spices and Seasonings\",\"name\":\"cinnamon\",\"original\":\"1/2 tsp cinnamon\",\"originalString\":\"1/2 tsp cinnamon\",\"originalName\":\"cinnamon\",\"metaInformation\":[],\"meta\":[],\"image\":\"https://spoonacular.com/cdn/ingredients_100x100/cinnamon.jpg\"},{\"id\":8120,\"amount\":0.5,\"unit\":\"cup\",\"unitLong\":\"cups\",\"unitShort\":\"cup\",\"aisle\":\"Cereal\",\"name\":\"oats\",\"original\":\"1/2 cup uncooked oats (not instant)\",\"originalString\":\"1/2 cup uncooked oats (not instant)\",\"originalName\":\"uncooked oats (not instant)\",\"metaInformation\":[\"uncooked\",\"(not instant)\"],\"meta\":[\"uncooked\",\"(not instant)\"],\"image\":\"https://spoonacular.com/cdn/ingredients_100x100/rolled-oats.jpg\"}],\"usedIngredients\":[{\"id\":9003,\"amount\":4.0,\"unit\":\"\",\"unitLong\":\"\",\"unitShort\":\"\",\"aisle\":\"Produce\",\"name\":\"apples\",\"original\":\"4 apples, peeled, cored and sliced\",\"originalString\":\"4 apples, peeled, cored and sliced\",\"originalName\":\"apples, peeled, cored and sliced\",\"metaInformation\":[\"cored\",\"peeled\",\"sliced\"],\"meta\":[\"cored\",\"peeled\",\"sliced\"],\"image\":\"https://spoonacular.com/cdn/ingredients_100x100/apple.jpg\"}],\"unusedIngredients\":[],\"likes\":7}";
        // convert to json object
        JSONObject jsonstring = new JSONObject(jsonStr);
        return jsonstring;
    }

}

package com.example.mealplannercs125.ui.dashboard;

public class RecipeSelector extends DashboardFragment {
    private String recipe;
    public RecipeSelector(String recipe) {
        this.recipe = recipe;
    }

    public String getRecipe() {
        return recipe;
    }
    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
}

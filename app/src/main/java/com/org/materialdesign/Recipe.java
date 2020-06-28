package com.org.materialdesign;

public class Recipe {
    //Declare private member variables
    private final int recipeImage;
    private String recipeTitle;
    private  String recipeDescription;

    //Create  a Constructor for the recipe data model
//    parse the declared parameters

    Recipe(int recipeImage, String recipeTitle, String recipeDescription){
        this.recipeImage=recipeImage;
        this.recipeTitle=recipeTitle;
        this.recipeDescription=recipeDescription;
    }
    //Create getters and return the specific object
    public int getRecipeImage(){
        return recipeImage;
    }

    public String getRecipeTitle() {
        return recipeTitle;
    }

    public String getRecipeDescription() {
        return recipeDescription;
    }
}

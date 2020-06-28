package com.org.materialdesign;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PastryAdapter extends RecyclerView.Adapter<PastryAdapter.ViewHolder> {
    private ArrayList<Recipe> recipeData;
    private Context myContext;

    PastryAdapter(ArrayList<Recipe>mRecipeData,Context context){
        this.myContext=context;
        this.recipeData=mRecipeData;
    }
    @Override
    //create ViewHolder objects
    public PastryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PastryAdapter.ViewHolder(LayoutInflater.from(myContext).inflate(R.layout.pastry_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PastryAdapter.ViewHolder holder, int position) {
        Recipe currentRecipe=recipeData.get(position);
        holder.bindTo(currentRecipe);
    }

    @Override
    public int getItemCount() {
        return recipeData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView myRecipeImage;
        private TextView myRecipeTitle;
        private TextView myRecipeDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myRecipeImage=itemView.findViewById(R.id.pastry_image);
            myRecipeTitle=itemView.findViewById(R.id.pastry_image);
            myRecipeDescription=itemView.findViewById(R.id.pastry_image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int dessertPosition=getAdapterPosition();
                    Recipe currentDessert=recipeData.get(dessertPosition);
                    if (dessertPosition==0){
                        Intent donutIntent=new Intent(myContext,DonutActivity.class);
                        donutIntent.putExtra("dTitle",currentDessert.getRecipeTitle());
                        donutIntent.putExtra("dImage",currentDessert.getRecipeImage());
                        donutIntent.putExtra("dDescription",currentDessert.getRecipeDescription());
                        myContext.startActivity(donutIntent);
                    }else {
                        Toast.makeText(myContext,"Create an Activity for the dessert",Toast.LENGTH_SHORT);
                    }
                }
            });
        }

        public void bindTo(Recipe currentRecipe) {
            Glide.with(myContext).load(currentRecipe.getRecipeImage()).into(myRecipeImage);
            myRecipeTitle.setText(currentRecipe.getRecipeTitle());
            myRecipeDescription.setText(currentRecipe.getRecipeDescription());
        }
    }
}

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

public class StoresAdapter extends RecyclerView.Adapter<StoresAdapter.ViewHolder> {
    private ArrayList<Stores>storeData;
    private Context storeContext;

    StoresAdapter(ArrayList<Stores>myStoreData,Context context){
        this.storeContext=context;
        this.storeData=myStoreData;
    }

    //Ctreating ViewHolder Objects

    @NonNull
    @Override
    public StoresAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(storeContext).inflate(R.layout.store_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StoresAdapter.ViewHolder holder, int position) {
        Stores currentStores=storeData.get(position);
        holder.bindTo(currentStores);
    }

    @Override
    public int getItemCount() {
        return storeData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView storeImage;
        private TextView storeTitle;
        private TextView storeDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            storeImage=itemView.findViewById(R.id.store_image);
            storeTitle=itemView.findViewById(R.id.store_title);
            storeDescription=itemView.findViewById(R.id.store_description);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int storePosition=getAdapterPosition();
                    Stores currentStore=storeData.get(storePosition);
                    if (storePosition==0){
                        Intent storeIntent=new Intent(storeContext, Pizza.class);
                        storeIntent.putExtra("sTitle",currentStore.getStoreTitle());
                        storeIntent.putExtra("sImage",currentStore.getStoreImage());
                        storeIntent.putExtra("sDescription",currentStore.getStoreDescription());
                        storeContext.startActivity(storeIntent);
                    }else {
                        Toast.makeText(storeContext,"Create an Activity for the Store",Toast.LENGTH_SHORT);
                    }
                }
            });
        }

        public void bindTo(Stores currentStore) {
            Glide.with(storeContext).load(currentStore.getStoreImage()).into(storeImage);
            storeTitle.setText(currentStore.getStoreTitle());
            storeDescription.setText(currentStore.getStoreDescription());
        }
    }
}

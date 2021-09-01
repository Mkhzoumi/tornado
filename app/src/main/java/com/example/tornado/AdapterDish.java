package com.example.tornado;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

// this is the adapter class which we use to put the fragment inside the recycle view.
// it must extend the RecycleView Adapter and there are three methods which must be override.
public class AdapterDish extends RecyclerView.Adapter<AdapterDish.DishViewHolder>{
    List<DishClass> allDishes = new ArrayList<>();

    public AdapterDish(List<DishClass> allDishes) {
        this.allDishes = allDishes;
    }


    public static class DishViewHolder extends RecyclerView.ViewHolder{
        public DishClass dish;
        View itemView;

        public DishViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;

            // here we make an on click listener on the views in recycle view and send the data using the intent to the dish details page
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent toDetailsPage = new Intent(v.getContext(),DishDetailsPage.class);
                    toDetailsPage.putExtra("name",dish.dishName);
                    toDetailsPage.putExtra("price",dish.price);
                    toDetailsPage.putExtra("ingredients",dish.ingredients);
                    v.getContext().startActivity(toDetailsPage);

                }
            });
        }


    }





    @NonNull
    @Override
    public DishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // here we create the view holder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_dish,parent,false);
        DishViewHolder dishViewHolder = new DishViewHolder(view);
        return dishViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDish.DishViewHolder holder, int position) {
        holder.dish = allDishes.get(position);
        TextView dishName = holder.itemView.findViewById(R.id.dishNameFragment);
        TextView dishPrice = holder.itemView.findViewById(R.id.dishPriceFragment);

        dishName.setText("Dish Name: "+holder.dish.dishName);
        dishPrice.setText("Price: "+holder.dish.price+"$");

    }

    @Override
    public int getItemCount() {
        return allDishes.size();
    }

}

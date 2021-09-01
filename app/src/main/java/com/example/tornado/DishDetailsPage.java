package com.example.tornado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

// this the dish detail activity class , it get its data from the intent .
public class DishDetailsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dish_details_page);

        Intent intent = getIntent();

        TextView dishNameField = findViewById(R.id.dishDetailsDishNameField);
        TextView dishPriceField = findViewById(R.id.dishDetailsPagedishPriceField);
        TextView dishIngredientsField = findViewById(R.id.dishDetailsPageDishIngredientsField);


        dishNameField.setText(intent.getExtras().getString("name"));
        dishPriceField.setText(intent.getExtras().getString("price"));
        dishIngredientsField.setText(intent.getExtras().getString("ingredients"));

    }
}
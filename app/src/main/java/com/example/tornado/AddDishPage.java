package com.example.tornado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class AddDishPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dish_page);


        // here we get the button to make an on click listener to it
        Button addingDishPageSubmitButton = findViewById(R.id.addingDishPageSubmitButton);
        addingDishPageSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Submitted!", Toast.LENGTH_LONG).show();

                // here we make an object of the data base class and the Dao interface to use them to insert data to the database.

                AppDatabase db =  Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "restaurant").allowMainThreadQueries()
                        .build();
                DishDao dishDao = db.dishDao();

                // here we get what the user entered to make a new object of type Dish to insert it in database.
                EditText dishName = findViewById(R.id.dishNameField);
                EditText price = findViewById(R.id.dishPriceField);
                EditText ingredients = findViewById(R.id.dishIngredientsField);

                DishClass dish = new DishClass(dishName.getText().toString(),price.getText().toString(),ingredients.getText().toString());

                // here we insert the object dish in the database
                dishDao.insertOne(dish);

            }
        });






    }
}
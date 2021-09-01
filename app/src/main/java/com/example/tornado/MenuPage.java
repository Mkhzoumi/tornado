package com.example.tornado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Insert;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

// this activity class has a button which navigate you to the Main activity, and it has the recycle view displayed in it
public class MenuPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);


        Button menuPageHomeButton = findViewById(R.id.menuPageHomeButton);
        menuPageHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toMainActivityPage = new Intent(MenuPage.this , MainActivity.class);
                startActivity(toMainActivityPage);
            }
        });




        // here we made an object of class AppDatabase and of interface Dao to use them to get the data from database.
        AppDatabase db =  Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "restaurant").allowMainThreadQueries().build();
        DishDao dishDao = db.dishDao();

        // this line is getting the list of objects Dish from the database
        List<DishClass> dbDishes = dishDao.getAll();

        RecyclerView allDishesRecyclerView = findViewById(R.id.menuRecycleView);
        allDishesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        // here we passed the list of objects we got from database to the recycle view to be displayed
        allDishesRecyclerView.setAdapter(new AdapterDish(dbDishes));

    }
}
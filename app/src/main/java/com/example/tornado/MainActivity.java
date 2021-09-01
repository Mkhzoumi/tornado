package com.example.tornado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// this is the main activity class , nothing is fancy here, there are two buttons to navigate the user to other activities.
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mainAddDishButton = findViewById(R.id.mainAddingDishButton);
        Button mainMenuButton = findViewById(R.id.mainMenuButton);



        mainAddDishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toAddDishPage = new Intent(MainActivity.this , AddDishPage.class);
                startActivity(toAddDishPage);
            }
        });



        mainMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toMenuPage = new Intent(MainActivity.this , MenuPage.class);
                startActivity(toMenuPage);
            }
        });

    }
}
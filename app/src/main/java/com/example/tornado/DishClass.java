package com.example.tornado;
import androidx.room.*;

// this is the Dish class which will be inserted to the database, its just a regular class with an @Entity notation.

@Entity(tableName = "dishes")
public class DishClass {
    @PrimaryKey(autoGenerate = true)
    public int id;

    String dishName;
    String price;
    String ingredients;


    public DishClass(String dishName, String price, String ingredients) {
        this.dishName = dishName;
        this.price = price;
        this.ingredients = ingredients;
    }
}

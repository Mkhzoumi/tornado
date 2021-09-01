package com.example.tornado;
import androidx.room.Database;
import androidx.room.RoomDatabase;


// this is the database class it must be abstract and it has a Dao method.
@Database(entities = {DishClass.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DishDao dishDao();
}


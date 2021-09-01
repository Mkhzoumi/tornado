package com.example.tornado;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;


// dao interface we use it to access and add data to the database
@Dao
public interface DishDao {
    @Query("SELECT * FROM dishes")
    List<DishClass> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertOne(DishClass... dish);


    @Delete
    void delete(DishClass dish);

}

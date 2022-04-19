package com.example.shoes.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.shoes.Model.Item;

import java.util.List;

@Dao
public interface ItemDao {
    @Insert
    void InsertAll(Item item);
    @Query("SELECT * FROM Item")
    LiveData<List<Item>> getAll();
    @Delete
    void DeleteItem(Item item);
    @Query("UPDATE Item SET Iquantity=:quantity WHERE uid=:id")
    void UpdateQuantity(int id,int quantity);
    @Query("UPDATE Item SET ItotalPrice=:price WHERE uid=:id")
    void UpdateTotalPrice(int id,double price);
    @Query("DELETE FROM Item")
    void DeleteAllItem();
}

package com.example.shoes.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.shoes.Dao.ItemDao;
import com.example.shoes.Model.Item;

@Database(entities = Item.class,version = 1)
public abstract class ItemDb extends RoomDatabase {
    public abstract ItemDao itemDao();
    public static ItemDb db;
    public static synchronized ItemDb getInstance(Context context){
        if (db==null){
            db= Room.databaseBuilder(context,ItemDb.class,"DB")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return db;
    }
}

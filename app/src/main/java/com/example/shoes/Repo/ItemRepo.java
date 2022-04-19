package com.example.shoes.Repo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.shoes.Dao.ItemDao;
import com.example.shoes.Database.ItemDb;
import com.example.shoes.Model.Item;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ItemRepo {
    public ItemDao itemDao;
    public LiveData<List<Item>> liveData;
   public Executor executor;

    public LiveData<List<Item>> getLiveData() {
        return liveData;
    }

    public ItemRepo(Application application) {
        itemDao= ItemDb.getInstance(application).itemDao();
        liveData=itemDao.getAll();
        executor= Executors.newSingleThreadExecutor();
    }
    public void InsertItem(Item item){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                itemDao.InsertAll(item);
            }
        });
    }
    public void GetAllData(Item item){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                itemDao.getAll();
            }
        });
    }
    public void UpdateQuantity(int id,int quantity){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                itemDao.UpdateQuantity(id, quantity);
            }
        });
    }
    public void UpdateTotalPrice(int id,double price){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                itemDao.UpdateTotalPrice(id, price);
            }
        });
    }
    public void DeleteAllItem(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                itemDao.DeleteAllItem();
            }
        });
    }
    public void DeleteItem(Item item){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                itemDao.DeleteItem(item);
            }
        });
    }
}

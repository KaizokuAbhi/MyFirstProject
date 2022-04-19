package com.example.shoes.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.shoes.Model.Item;
import com.example.shoes.Repo.ItemRepo;

import java.util.List;

public class ItemVm extends AndroidViewModel {
    ItemRepo itemRepo;
    public LiveData<List<Item>> GetItemData(){
        return itemRepo.getLiveData();
    }
    public ItemVm(@NonNull Application application) {
        super(application);
        itemRepo=new ItemRepo(application);
    }
    public void InsertItem(Item item){
        itemRepo.InsertItem(item);
    }
    public void UpdatePrice(int id,double price){
        itemRepo.UpdateTotalPrice(id, price);
    }
    public void UpdateQuantity(int id,int quantity){
        itemRepo.UpdateQuantity(id, quantity);
    }
    public void DeleteItem(Item item){
        itemRepo.DeleteItem(item);
    }
    public void DeleteAllItem(){
        itemRepo.DeleteAllItem();
    }
}

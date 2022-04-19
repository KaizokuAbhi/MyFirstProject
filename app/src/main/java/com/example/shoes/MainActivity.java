package com.example.shoes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.shoes.Adapter.ShoeAdapter;
import com.example.shoes.Model.Item;
import com.example.shoes.Model.product;
import com.example.shoes.ViewModel.ItemVm;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CardClickListener{
RecyclerView recyclerView;
Toolbar toolbar;
 List<product> shoeitemlist;
ShoeAdapter adapter;
ItemVm viewmodel;
List<Item> itemList;
CoordinatorLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rec);
        layout=findViewById(R.id.main);
        viewmodel=new ViewModelProvider(this).get(ItemVm.class);
        shoeitemlist=new ArrayList<>();
        adapter=new ShoeAdapter(shoeitemlist,this,this);
        setup();
        recyclerView.setAdapter(adapter);
        adapter.setShoelist(shoeitemlist);
    }
    private void setup() {
        ;shoeitemlist.add(new product
                ("Galaxy M33 5G","Samsung",R.drawable.one,1200.00));
        ;shoeitemlist.add(new product
                ("Galaxy F23 5G ","Samsung",R.drawable.two,1300.00));
        ;shoeitemlist.add(new product
                ("Redmi Note 11T 5G","Xiomi",R.drawable.three,1500.00));
        ;shoeitemlist.add(new product
                ("M4 Pro 5G (6GB RAM + 128GB)","Poco",R.drawable.four,1700.00));
        ;shoeitemlist.add(new product
                ("9 Pro 5G","Redmi",R.drawable.five,1300.50));
        ;shoeitemlist.add(new product
                ("Galaxy F23 5G","Samsung",R.drawable.six,1200.00));
        ;shoeitemlist.add(new product
                ("Rog M33 5G","Asus",R.drawable.seven,1600.00));
        ;shoeitemlist.add(new product
                ("Galaxy M33 5G","Samsung",R.drawable.one,1200.00));
    }

    @Override
    public void itemOnclick(product product) {
        startActivity(new Intent(getApplicationContext(),DetailedActivity.class).putExtra("shoeItem",product));
    }

    @Override
    public void cartclick(product product) {
     Snackbar snackbar=Snackbar.make(layout,"Item Added to Cart",Snackbar.LENGTH_LONG);
     snackbar.show();
    }
}
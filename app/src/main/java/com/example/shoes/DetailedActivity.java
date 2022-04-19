package com.example.shoes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.shoes.Model.product;

public class DetailedActivity extends AppCompatActivity {
    TextView name,price,details;
    ImageView imageView;
    Button addtocart;
    product getProduct;

    com.example.shoes.Model.product product;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        name = findViewById(R.id.detailedName);
        price = findViewById(R.id.detailedPrice);
        imageView=findViewById(R.id.detailedImage);
        addtocart=findViewById(R.id.gotocart);
        getProduct=getIntent().getParcelableExtra("shoeItem");
        setData();
    }

    private void setData() {
        name.setText(getProduct.getPname());
        price.setText(String.valueOf(getProduct.getPprice()));
        Glide.with(this)
                .load(getProduct.getPimage())
                .into(imageView);
    }
}
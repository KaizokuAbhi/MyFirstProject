package com.example.shoes.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.shoes.CardClickListener;
import com.example.shoes.Model.product;
import com.example.shoes.R;

import java.util.ArrayList;
import java.util.List;

public class ShoeAdapter extends RecyclerView.Adapter<ShoeAdapter.ShoeViewHolder> implements CardClickListener {
    List<product> shoelist=new ArrayList<>();
    Context context;
    CardClickListener listener;

    public void setShoelist(List<product> shoelist) {
        this.shoelist = shoelist;
    }

    public ShoeAdapter(List<product> shoelist, Context context, CardClickListener listener) {
        this.shoelist = shoelist;
        this.context = context;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ShoeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.shoe_item,parent,false);
        return new ShoeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShoeViewHolder holder, int position) {
        product product=shoelist.get(position);
        holder.name.setText(product.getPname());
        holder.brand.setText(product.getPbrand());
        holder.price.setText(String.valueOf(product.getPprice()));
        Glide.with(context)
                .load(product.getPimage())
                .into(holder.headimage);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.itemOnclick(product);
            }
        });
        holder.cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return shoelist.size();
    }

    @Override
    public void itemOnclick(product product) {
        Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void cartclick(product product) {
        Toast.makeText(context, "Cart", Toast.LENGTH_SHORT).show();
    }

    static class ShoeViewHolder extends RecyclerView.ViewHolder {
            final CardView cardView;
            final TextView name;
            final TextView brand;
            final TextView price;
            ImageView cart,headimage;
            public ShoeViewHolder(@NonNull View itemView) {
                super(itemView);
                cardView = itemView.findViewById(R.id.cardview);
                name = itemView.findViewById(R.id.name);
                brand = itemView.findViewById(R.id.brand);
                price = itemView.findViewById(R.id.price);
                headimage=itemView.findViewById(R.id.headImage);
                cart=itemView.findViewById(R.id.img);
            }
        }
    }

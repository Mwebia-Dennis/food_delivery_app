package com.penguinstech.fooddeliveryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RestaurantAdapter  extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder>{

    private final ArrayList<Restaurant> restaurantList;
    private final Context context;

    public RestaurantAdapter (Context context, ArrayList<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View myView = LayoutInflater.from(context).inflate(R.layout.restaurant_item, parent, false);
        return new ViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Restaurant restaurant = restaurantList.get(position);
        holder.imageView.setImageResource(restaurant.getImage());
        holder.nameTv.setText(restaurant.getName());
        holder.timeTv.setText(restaurant.getOpenAndCloseTime());
        holder.locationTv.setText(restaurant.getLocation());
        holder.ratingTv.setText(restaurant.getRating());
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTv, locationTv, ratingTv, timeTv;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.restaurantImage);
            nameTv = itemView.findViewById(R.id.restaurantName);
            locationTv = itemView.findViewById(R.id.locationTv);
            timeTv = itemView.findViewById(R.id.timeTv);
            ratingTv = itemView.findViewById(R.id.rating);
        }
    }
}

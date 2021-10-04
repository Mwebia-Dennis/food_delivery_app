package com.penguinstech.fooddeliveryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodAdapter extends BaseAdapter {


    Context context;
    ArrayList<Food> listOfFoods;
    public FoodAdapter(Context context, ArrayList<Food> listOfFoods) {
        this.context = context;
        this.listOfFoods = listOfFoods;
    }
    @Override
    public int getCount() {
        return listOfFoods.size();
    }

    @Override
    public Object getItem(int position) {
        return listOfFoods.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.food_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        //set data
        Food food = listOfFoods.get(position);
        holder.foodImageView.setImageResource(food.getImage());
        holder.foodImageView.setContentDescription(food.getName());
        holder.nameTv.setText(food.getName());
        holder.priceTv.setText(food.getPrice());
        holder.ratingTv.setText(food.getRating());
        holder.deliveryTimeTv.setText(food.getDeliveryTime());
        holder.restaurantNameView.setText(food.getRestaurantName());

        if(food.isDelivered()) {

            holder.deliveryStatusTv.setText(R.string.delivered);
            holder.deliveryStatusTv.setBackgroundResource(R.drawable.complete_deliveries_bg);
            holder.deliveryStatusTv.setTextColor(context.getResources().getColor(R.color.black));
//            holder.orderBtn.setVisibility(View.VISIBLE);
        }else {

            holder.deliveryStatusTv.setText(R.string.active);
            holder.deliveryStatusTv.setBackgroundResource(R.drawable.active_delivery_bg);
            holder.deliveryStatusTv.setTextColor(context.getResources().getColor(R.color.white));
//            holder.orderBtn.setVisibility(View.GONE);
        }

        return convertView;
    }

    public static class ViewHolder {

        ImageView foodImageView;
        TextView nameTv, priceTv, ratingTv, deliveryStatusTv, deliveryTimeTv, restaurantNameView;
//        Button orderBtn;
        public ViewHolder(View view) {
            foodImageView = view.findViewById(R.id.foodImageView);
            nameTv = view.findViewById(R.id.foodNameView);
            priceTv = view.findViewById(R.id.priceView);
            ratingTv = view.findViewById(R.id.ratingView);
            deliveryStatusTv = view.findViewById(R.id.deliveryStatusTv);
            deliveryTimeTv = view.findViewById(R.id.deliveryTime);
//            orderBtn = view.findViewById(R.id.orderBtnView);
            restaurantNameView = view.findViewById(R.id.restaurantNameView);
        }
    }
}

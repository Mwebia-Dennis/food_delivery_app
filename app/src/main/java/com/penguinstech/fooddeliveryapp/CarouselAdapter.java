package com.penguinstech.fooddeliveryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.ViewHolder> {

    private final ArrayList<Carousel> carouselList;
    private final Context context;

    public CarouselAdapter (Context context, ArrayList<Carousel> carouselList) {
        this.carouselList = carouselList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View myView = LayoutInflater.from(context).inflate(R.layout.carousel_item, parent, false);
        return new ViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Carousel carouselInfo = carouselList.get(position);
        holder.nameTv.setText(carouselInfo.getName());
        holder.infoBtn.setText(carouselInfo.getInfo());
        holder.carouselRv.setBackgroundResource(carouselInfo.getImageURL());
    }

    @Override
    public int getItemCount() {
        return carouselList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTv, infoBtn;
        RelativeLayout carouselRv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.nameTv);
            infoBtn = itemView.findViewById(R.id.carouseBtn);
            carouselRv = itemView.findViewById(R.id.carouselRv);
        }
    }
}

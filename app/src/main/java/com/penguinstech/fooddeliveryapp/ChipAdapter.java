package com.penguinstech.fooddeliveryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChipAdapter extends RecyclerView.Adapter<ChipAdapter.ViewHolder> {

    private final ArrayList<ChipInfo> chipList;
    private final Context context;
    public ChipAdapter(Context context, ArrayList<ChipInfo> chipList) {
        this.chipList = chipList;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.chip_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ChipInfo chipInfo = chipList.get(position);
        holder.btn.setImageResource(chipInfo.getIcon());
        holder.btn.setContentDescription(chipInfo.getText());
        holder.textView.setText(chipInfo.getText());
    }

    @Override
    public int getItemCount() {
        return chipList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageButton btn;
        private final TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.btn = itemView.findViewById(R.id.category_icon);
            this.textView = itemView.findViewById(R.id.category_text);
        }
    }
}

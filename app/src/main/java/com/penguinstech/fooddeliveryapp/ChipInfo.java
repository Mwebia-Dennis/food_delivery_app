package com.penguinstech.fooddeliveryapp;

import android.graphics.drawable.Drawable;

public class ChipInfo {

    private final int icon;
    private final String text;

    public ChipInfo(int icon, String text) {
        this.icon = icon;
        this.text = text;
    }

    public int getIcon() {
        return icon;
    }

    public String getText() {
        return text;
    }
}

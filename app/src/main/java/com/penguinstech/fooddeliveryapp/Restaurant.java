package com.penguinstech.fooddeliveryapp;

public class Restaurant {

    private final String name, openAndCloseTime, rating, location;
    private final int image;

    public Restaurant(int image, String name,String openAndCloseTime,String rating, String location) {
        this.image = image;
        this.name = name;
        this.openAndCloseTime = openAndCloseTime;
        this.rating = rating;
        this.location = location;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getOpenAndCloseTime() {
        return openAndCloseTime;
    }

    public String getRating() {
        return rating;
    }
}

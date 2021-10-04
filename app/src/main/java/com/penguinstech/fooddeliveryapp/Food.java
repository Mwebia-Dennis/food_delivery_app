package com.penguinstech.fooddeliveryapp;

public class Food {

    private final int image;
    private final String name, price, rating, deliveryTime, restaurantName;
    private final boolean isDelivered;

    public Food (int image, String name,String price,String rating, boolean isDelivered, String deliveryTime, String restaurantName) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.isDelivered = isDelivered;
        this.deliveryTime = deliveryTime;
        this.restaurantName = restaurantName;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getRating() {
        return rating;
    }

    public String getPrice() {
        return price;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public String getRestaurantName() {
        return restaurantName;
    }
}

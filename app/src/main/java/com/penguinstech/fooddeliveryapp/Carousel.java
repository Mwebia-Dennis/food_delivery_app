package com.penguinstech.fooddeliveryapp;

public class Carousel {
    private final int imageURL;
    private final String  name, info;

    public Carousel(int imageURL, String name, String info) {
        this.imageURL = imageURL;
        this.name = name;
        this.info = info;
    }

    public int getImageURL() {
        return imageURL;
    }

    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }
}

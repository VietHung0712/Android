package com.example.bai2_2307;

import android.media.Image;

public class Item {
    public Item(String name, int image, String price, String id) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.id = id;
    }
    String id;
    String name;
    int image;
    String price;

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public String getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }
}

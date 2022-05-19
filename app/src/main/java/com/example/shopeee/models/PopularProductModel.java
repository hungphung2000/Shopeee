package com.example.shopeee.models;

import java.io.Serializable;

public class PopularProductModel implements Serializable {
    private String img_url;
    private String desription;
    private String name;
    private String rating;
    private int price;

    public PopularProductModel() {
    }

    public PopularProductModel(String desription, String img_url, String name, int price, String rating) {
        this.img_url = img_url;
        this.desription = desription;
        this.name = name;
        this.rating = rating;
        this.price = price;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

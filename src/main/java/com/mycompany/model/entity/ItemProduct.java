/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.entity;

/**
 *
 * @author duyan
 */
public class ItemProduct {

    public ItemProduct(int product_id, String title, float Rating, String minPrice,String urlImg, int views) {
        this.product_id = product_id;
        this.title = title;
        this.minPrice = minPrice;
        this.Rating = Rating;
        this.urlImg = urlImg;
        this.views = views;
    }

    public int getProduct_id() {
        return product_id;
    }

    public String getTitle() {
        return title;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public float getRating() {
        return Rating;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public int getViews() {
        return views;
    }
    private int product_id;
    private String title;
    private String minPrice;
    private float Rating;
    private String urlImg;
    private int views;
   
    
}

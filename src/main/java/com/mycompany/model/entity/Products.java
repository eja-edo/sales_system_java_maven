package com.mycompany.model.entity;

import java.util.Date;
import java.util.List;

public class Products {

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public List<String> getListImg() {
        return ListImg;
    }

    public void setListImg(List<String> ListImg) {
        this.ListImg = ListImg;
    }

    public Products() {
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Products(int productId, String title, String description, double averageRating, List<String> ListImg, double minPrice, int views) {
        this.productId = productId;
        this.title = title;
        this.description = description;
        this.averageRating = averageRating;
        this.ListImg = ListImg;
        this.minPrice = minPrice;
        this.views = views;
    }


    private int productId;                     
    private String title;          
    private String description;            
    private double averageRating;  
    private List<String> ListImg;
    private double minPrice;
    private int views;
    
    
    
}

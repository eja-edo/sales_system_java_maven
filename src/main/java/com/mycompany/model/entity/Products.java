package com.mycompany.model.entity;

import java.util.Date;

public class Products {
    private int productId;          
    private int sellerId;           
    private String title;          
    private String description;     
    private int categoryId;        
    private double averageRating;  
    private Date createdAt;         
    private Date updatedAt;        
    
    
    public Products(int productId, int sellerId, String title, String description, int categoryId, double averageRating,
                    Date createdAt, Date updatedAt) {
        this.productId = productId;
        this.sellerId = sellerId;
        this.title = title;
        this.description = description;
        this.categoryId = categoryId;
        this.averageRating = averageRating;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    
    public Products() {
        this.createdAt = new Date(); 
        this.updatedAt = new Date(); 
    }

    
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

  
}

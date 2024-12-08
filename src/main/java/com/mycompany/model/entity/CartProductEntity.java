package com.mycompany.model.entity;

public class CartProductEntity {
    private int productId;
    private String title;
    private double price;
    private String imageUrl;
    private int size;

    public CartProductEntity(int productId, String title, double price, String imageUrl, int size) {
        this.productId = productId;
        this.title = title;
        this.price = price;
        this.imageUrl = imageUrl;
        this.size = size;
    }

    // Các phương thức getter và setter
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

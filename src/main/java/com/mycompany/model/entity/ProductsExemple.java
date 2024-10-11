package com.mycompany.model.entity;
public class ProductsExemple {
    private int productId;        
    private int exempleId;      
    private String title;         
    private double price;        
    private int stockQuantity;    
    private int typeId;          

 
    public ProductsExemple(int productId, int exempleId, String title, double price, int stockQuantity, int typeId) {
        this.productId = productId;
        this.exempleId = exempleId;
        this.title = title;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.typeId = typeId;
    }


    public ProductsExemple() {}


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getExempleId() {
        return exempleId;
    }

    public void setExempleId(int exempleId) {
        this.exempleId = exempleId;
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

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

  
}

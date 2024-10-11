/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.entity;

public class ProductImages {
    private int id;             
    private int productId;      
    private String imageURL;   

   
    public ProductImages(int id, int productId, String imageURL) {
        this.id = id;
        this.productId = productId;
        this.imageURL = imageURL;
    }

  
    public ProductImages() {}

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    
}

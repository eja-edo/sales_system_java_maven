/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.entity;

public class Favorites {
    private int favoriteId;         
    private int userId;             
    private int productId;         

 
    public Favorites(int favoriteId, int userId, int productId) {
        this.favoriteId = favoriteId;
        this.userId = userId;
        this.productId = productId;
    }

  
    public Favorites() {}

  
    public int getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(int favoriteId) {
        this.favoriteId = favoriteId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

  
}

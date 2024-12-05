package com.mycompany.model.entity;

import com.mycompany.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the data model for ItemProduct.
 */
public class ItemProductEntity {

    private final int product_id;
    private final String title;
    private final float rating;
    private final String minPrice;
    private final String urlImg;
    private final int views;

    public ItemProductEntity(int product_id, String title, float rating, String minPrice, String urlImg, int views) {
        this.product_id = product_id;
        this.title = title;
        this.rating = rating;
        this.minPrice = minPrice;
        this.urlImg = urlImg;
        this.views = views;
    }

    public int getProductId() {
        return product_id;
    }

    public String getTitle() {
        return title;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public float getRating() {
        return rating;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public int getViews() {
        return views;
    }

    
}

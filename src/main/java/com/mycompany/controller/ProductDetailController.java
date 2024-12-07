/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import static com.mycompany.model.dao.detailProductDAO.getDetailProduct;
import com.mycompany.model.entity.Products;
import com.mycompany.tab.detailProduct;
import static com.mycompany.utils.Formatter.formatPrice;
import static com.mycompany.utils.Formatter.formatViews;


/**
 *
 * @author duyan
 */
public class ProductDetailController {

    public ProductDetailController(Products model, detailProduct view) {
        this.model = model;
        this.view = view;
    }
    private Products model;
    private detailProduct view;
    
    public void insertData(int id)
    {
        model = getDetailProduct(id);
        view.setLabID(String.valueOf(model.getProductId()));
        view.setLabPrice(formatPrice(model.getMinPrice()));
        view.setListImgProduct(model.getListImg());
        view.setLabViews(formatViews(model.getViews()));
        view.setLabTitle(model.getTitle());
        view.setLabRating(String.valueOf(model.getAverageRating()));
        view.setProductSizesToComboBox(model.getSize());
    }
    
}

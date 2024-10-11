/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.entity;

public class Coupons {
    private int couponId;          
    private String code;            
    private double discount;       
    private java.sql.Date expiryDate; 
    private double minOrderAmount; 

   
    public Coupons(int couponId, String code, double discount, java.sql.Date expiryDate, double minOrderAmount) {
        this.couponId = couponId;
        this.code = code;
        this.discount = discount;
        this.expiryDate = expiryDate;
        this.minOrderAmount = minOrderAmount;
    }

 
    public Coupons() {}

  
    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public java.sql.Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(java.sql.Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public double getMinOrderAmount() {
        return minOrderAmount;
    }

    public void setMinOrderAmount(double minOrderAmount) {
        this.minOrderAmount = minOrderAmount;
    }

  
}

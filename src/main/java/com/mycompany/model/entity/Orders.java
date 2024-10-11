/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.entity;

import java.sql.Date;

public class Orders {
    private int orderId;          
    private int userId;           
    private String orderStatus;    
    private double totalPrice;     
    private int addressId;       
    private int couponId;          
    private Date createdAt;        

 
    public Orders(int orderId, int userId, String orderStatus, double totalPrice, int addressId, int couponId, Date createdAt) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderStatus = orderStatus;
        this.totalPrice = totalPrice;
        this.addressId = addressId;
        this.couponId = couponId;
        this.createdAt = createdAt;
    }

  
    public Orders() {}


    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getCouponId() {
        return couponId;
    }

    public void setCouponId(int couponId) {
        this.couponId = couponId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

   
}

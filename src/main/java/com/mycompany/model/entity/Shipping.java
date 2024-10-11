/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.entity;

import java.util.Date;

public class Shipping {
    private int shippingId;         
    private int orderId;             
    private String trackingNumber;   
    private String shippingStatus;  
    private Date shippingDate;      
    
    
    public Shipping(int shippingId, int orderId, String trackingNumber, String shippingStatus, Date shippingDate) {
        this.shippingId = shippingId;
        this.orderId = orderId;
        this.trackingNumber = trackingNumber;
        this.shippingStatus = shippingStatus;
        this.shippingDate = shippingDate;
    }

  
    public Shipping() {}

 
    public int getShippingId() {
        return shippingId;
    }

    public void setShippingId(int shippingId) {
        this.shippingId = shippingId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(String shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public Date getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(Date shippingDate) {
        this.shippingDate = shippingDate;
    }


}

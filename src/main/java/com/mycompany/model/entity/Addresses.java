
package com.mycompany.model.entity;

public class Addresses {
    private int addressId;       
    private int userId;          
    private String fullName;    
    private String phone;        
    private String addressLine;  
    private String city;        
    private String province;    
    private String postalCode;   
  
    
    public Addresses(int addressId, int userId, String fullName, String phone, String addressLine, String city, String province, String postalCode) {
        this.addressId = addressId;
        this.userId = userId;
        this.fullName = fullName;
        this.phone = phone;
        this.addressLine = addressLine;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
    }

    
    public Addresses() {}

    
    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

   
    
}

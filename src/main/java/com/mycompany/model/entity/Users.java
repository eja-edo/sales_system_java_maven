
package com.mycompany.model.entity;

import java.util.Date;


public class Users {
    private int userId;           
    private String username;      
    private String firstName;    
    private String lastName;      
    private String email;         
    private String password;      
    private String phone;         
    private String addressLine;   
    private String city;          
    private String province;      
    private String role;          
    private String userStatus;    
    private Date lastActive;      
    private Date createdAt;      
    private Date updatedAt;     

 
    public Users(int userId, String username, String firstName, String lastName, String email, String password,
                 String phone, String addressLine, String city, String province, String role, String userStatus,
                 Date lastActive, Date createdAt, Date updatedAt) {
        this.userId = userId;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.addressLine = addressLine;
        this.city = city;
        this.province = province;
        this.role = role;
        this.userStatus = userStatus;
        this.lastActive = lastActive;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public Users() {
        this.createdAt = new Date(); 
        this.updatedAt = new Date(); 
    }

  
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public Date getLastActive() {
        return lastActive;
    }

    public void setLastActive(Date lastActive) {
        this.lastActive = lastActive;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

 
    }
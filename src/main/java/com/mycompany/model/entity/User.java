/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.entity;
import java.time.LocalDateTime;
/**
 *
 * @author duyan
 */
public class User {
    private int userId;
    private String username;
    private String firstName;
    private String LastName;
    private String email;
    private String phone;
    private String address;
    private String role;
    private LocalDateTime create_at;
    private LocalDateTime update_at;
    
    public User(int userId, String username, String firstName, String lastName, 
            String email, String phone, String address, String role, 
            LocalDateTime createAt, LocalDateTime updateAt) {
    this.userId = userId;
    this.username = username;
    this.firstName = firstName;
    this.LastName = lastName;
    this.email = email;
    this.phone = phone;
    this.address = address;
    this.role = role;
    this.create_at = createAt;
    this.update_at = updateAt;
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
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDateTime getCreate_at() {
        return create_at;
    }

    public void setCreate_at(LocalDateTime create_at) {
        this.create_at = create_at;
    }

    public LocalDateTime getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(LocalDateTime update_at) {
        this.update_at = update_at;
    }
}

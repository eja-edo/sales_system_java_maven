/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utils;

import com.mycompany.model.entity.Users;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duyan
 */
public class CurrentUser {
        private static Users user; // Biến static lưu thông tin user
        private static List<UserChangeListener> listeners = new ArrayList<>(); // Danh sách listener
    // Phương thức để set user
    public static void setUser(Users newUser) {
        user = newUser;
        notifyListeners();
    }

    // Phương thức để lấy thông tin user
    public static Users getUser() {
        return user;
    }
    
    
    
    // Xóa thông tin user (khi đăng xuất)
    public static void clearUser() {
        user = null;
    }
    
    // Phương thức để thêm listener
    public static void addListener(UserChangeListener listener) {
        listeners.add(listener);
    }
    
    private static void notifyListeners() {
        for (UserChangeListener listener : listeners) {
            listener.onUserChanged(user);
        }
    }
}

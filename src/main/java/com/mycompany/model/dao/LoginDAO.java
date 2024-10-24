/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.dao;

import com.mycompany.utils.DBConnection;
import com.mycompany.utils.PasswordUtil;
import static com.mycompany.utils.PasswordUtil.hashPassword;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author duyan
 */
public class LoginDAO {
    private String username;
    private String password;
    
    public LoginDAO(String user,String pass){
        this.username =  user;
        this.password = pass;
    }
    
public String login() {
    String query = "EXEC getPassword @login = ?";
    try (Connection conn = DBConnection.getConnection(); // Lấy kết nối từ pool
         PreparedStatement stmt = conn.prepareStatement(query)) {
         
        stmt.setString(1, username);
        try (ResultSet rs = stmt.executeQuery()) {
            // Kiểm tra xem có kết quả hay không
            if (rs.next()) {
                String retrievedPassword = rs.getString("password");
                // Kiểm tra mật khẩu
                if (PasswordUtil.checkPassword(password, retrievedPassword)) {
                    return "Đăng nhập thành công!";
                } else {
                    return "Mật khẩu không chính xác!";
                }
            } else {
                return "Tài khoản không tồn tại!";
            }
        }
    } catch (SQLException e) {
        // Ghi log lỗi và trả về thông điệp lỗi
        e.printStackTrace(); // Bạn có thể ghi log thay vì in ra
        return "Đã xảy ra lỗi khi kết nối đến cơ sở dữ liệu: " + e.getMessage();
    }
}



    private boolean isUsernameExists() {
        String query = "EXEC getPassword @login = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0; // Nếu có người dùng, trả về true
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Nếu không có lỗi, trả về false
    }

    // Phương thức đăng ký người dùng mới
    public boolean signUp() {
        
        // Kiểm tra xem tên người dùng đã tồn tại chưa
        if (isUsernameExists()) {
            return false; // Tên người dùng đã tồn tại
        }
        String insertQuery = "INSERT INTO Users (username, password) VALUES (?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(insertQuery)) {
             
            // Băm mật khẩu trước khi lưu (nếu cần)
            String hashedPassword = hashPassword(password); // Phương thức băm mật khẩu
            stmt.setString(1, username);
            stmt.setString(2, hashedPassword);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0; // Trả về true nếu có dòng được thêm vào
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Đăng ký không thành công
    }   
}

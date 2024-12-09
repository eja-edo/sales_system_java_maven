/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.dao;

import com.mycompany.model.entity.Users;
import com.mycompany.utils.CurrentUser;
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

//    public LoginDAO() {
//    }
//    private String username;
//    private String password;
//    
//    public LoginDAO(String user,String pass){
//        this.username =  user;
//        this.password = pass;
//    }

    public String login(String usn, String pass) {
        // Truy vấn lấy mật khẩu từ cơ sở dữ liệu
        String query = "EXEC getPassword @login = ?";

        try (Connection conn = DBConnection.getConnection(); // Lấy kết nối từ pool
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, usn); // Gán tham số @login
            try (ResultSet rs = stmt.executeQuery()) {
                // Kiểm tra xem có kết quả hay không
                if (rs.next()) {
                    String retrievedPassword = rs.getString("password");

                    // Kiểm tra mật khẩu
                    if (PasswordUtil.checkPassword(pass, retrievedPassword)) {

                        // Sau khi xác thực mật khẩu, truy vấn lấy thông tin người dùng
                        String query2 = "EXEC getUserInfo @login = ?, @password = ?";
                        try (PreparedStatement stmt2 = conn.prepareStatement(query2)) {
                            stmt2.setString(1, usn); // Gán giá trị cho tham số @login
                            stmt2.setString(2, retrievedPassword); // Gán giá trị cho tham số @password
                            try (ResultSet rs2 = stmt2.executeQuery()) {
                                // Kiểm tra xem có kết quả hay không
                                if (rs2.next()) {
                                    // Lấy thông tin người dùng từ ResultSet
                                    Users user = new Users();
                                    user.setUserId(rs2.getInt("user_id"));
                                    user.setUsername(rs2.getString("username"));
                                    user.setEmail(rs2.getString("email"));
                                    user.setPhone(rs2.getString("phone"));
                                    user.setFirstName(rs2.getString("first_name"));
                                    user.setLastName(rs2.getString("last_name"));
                                    user.setAddressLine(rs2.getString("address_line"));
                                    user.setCity(rs2.getString("city"));
                                    user.setProvince(rs2.getString("province"));

                                    // Thiết lập thông tin người dùng vào CurrentUser
                                    CurrentUser.setUser(user);

                                    // Đăng nhập thành công
                                    return "Đăng nhập thành công!";
                                } else {
                                    return "Tài khoản không tồn tại!";
                                }
                            }
                        } catch (SQLException e) {
                            // Ghi log lỗi và trả về thông điệp lỗi
                            e.printStackTrace();
                            return "Đã xảy ra lỗi khi lấy thông tin người dùng: " + e.getMessage();
                        }
                    } else {
                        return "Mật khẩu không chính xác!";
                    }
                } else {
                    return "Tài khoản không tồn tại!";
                }
            }
        } catch (SQLException e) {
            // Ghi log lỗi và trả về thông điệp lỗi
            e.printStackTrace();
            return "Đã xảy ra lỗi khi kết nối đến cơ sở dữ liệu: " + e.getMessage();
        }
    }


    private boolean isUsernameExists(String usn) {
        String query = "EXEC getPassword @login = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setString(1, usn);
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
    public Boolean signUp(String usn, String pass) {
        // Kiểm tra xem tên người dùng đã tồn tại chưa
        if (isUsernameExists(usn)) {
            return null; // Tên người dùng đã tồn tại
        }

        String insertQuery = "EXEC signUp @Email = ?, @password = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(insertQuery)) {

            // Băm mật khẩu trước khi lưu
            String hashedPassword = hashPassword(pass); // Phương thức băm mật khẩu
            stmt.setString(1, usn);
            stmt.setString(2, hashedPassword);

            // Thực thi thủ tục và lấy kết quả trả về (user_id và username)
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Lấy thông tin user_id và username từ kết quả
                    int userId = rs.getInt("user_id");
                    String username = rs.getString("username");
                    Users user = new Users();
                    user.setUsername(username);
                    user.setUserId(userId);
                    
                    CurrentUser.setUser(user);
                    // Tạo và trả về đối tượng User
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Đăng ký không thành công
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.component.Login;
import com.mycompany.model.dao.LoginDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

/**
 *
 * @author duyan
 */
public class LoginController {
    private Login view;
    private LoginDAO model;
    
    public LoginController(LoginDAO model, Login view) {
        this.model = model;
        this.view = view;
    }
        // Lớp nội bộ để xử lý sự kiện nút đăng nhập
    public class LoginButtonListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = view.getInpEmail();
                String password = view.getInpPass();

                
                // Kiểm tra tính hợp lệ của username và password
                if (username == null || username.trim().isEmpty()) {
                    view.setMessage("Vui lòng nhập tên đăng nhập.");
                    return;
                }

                if (password == null || password.trim().isEmpty()) {
                    view.setMessage("Vui lòng nhập mật khẩu.");
                    return;
                }

                if (password.length() < 6) {
                    view.setMessage("Mật khẩu phải có ít nhất 6 ký tự.");
                    return;
                }

                // Kiểm tra mật khẩu có ít nhất một chữ viết hoa và một ký tự đặc biệt
                if (!containsUpperCase(password)) {
                    view.setMessage("Mật khẩu phải chứa ít nhất một chữ viết hoa.");
                    return;
                }

                if (!containsSpecialCharacter(password)) {
                    view.setMessage("Mật khẩu phải chứa ít nhất một ký tự đặc biệt.");
                    return;
                }
                // Nếu kiểm tra hợp lệ, gọi phương thức login từ model
                String loginResult = model.login(username, password);
                view.setMessage(loginResult);
            }
            
                    // Phương thức kiểm tra chữ viết hoa trong mật khẩu
        private boolean containsUpperCase(String password) {
            return Pattern.compile("[A-Z]").matcher(password).find();
        }

        // Phương thức kiểm tra ký tự đặc biệt trong mật khẩu
        private boolean containsSpecialCharacter(String password) {
            return Pattern.compile("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]").matcher(password).find();
        }
        }
    }


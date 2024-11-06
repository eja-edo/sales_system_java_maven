/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.component.Login;
import com.mycompany.model.dao.LoginDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

                // Display login status message on the view
                view.setMessage(model.login(username, password));
            }
        }
    }


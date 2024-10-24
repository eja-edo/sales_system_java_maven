//
//import com.mycompany.model.dao.LoginDAO;
//import com.mycompany.utils.DBConnection;
//import com.mycompany.utils.PasswordUtil;
//import java.util.Scanner;
//
///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//
///**
// *
// * @author duyan
// */
//public class test {
// public static void main(String[] args) {
//        String[][] users = {
//            {"smarthomepro", "smarthomepro@example.com", "hashedpassword3"},
//            {"headphoneworld", "headphoneworld@example.com", "hashedpassword4"},
//            {"fitgear", "fitgear@example.com", "hashedpassword5"},
//            {"cameralover", "cameralover@example.com", "hashedpassword6"},
//            {"phonehub", "phonehub@example.com", "hashedpassword7"},
//            {"nextgenconsoles", "nextgenconsoles@example.com", "hashedpassword8"},
//            {"laptopshop", "laptopshop@example.com", "hashedpassword9"},
//            {"homegadget", "homegadget@example.com", "hashedpassword10"}
//        };
//        
//        for (String[] user : users) {
//            String username = user[0];
//            String email = user[1];
//            String password = user[2];
//
//            // Khởi tạo LoginDAO cho từng người dùng
//            LoginDAO newUser = new LoginDAO(username, password);
//            if (newUser.signUp()) {
//                System.out.println("Dang ki thanh cong: " + username);
//            } else {
//                System.out.println("Dang ki that bai: " + username);
//            }
//        }
//
//        // Đảm bảo đóng kết nối pool khi kết thúc
//        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            DBConnection.closeDataSource();
//        }));
//    }
//}
package com.mycompany.test;

import com.mycompany.component.ListImgProduct;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;

public class test {

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Image List Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        // Create an instance of ListImgProduct
        ListImgProduct listImgProduct = new ListImgProduct();
        
        // Create a button to add images
        JButton addButton = new JButton("Add Image");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open a file chooser to select an image
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png", "gif");
                fileChooser.setFileFilter(filter);
                
                int returnValue = fileChooser.showOpenDialog(frame);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    // Add the selected image path to the ListImgProduct
                    listImgProduct.addImage(selectedFile.getAbsolutePath());
                }
            }
        });

        // Add components to the frame
        frame.add(listImgProduct, BorderLayout.CENTER);
        frame.add(addButton, BorderLayout.SOUTH);

        // Set the frame visible
        frame.setVisible(true);
    }
}

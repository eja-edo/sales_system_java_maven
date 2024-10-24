package com.mycompany.test;

import java.io.InputStream;

public class ResourceChecker {

    public static void main(String[] args) {
        // Đường dẫn đến tệp cần kiểm tra trong thư mục resources
        String resourcePath = "/icon/traGop.png";

        // Sử dụng getResourceAsStream để kiểm tra xem file có tồn tại hay không
        InputStream inputStream = ResourceChecker.class.getResourceAsStream(resourcePath);

        if (inputStream != null) {
            System.out.println("Tep " + resourcePath + " da duoc tim thay.");
        } else {
            System.out.println("Tep " + resourcePath + " khong ton tai trong thu muc resources.");
        }
    }
}
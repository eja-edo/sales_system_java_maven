/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class Formatter {
    public static String formatPrice(double price) {
        // Sử dụng NumberFormat để định dạng giá trị theo kiểu tiền tệ Việt Nam
        NumberFormat formatter = NumberFormat.getInstance(Locale.forLanguageTag("vi-VN"));
        String formattedPrice = formatter.format(price);
        
        // Thêm ký tự "đ" vào cuối giá trị
        return formattedPrice + "đ";
    }
    public static String formatViews(int view){
        if (view >= 1_000_000) {
            // Nếu từ 1 triệu trở lên, hiển thị dạng "Xm+"
            return (view / 1_000_000) + "m+ đã xem";
        } else if (view >= 1_000) {
            // Nếu từ 1 nghìn đến dưới 1 triệu, hiển thị dạng "Xk+"
            return (view / 1_000) + "k+ đã xem";
        } else {
            // Nếu dưới 1 nghìn, giữ nguyên
            return view + " đã xem";
        }
    }
}

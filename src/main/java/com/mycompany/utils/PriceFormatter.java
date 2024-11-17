/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utils;

import java.text.NumberFormat;
import java.util.Locale;

public class PriceFormatter {
    public static String formatPrice(double price) {
        // Sử dụng NumberFormat để định dạng giá trị theo kiểu tiền tệ Việt Nam
        NumberFormat formatter = NumberFormat.getInstance(Locale.forLanguageTag("vi-VN"));
        String formattedPrice = formatter.format(price);
        
        // Thêm ký tự "đ" vào cuối giá trị
        return formattedPrice + "đ";
    }
}

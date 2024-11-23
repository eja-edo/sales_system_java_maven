/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.model.dao;

import com.mycompany.model.entity.Products;
import com.mycompany.utils.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duyan
 */
public class detailProductDAO {

    public static Products getdDetailProduct(int id) {
    String query1 = "exec ProductDetailsContent @ProductID = ?";
    String query2 = "exec productDetailImages @product = ?";

    Products product = null; // Khởi tạo đối tượng product

    try (Connection conn = DBConnection.getConnection(); 
         PreparedStatement stmt1 = conn.prepareStatement(query1)) {

        // Gán tham số và thực thi câu truy vấn đầu tiên
        stmt1.setInt(1, id);
        try (ResultSet rs = stmt1.executeQuery()) {
            if (rs.next()) {
                // Lấy dữ liệu từ ResultSet và gán vào đối tượng Products
                product = new Products();
                product.setProductId(rs.getInt("product_id"));
                product.setTitle(rs.getString("title"));
                product.setDescription(rs.getString("description"));
                product.setAverageRating(rs.getDouble("AverageRating"));
                product.setMinPrice(rs.getDouble("minPrice"));
                product.setViews(rs.getInt("views"));
                
            } else {
                return null; // Trả về null nếu không tìm thấy sản phẩm
            }
        }

        // Thực thi câu truy vấn thứ hai để lấy danh sách hình ảnh
        try (PreparedStatement stmt2 = conn.prepareStatement(query2)) {
            stmt2.setInt(1, id);
            try (ResultSet rs = stmt2.executeQuery()) {
                List<String> images = new ArrayList<>();
                while (rs.next()) {
                    System.out.println(rs.getString("ImageURL"));
                    images.add(rs.getString("ImageURL"));
                }
                product.setListImg(images); // Gán danh sách hình ảnh vào sản phẩm
            }
        }
    } catch (SQLException e) {
        // Ghi log lỗi và trả về null
        e.printStackTrace();
        return null;
    }
    return product; // Trả về đối tượng sản phẩm
}
  

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model.dao;

import com.mycompany.model.entity.ItemProduct;
import com.mycompany.utils.DBConnection;
import static com.mycompany.utils.PriceFormatter.formatPrice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ListItemProductsDAO {
    // Phương thức để lấy danh sách 10 sản phẩm bán chạy nhất
    public List<ItemProduct> getTop10BestSellers() {
        String query = "SELECT product_id, title, minPrice, AverageRating, img, views FROM getTop10bestSellers";
        List<ItemProduct> topProducts = new ArrayList<>(); // Danh sách chứa các sản phẩm bán chạy nhất
        
        try (Connection conn = DBConnection.getConnection();  // Lấy kết nối từ pool
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            // Duyệt qua các bản ghi trong ResultSet và thêm chúng vào danh sách
            while (rs.next()) {
                int productId = rs.getInt("product_id");
                String title = rs.getString("title");
                double minPrice = rs.getDouble("minPrice");
                float averageRating = rs.getFloat("AverageRating");
                String img = rs.getString("img");
                int views = rs.getInt("views");
                
                // Tạo đối tượng ItemProduct và thêm vào danh sách
                ItemProduct item = new ItemProduct(productId, title, averageRating,formatPrice(minPrice), img, views);
                topProducts.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Ghi log lỗi khi có exception
        }
        
        return topProducts; // Trả về danh sách các sản phẩm bán chạy nhất
    }
}
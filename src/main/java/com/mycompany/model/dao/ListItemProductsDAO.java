package com.mycompany.model.dao;

import com.mycompany.model.entity.ItemProductEntity;
import com.mycompany.utils.DBConnection;
import static com.mycompany.utils.Formatter.formatPrice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListItemProductsDAO {
    // Phương thức để gọi thủ tục getItemsNew và lấy danh sách sản phẩm mới
    public List<ItemProductEntity> getItemsNew(int sl) {
        String query = "EXEC getItemsNew @SL = ?";
        List<ItemProductEntity> newProducts = new ArrayList<>(); 
        
        try (Connection conn = DBConnection.getConnection();  
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, sl);  // Gán giá trị cho tham số @SL
            ResultSet rs = stmt.executeQuery();
            
            // Duyệt qua các bản ghi trong ResultSet và thêm chúng vào danh sách
            while (rs.next()) {
                int productId = rs.getInt("product_id");
                String title = rs.getString("title");
                double minPrice = rs.getDouble("minPrice");
                float averageRating = rs.getFloat("AverageRating");
                String img = rs.getString("img");
                int views = rs.getInt("views");
                
                // Tạo đối tượng ItemProduct và thêm vào danh sách
                ItemProductEntity item = new ItemProductEntity(productId, title, averageRating, formatPrice(minPrice), img, views);
                newProducts.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        
        return newProducts; 
    }
    
     public List<ItemProductEntity> getTopBestSellers(int sl) {
        String query = "EXEC getTopbestSellers @SL = ?";
        List<ItemProductEntity> bestSellers = new ArrayList<>(); 
        
        try (Connection conn = DBConnection.getConnection();  
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, sl);  // Gán giá tr? cho tham s? @SL
            ResultSet rs = stmt.executeQuery();
            
            // Duy?t qua các b?n ghi trong ResultSet và thêm chúng vào danh sách
            while (rs.next()) {
                int productId = rs.getInt("product_id");
                String title = rs.getString("title");
                double minPrice = rs.getDouble("minPrice");
                float averageRating = rs.getFloat("AverageRating");
                String img = rs.getString("img");
                int views = rs.getInt("views");
                
                // T?o d?i tu?ng ItemProduct và thêm vào danh sách
                ItemProductEntity item = new ItemProductEntity(productId, title, averageRating, formatPrice(minPrice), img, views);
                bestSellers.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        
        return bestSellers; 
    }
     
     //lay sp cho trang con
      public List<ItemProductEntity> getProductsByCategory(int categoryId, int sl) {
        String query = "EXEC getProductsByCategory @categoryId = ?, @SL = ?";
        List<ItemProductEntity> productsByCategory = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, categoryId);  // Gán giá trị cho tham số @categoryId
            stmt.setInt(2, sl);  // Gán giá trị cho tham số @SL
            ResultSet rs = stmt.executeQuery();
            
            // Duyệt qua các bản ghi trong ResultSet và thêm chúng vào danh sách
            while (rs.next()) {
                int productId = rs.getInt("product_id");
                String title = rs.getString("title");
                double minPrice = rs.getDouble("minPrice");
                float averageRating = rs.getFloat("AverageRating");
                String img = rs.getString("img");
                int views = rs.getInt("views");

                // Tạo đối tượng ItemProduct và thêm vào danh sách
                ItemProductEntity item = new ItemProductEntity(productId, title, averageRating, formatPrice(minPrice), img, views);
                productsByCategory.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return productsByCategory;
    }

      
      public List<ItemProductEntity> getProductsSorted(int categoryId, int sl, String sortBy) {
        String query = "EXEC getMinMaxSell @categoryId = ?, @SL = ?, @sortBy = ?";
        List<ItemProductEntity> sortedProducts = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, categoryId);  // Gán giá trị cho tham số @categoryId
            stmt.setInt(2, sl);  // Gán giá trị cho tham số @SL
            stmt.setString(3, sortBy);  // Gán giá trị cho tham số @sortBy
            ResultSet rs = stmt.executeQuery();

            // Duyệt qua các bản ghi trong ResultSet và thêm chúng vào danh sách
            while (rs.next()) {
                int productId = rs.getInt("product_id");
                String title = rs.getString("title");
                double minPrice = rs.getDouble("minPrice");
                float averageRating = rs.getFloat("AverageRating");
                String img = rs.getString("img");
                int views = rs.getInt("views");

                // Tạo đối tượng ItemProduct và thêm vào danh sách
                ItemProductEntity item = new ItemProductEntity(productId, title, averageRating, formatPrice(minPrice), img, views);
                sortedProducts.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }

        return sortedProducts;
    }

     
      
     
      
}

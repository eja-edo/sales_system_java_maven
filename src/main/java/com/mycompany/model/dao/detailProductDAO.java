package com.mycompany.model.dao;

import com.mycompany.model.entity.ProductDetail;
import com.mycompany.model.entity.ProductSize;
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

    public static Products getDetailProduct(int id) {
        String query1 = "exec ProductDetailsContent @ProductID = ?";
        String query2 = "exec productDetailImages @product = ?";
        String query3 = "exec GetProductSizeByProductId @ProductId = ?";  // Thủ tục lấy thông tin về size và stock_quantity

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
                        images.add(rs.getString("ImageURL"));
                    }
                    product.setListImg(images); // Gán danh sách hình ảnh vào sản phẩm
                }
            }

            // Thực thi câu truy vấn thứ ba để lấy danh sách size và stock_quantity
            try (PreparedStatement stmt3 = conn.prepareStatement(query3)) {
                stmt3.setInt(1, id);
                try (ResultSet rs = stmt3.executeQuery()) {
                    List<ProductSize> sizes = new ArrayList<>();
                    while (rs.next()) {
                        ProductSize size = new ProductSize();
                        size.setExempleId(rs.getInt("exemple_id"));
                        size.setSize(rs.getInt("size"));
                        size.setStockQuantity(rs.getInt("stock_quantity"));
                        sizes.add(size);
                    }
                    product.setSizes(sizes); // Gán danh sách kích thước vào sản phẩm
                }
            }
        } catch (SQLException e) {
            // Ghi log lỗi và trả về null
            e.printStackTrace();
            return null;
        }
        return product; // Trả về đối tượng sản phẩm
    }
    
    // Phương thức để gọi thủ tục GetCartProductDetails
    public static List<ProductDetail> getCartProductDetails(int userId) {
        List<ProductDetail> productDetails = new ArrayList<>();
        String query = "EXEC GetCartProductDetails @UserId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    ProductDetail productDetail = new ProductDetail();
                    productDetail.setUserId(rs.getInt("user_id"));
                    productDetail.setProductId(rs.getInt("product_id"));
                    productDetail.setTitle(rs.getString("title"));
                    productDetail.setSize(rs.getInt("size"));
                    productDetail.setPrice(rs.getDouble("price"));
                    productDetail.setImageUrl(rs.getString("ImageURL"));
                    productDetails.add(productDetail);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productDetails;
    }
}

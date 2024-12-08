package com.mycompany.model.dao;

import com.mycompany.model.entity.OrderItems;
import com.mycompany.utils.DBConnection;
import java.sql.*;
import java.util.List;

public class OrderDAO {

    // Phương thức thêm đơn hàng mới và trả về OrderID
    public int insertOrder(int userId, String orderStatus, double totalPrice, int addressId, int shuId, String paymentMethod) {
        int orderId = -1;

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "{call InsertOrder(?, ?, ?, ?, ?, ?)}";
            try (CallableStatement stmt = conn.prepareCall(sql)) {
                stmt.setInt(1, userId);
                stmt.setString(2, orderStatus);
                stmt.setDouble(3, totalPrice);
                stmt.setInt(4, addressId);
                stmt.setInt(5, shuId);
                stmt.setString(6, paymentMethod);

                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    orderId = rs.getInt("OrderID");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderId;
    }

    // Phương thức thêm sản phẩm vào đơn hàng
    public boolean insertOrderItem(OrderItems orderItem) {
        boolean isSuccess = false;

        try (Connection conn = DBConnection.getConnection()) {
            String sql = "{call InsertOrderItem(?, ?, ?, ?)}";
            try (CallableStatement stmt = conn.prepareCall(sql)) {
                stmt.setInt(1, orderItem.getOrderId());
                stmt.setInt(2, orderItem.getProductId());
                stmt.setInt(3, orderItem.getQuantity());
                stmt.setDouble(4, orderItem.getPrice());

                int rowsAffected = stmt.executeUpdate();
                isSuccess = rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isSuccess;
    }

    // Phương thức thêm nhiều sản phẩm vào đơn hàng
    public void insertOrderItems(int orderId, List<OrderItems> orderItems) {
        for (OrderItems item : orderItems) {
            item.setOrderId(orderId);
            insertOrderItem(item);
        }
    }
}

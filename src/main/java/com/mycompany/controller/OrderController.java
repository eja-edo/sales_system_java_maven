/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.controller;

import com.mycompany.model.entity.OrderItems;
import com.mycompany.model.dao.OrderDAO;
import com.mycompany.utils.CurrentUser;
import com.mycompany.model.entity.Users;
import java.util.ArrayList;
import java.util.List;

public class OrderController {
    private final OrderDAO orderDAO = new OrderDAO();

    public void placeOrder(String paymentMethod, List<OrderItems> orderItems) {
        Users currentUser = CurrentUser.getUser();
        if (currentUser == null) {
            System.out.println("Người dùng chưa đăng nhập.");
            return;
        }

        int userId = currentUser.getUserId(); // Lấy UserID từ CurrentUser
        String orderStatus = "Đang xử lý";
        double totalPrice = calculateTotalPrice(orderItems);
        int addressId = 1; // Địa chỉ mặc định
        int shuId = 1; // Đơn vị giao hàng mặc định

        // Thêm đơn hàng và lấy OrderID
        int orderId = orderDAO.insertOrder(userId, orderStatus, totalPrice, addressId, shuId, paymentMethod);

        if (orderId != -1) {
            orderDAO.insertOrderItems(orderId, orderItems);
            System.out.println("Đơn hàng được tạo thành công với OrderID: " + orderId);
        } else {
            System.out.println("Có lỗi xảy ra khi tạo đơn hàng.");
        }
    }

    private double calculateTotalPrice(List<OrderItems> orderItems) {
        return orderItems.stream().mapToDouble(item -> item.getPrice() * item.getQuantity()).sum();
    }

    public static void main(String[] args) {
        OrderController orderController = new OrderController();

        // Đăng nhập người dùng
        Users user = new Users();
        user.setUserId(1); // Đặt UserID giả định
        CurrentUser.setUser(user);

        List<OrderItems> orderItems = new ArrayList<>();
        orderItems.add(new OrderItems(0, 0, 2, 3, 100.50));
        orderItems.add(new OrderItems(0, 0, 3, 2, 150.75));
        orderItems.add(new OrderItems(0, 0, 4, 1, 200.00));

        orderController.placeOrder("Tiền mặt", orderItems);
    }
}

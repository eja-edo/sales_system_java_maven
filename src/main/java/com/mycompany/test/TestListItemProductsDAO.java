package com.mycompany.test;

import com.mycompany.model.entity.ItemProduct;
import com.mycompany.model.dao.ListItemProductsDAO;
import java.util.List;

public class TestListItemProductsDAO {
    public static void main(String[] args) {
        ListItemProductsDAO dao = new ListItemProductsDAO();
        
        // Lấy danh sách top 10 best sellers
        List<ItemProduct> products = dao.getTop10BestSellers();
        
        // Kiểm tra và in kết quả
        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            for (ItemProduct product : products) {
                System.out.println("Product ID: " + product.getProduct_id());
                System.out.println("Title: " + product.getTitle());
                System.out.println("Min Price: " + product.getMinPrice());
                System.out.println("Average Rating: " + product.getRating());
                System.out.println("Image: " + product.getUrlImg());
                System.out.println("Views: " + product.getViews());
                System.out.println("------------------------");
            }
        }
    }
}
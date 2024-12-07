package com.mycompany.controller;

import com.mycompany.model.dao.ListItemProductsDAO;
import com.mycompany.model.entity.ItemProductEntity;

import javax.swing.ImageIcon;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import javax.imageio.ImageIO;

public class LoadProductController {

    private final ListItemProductsDAO listItemProductsDAO;

    public LoadProductController() {
        listItemProductsDAO = new ListItemProductsDAO();
    }

    public List<ItemProductEntity> loadNewProducts(int limit) {
        return listItemProductsDAO.getItemsNew(limit);
    }

    public List<ItemProductEntity> loadBestSellers(int limit) {
        return listItemProductsDAO.getTopBestSellers(limit);
    }

    public List<ItemProductEntity> loadProductsByCategory(int categoryId, int limit) {
        return listItemProductsDAO.getProductsByCategory(categoryId, limit);
    }
    
    // Phương thức mới để gọi getProductsSorted
    public List<ItemProductEntity> loadProductsSorted(int categoryId, int limit, String sortBy) {
        return listItemProductsDAO.getProductsSorted(categoryId, limit, sortBy);
    }

    // Phương thức để tìm kiếm sản phẩm theo tiêu đề
    public List<ItemProductEntity> searchProductsByTitle(String keyword) {
        return listItemProductsDAO.searchProductsByTitle(keyword);
    }
    
    // Phương thức để đặt ảnh cho sản phẩm
    public ImageIcon getProductImage(String imgPath) {
        if (imgPath == null || imgPath.isEmpty()) {
            System.out.println("Đường dẫn ảnh null hoặc rỗng. Sử dụng ảnh mặc định.");
            return getDefaultProductImage();
        }

        try {
            // Thử tải ảnh từ URL nội bộ (resource)
            URL resourceUrl = getClass().getResource(imgPath.replace("\\", "/"));
            if (resourceUrl != null) {
                Image img = ImageIO.read(resourceUrl);
                return new ImageIcon(img);
            }

            // Nếu không tìm thấy trong resource, kiểm tra đường dẫn tuyệt đối
            File file = new File(imgPath);
            if (file.exists() && file.isFile()) {
                Image img = ImageIO.read(file);
                return new ImageIcon(img);
            }

            System.out.println("Không tìm thấy ảnh tại đường dẫn: " + imgPath);
        } catch (IOException e) {
            System.err.println("Lỗi khi tải ảnh từ đường dẫn: " + imgPath);
            e.printStackTrace();
        }

        // Trả về ảnh mặc định nếu có lỗi
        return getDefaultProductImage();
    }

    // Phương thức để lấy ảnh mặc định
    private ImageIcon getDefaultProductImage() {
        try {
            String defaultImgPath = "/image/png259X259.png";
            URL defaultUrl = getClass().getResource(defaultImgPath);
            if (defaultUrl != null) {
                Image defaultImg = ImageIO.read(defaultUrl);
                return new ImageIcon(defaultImg);
            } else {
                System.err.println("Không thể tìm thấy ảnh mặc định tại: " + defaultImgPath);
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi tải ảnh mặc định.");
            e.printStackTrace();
        }

        return null; // Trả về null nếu không có ảnh mặc định
    }

    public List<ItemProductEntity> getProductsSorted(int categoryId, int limit, String sortBy) {
        return listItemProductsDAO.getProductsSorted(categoryId, limit, sortBy);
    }
    
}

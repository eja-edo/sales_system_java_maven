package com.mycompany.controller;

import com.mycompany.model.dao.ListItemProductsDAO;
import com.mycompany.model.entity.ItemProductEntity;
import java.net.URL;
import java.util.List;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;

public class LoadProductController {

    private ListItemProductsDAO listItemProductsDAO;

    public LoadProductController() {
        listItemProductsDAO = new ListItemProductsDAO();
    }

    public List<ItemProductEntity> loadNewProducts(int limit) {
        return listItemProductsDAO.getItemsNew(limit);
    }

    public List<ItemProductEntity> loadBestSellers(int limit) {
        return listItemProductsDAO.getTopBestSellers(limit);
    }

    // Phương thức để đặt ảnh cho sản phẩm
    public ImageIcon getProductImage(String imgPath) {
        if (imgPath == null || imgPath.isEmpty()) {
            // Đặt ảnh mặc định nếu imgPath null hoặc rỗng
            return getDefaultProductImage();
        }

        try {
            // Chuyển đổi đường dẫn URL thành định dạng hợp lệ
            String formattedImgPath = imgPath.replace("\\", "/");
            URL url = getClass().getResource(formattedImgPath);

            if (url != null) {
                Image img = ImageIO.read(url);
                return new ImageIcon(img);
            } else {
                System.out.println("Không thể tìm thấy ảnh từ URL: " + formattedImgPath);
                // Đặt ảnh mặc định nếu không thể tìm thấy ảnh từ URL
                return getDefaultProductImage();
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Đặt ảnh mặc định nếu có lỗi khi tải ảnh
            return getDefaultProductImage();
        }
    }

    // Phương thức để lấy ảnh mặc định
    private ImageIcon getDefaultProductImage() {
        try {
            URL defaultUrl = getClass().getResource("/image/png259X259.png");
            if (defaultUrl != null) {
                Image defaultImg = ImageIO.read(defaultUrl);
                return new ImageIcon(defaultImg);
            } else {
                System.out.println("Không thể tìm thấy ảnh mặc định");
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

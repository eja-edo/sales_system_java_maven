package com.mycompany.controller;

import com.mycompany.model.dao.detailProductDAO;
import com.mycompany.model.entity.ProductDetail;
import com.mycompany.model.entity.Products;
import com.mycompany.tab.detailProduct;
import static com.mycompany.utils.Formatter.formatPrice;
import static com.mycompany.utils.Formatter.formatViews;
import java.util.List;

/**
 *
 * @author duyan
 */
public class ProductDetailController {

    private Products model;
    private detailProduct view;

    public ProductDetailController(Products model, detailProduct view) {
        this.model = model;
        this.view = view;
    }
    
    public void insertData(int id) {
        model = detailProductDAO.getDetailProduct(id); // Gọi phương thức tĩnh từ DAO
        view.setLabID(String.valueOf(model.getProductId()));
        view.setLabPrice(formatPrice(model.getMinPrice()));
        view.setListImgProduct(model.getListImg());
        view.setLabViews(formatViews(model.getViews()));
        view.setLabTitle(model.getTitle());
        view.setLabRating(String.valueOf(model.getAverageRating()));
        view.setProductSizesToComboBox(model.getSize());
    }
        
    // Phương thức để gọi thủ tục GetCartProductDetails và cập nhật view
    public List<ProductDetail> getCartProductDetails(int userId) {
        return detailProductDAO.getCartProductDetails(userId); // Gọi phương thức tĩnh từ DAO và trả về danh sách
    }
}

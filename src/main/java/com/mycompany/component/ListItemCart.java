/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.component;

import com.mycompany.component.ItemCart;
import com.mycompany.model.entity.ProductDetail;
import com.mycompany.tab.Cart;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author duyan
 */
public class ListItemCart extends javax.swing.JPanel {
    private List<ItemCart> selectedItems = new ArrayList<>();
    private Cart parent;
    
    
    public ListItemCart() {
        initComponents(); 
    }
    
    public void setParent(Cart pa)
    {
        this.parent = pa;
    }
    
    private double total = 0;
    
    public List<ProductDetail> getListProuctItem()
    {
        List<ProductDetail> items = new ArrayList<ProductDetail>();
        
        for(ItemCart ItemCart : selectedItems)
        {
            items.add(ItemCart.getItem());
        }
        return items;
    }
    
    
    
    public void setupItemCart(ItemCart itemCart) {
        itemCart.setSelectAction(e -> {
            if (itemCart.isSelected()) {
                System.out.println("đã thêm vào");
                selectedItems.add(itemCart);
                total += itemCart.getTotalItem();
                   parent.setTotalTemp(total);
            } else {
                System.out.println("đã xoa khoi");
                selectedItems.remove(itemCart);
                total -= itemCart.getTotalItem();
                parent.setTotalTemp(total);
            }
        });
        itemCart.setOnQuantityChangeListener(change -> updateTotal(change)); // Đăng ký callback
    }
    // Cập nhật tổng giá trị
    private void updateTotal(double change) {
        total += change; // Cộng dồn thay đổi
        parent.setTotalTemp(total);
    }
    
        // Hàm để xóa một ItemCart khỏi JPanel
    public void removeItemCart(ItemCart itemCart) {
        this.remove(itemCart); // Xóa ItemCart khỏi JPanel
        updateLayout();        // Cập nhật lại layout
    }

    // Cập nhật lại layout sau khi xóa
    private void updateLayout() {
        javax.swing.GroupLayout layout = (javax.swing.GroupLayout) this.getLayout();

        // Tạo các nhóm layout mới
        javax.swing.GroupLayout.SequentialGroup verticalGroup = layout.createSequentialGroup();
        javax.swing.GroupLayout.ParallelGroup horizontalGroup = layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING);

        // Lặp qua các thành phần hiện tại và thêm vào layout
        for (java.awt.Component comp : this.getComponents()) {
            horizontalGroup.addComponent(comp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE);
            verticalGroup.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED);
            verticalGroup.addComponent(comp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE);
        }

        // Gán lại các nhóm cho layout
        layout.setHorizontalGroup(horizontalGroup);
        layout.setVerticalGroup(verticalGroup);

//        // Làm mới giao diện
//        this.revalidate();
//        this.repaint();
    }

    // Thêm ItemCart mới với nút xóa đã được thiết lập
public void addItemCart(ItemCart itemCart) {
    // Thêm ItemCart vào vị trí đầu tiên
    this.add(itemCart, 0);
    setupItemCart(itemCart);
    // Gắn sự kiện cho nút xóa
    itemCart.setDeleteAction(e -> removeItemCart(itemCart));
    
    // Cập nhật lại layout
    updateLayout();
}
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 616, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 777, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

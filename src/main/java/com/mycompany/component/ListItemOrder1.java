/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.component;

import com.mycompany.component.ItemCart;
import com.mycompany.model.entity.ProductDetail;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author duyan
 */
public class ListItemOrder1 extends javax.swing.JPanel {
    private List<ItemCart> selectedItems = new ArrayList<>();
    
    
    
    public ListItemOrder1() {
        initComponents(); 
    }
    
    
//    public void setupItemCart(ItemCart itemCart) {
//        itemCart.setSelectAction(e -> {
//            if (itemCart.isSelected()) {
//                selectedItems.add(itemCart);
//            } else {
//                selectedItems.remove(itemCart);
//            }
//        });
//    }

        public double getTotal() {
        double total = 0.0;
        
        // Duyệt qua tất cả các components (ItemOrder) trong JPanel
        for (java.awt.Component component : this.getComponents()) {
            if (component instanceof ItemOrder) {
                ItemOrder itemOrder = (ItemOrder) component;
                total += itemOrder.getTotalItem(); // Cộng dồn giá trị của mỗi itemOrder
            }
        }
        
        return total; // Trả về tổng giá trị
    }

    
    
        // Hàm để xóa một ItemCart khỏi JPanel
//    public void removeItemCart(ItemCart itemCart) {
//        this.remove(itemCart); // Xóa ItemCart khỏi JPanel
//        updateLayout();        // Cập nhật lại layout
//    }

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
public void addItemOrder(ItemOrder ItemOrder) {
    // Thêm ItemCart vào vị trí đầu tiên
    this.add(ItemOrder, 0);
//    setupItemCart(itemCart);
//    // Gắn sự kiện cho nút xóa
//    itemCart.setDeleteAction(e -> removeItemCart(itemCart));
//    
//    // Cập nhật lại layout
    updateLayout();
}
    public void addListItem(List<ProductDetail> items)
    {
        for(ProductDetail item : items)
        {
            addItemOrder(new ItemOrder(item));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 47, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.component;

import com.mycompany.controller.LoadProductController;
import com.mycompany.model.entity.ItemProductEntity;
import com.mycompany.tab.LoginTab;
import com.mycompany.tab.detailProduct;
import com.mycompany.utils.RoundBorder;
import java.awt.Color;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author haidu
 */
public class trang_con extends javax.swing.JPanel {
  private final LoadProductController loadProductController;
   private int currentCategoryId; // Thêm biến toàn cục lưu ID hiện tại

     public trang_con() {
        initComponents();
        loadProductController = new LoadProductController();
    }

//     public trang_con()
//     {
//         this();
//         
//     }
     
     public void openDetail(ItemProduct item)
     {
        int id = item.getId();
        detailProduct detal = new detailProduct(id);
        JFrame frame = new JFrame(""); // Tạo JFrame chứa panel
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(detal); // Thêm panel vào frame
        frame.pack(); // Căn chỉnh kích thước
        frame.setLocationRelativeTo(null); // Căn gi
        frame.setVisible(true); // Hiển thị frame
     }
             
             
             
     public void setTrangCon(int i)
     {
         this.currentCategoryId = i; // Lưu trữ giá trị ID
         setupProductComponents(i);
         setupTuthaplencao(i);
         setupTuCaoxuongthap(i);
         setupSoluotban(i);
     }
    private void setupProductComponents(int loaiID) {
        List<ItemProductEntity> productEntities = loadProductController.loadProductsByCategory(loaiID,20);

        ItemProduct[] componentsArray = {
            itemProduct1, itemProduct2, itemProduct3,
            itemProduct4, itemProduct5,itemProduct6, itemProduct7, itemProduct8,
            itemProduct10, itemProduct11,itemProduct12, itemProduct13, itemProduct17,
            itemProduct18, itemProduct19,itemProduct20, itemProduct21, itemProduct22,
            itemProduct23, itemProduct24
        };

        for (int i = 0; i < productEntities.size() && i < componentsArray.length; i++) {
            componentsArray[i].setItemProduct(productEntities.get(i));
        }
    }
    private void setupTuthaplencao(int loaiID) {
        List<ItemProductEntity> productEntities = loadProductController.getProductsSorted(loaiID,20,"price_asc");

        ItemProduct[] componentsArray = {
           itemProduct1, itemProduct2, itemProduct3,
            itemProduct4, itemProduct5,itemProduct6, itemProduct7, itemProduct8,
            itemProduct10, itemProduct11,itemProduct12, itemProduct13, itemProduct17,
            itemProduct18, itemProduct19,itemProduct20, itemProduct21, itemProduct22,
            itemProduct23, itemProduct24
        };

        for (int i = 0; i < productEntities.size() && i < componentsArray.length; i++) {
            componentsArray[i].setItemProduct(productEntities.get(i));
        }
    }
      private void setupTuCaoxuongthap(int LoaiID) {
        List<ItemProductEntity> productEntities = loadProductController.getProductsSorted(LoaiID, 20, "price_desc");

        ItemProduct[] componentsArray = {
           itemProduct1, itemProduct2, itemProduct3,
            itemProduct4, itemProduct5,itemProduct6, itemProduct7, itemProduct8,
            itemProduct10, itemProduct11,itemProduct12, itemProduct13, itemProduct17,
            itemProduct18, itemProduct19,itemProduct20, itemProduct21, itemProduct22,
            itemProduct23, itemProduct24
        };

         for (int i = 0; i < productEntities.size() && i < componentsArray.length; i++) {
            componentsArray[i].setItemProduct(productEntities.get(i));
        }
    }

       private void setupSoluotban(int LoaiID) {
        List<ItemProductEntity> productEntities = loadProductController.getProductsSorted(LoaiID, 20, "sales");

        ItemProduct[] componentsArray = {
            itemProduct1, itemProduct2, itemProduct3,
            itemProduct4, itemProduct5,itemProduct6, itemProduct7, itemProduct8,
            itemProduct10, itemProduct11,itemProduct12, itemProduct13, itemProduct17,
            itemProduct18, itemProduct19,itemProduct20, itemProduct21, itemProduct22,
            itemProduct23, itemProduct24
        };

         for (int i = 0; i < productEntities.size() && i < componentsArray.length; i++) {
            componentsArray[i].setItemProduct(productEntities.get(i));
        }
    }

       
    private void comboBoxActionPerformed() {
        String selectedSort = (String) comboBoxSuggestion1.getSelectedItem();
        switch (selectedSort) {
            case "Giá thấp đến cao":
                setupTuthaplencao(currentCategoryId);
                break;
            case "Giá cao xuống thấp":
                setupTuCaoxuongthap(currentCategoryId);
                break;
            case "Số lượt bán":
                setupSoluotban(currentCategoryId);
                break;
            default:
                setupProductComponents(currentCategoryId);
                break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        itemProduct1 = new com.mycompany.component.ItemProduct();
        itemProduct2 = new com.mycompany.component.ItemProduct();
        itemProduct3 = new com.mycompany.component.ItemProduct();
        itemProduct4 = new com.mycompany.component.ItemProduct();
        itemProduct5 = new com.mycompany.component.ItemProduct();
        itemProduct6 = new com.mycompany.component.ItemProduct();
        itemProduct7 = new com.mycompany.component.ItemProduct();

        itemProduct8 = new com.mycompany.component.ItemProduct();
        itemProduct10 = new com.mycompany.component.ItemProduct();
        itemProduct11 = new com.mycompany.component.ItemProduct();
        itemProduct12 = new com.mycompany.component.ItemProduct();
        itemProduct13 = new com.mycompany.component.ItemProduct();

        itemProduct17 = new com.mycompany.component.ItemProduct();
        itemProduct18 = new com.mycompany.component.ItemProduct();
        itemProduct19 = new com.mycompany.component.ItemProduct();
        itemProduct20 = new com.mycompany.component.ItemProduct();
        itemProduct21 = new com.mycompany.component.ItemProduct();
        itemProduct22 = new com.mycompany.component.ItemProduct();
        itemProduct23 = new com.mycompany.component.ItemProduct();
        itemProduct24 = new com.mycompany.component.ItemProduct();
        jLabel2 = new javax.swing.JLabel();
        comboBoxSuggestion1 = new com.mycompany.swing.ComboBoxSuggestion();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 1800));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/z6056783267859_fa8269f989fded0dfb04358efd3ba6eb.jpg"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 20));
        jPanel1.add(itemProduct1);
        jPanel1.add(itemProduct2);
        jPanel1.add(itemProduct3);
        jPanel1.add(itemProduct4);
        jPanel1.add(itemProduct5);
        jPanel1.add(itemProduct6);
        jPanel1.add(itemProduct7);

        jPanel1.add(itemProduct8);
        jPanel1.add(itemProduct10);
        jPanel1.add(itemProduct11);
        jPanel1.add(itemProduct12);
        jPanel1.add(itemProduct13);

        jPanel1.add(itemProduct17);
        jPanel1.add(itemProduct18);
        jPanel1.add(itemProduct19);
        jPanel1.add(itemProduct20);
        jPanel1.add(itemProduct21);
        jPanel1.add(itemProduct22);
        jPanel1.add(itemProduct23);
        jPanel1.add(itemProduct24);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Sắp xếp theo: ");

        comboBoxSuggestion1.setBorder(new RoundBorder(Color.GRAY,10,1));
        comboBoxSuggestion1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Giá thấp đến cao", "Giá cao xuống thấp", "Số lượt bán" }));
        comboBoxSuggestion1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        comboBoxSuggestion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSuggestion1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(comboBoxSuggestion1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboBoxSuggestion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 2139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxSuggestion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSuggestion1ActionPerformed
         comboBoxActionPerformed();
    }//GEN-LAST:event_comboBoxSuggestion1ActionPerformed

    private void itemProduct4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemProduct4MouseClicked

    }//GEN-LAST:event_itemProduct4MouseClicked


    // Variables declaration - do not modify                     
    private com.mycompany.swing.ComboBoxSuggestion comboBoxSuggestion1;
    private com.mycompany.component.ItemProduct itemProduct1;
    private com.mycompany.component.ItemProduct itemProduct10;
    private com.mycompany.component.ItemProduct itemProduct11;
    private com.mycompany.component.ItemProduct itemProduct12;
    private com.mycompany.component.ItemProduct itemProduct13;
    private com.mycompany.component.ItemProduct itemProduct17;
    private com.mycompany.component.ItemProduct itemProduct18;
    private com.mycompany.component.ItemProduct itemProduct19;
    private com.mycompany.component.ItemProduct itemProduct2;
    private com.mycompany.component.ItemProduct itemProduct20;
    private com.mycompany.component.ItemProduct itemProduct21;
    private com.mycompany.component.ItemProduct itemProduct22;
    private com.mycompany.component.ItemProduct itemProduct23;
    private com.mycompany.component.ItemProduct itemProduct24;
    private com.mycompany.component.ItemProduct itemProduct3;
    private com.mycompany.component.ItemProduct itemProduct4;
    private com.mycompany.component.ItemProduct itemProduct5;
    private com.mycompany.component.ItemProduct itemProduct6;
    private com.mycompany.component.ItemProduct itemProduct7;
    private com.mycompany.component.ItemProduct itemProduct8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;

}

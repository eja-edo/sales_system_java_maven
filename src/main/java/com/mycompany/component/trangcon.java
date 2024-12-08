/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.component;

import com.mycompany.controller.LoadProductController;
import com.mycompany.model.entity.ItemProductEntity;
import com.mycompany.tab.detailProduct;
import com.mycompany.utils.RoundBorder;
import java.awt.Color;
import java.util.List;
import javax.swing.JFrame;


/**
 *
 * @author haidu
 */
public class trangcon extends javax.swing.JPanel {
  private final LoadProductController loadProductController;
   private int currentCategoryId; // Thêm biến toàn cục lưu ID hiện tại

     public trangcon() {
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
     public List<ItemProductEntity> searchProductsByTitle(String keyword) {
    return loadProductController.searchProductsByTitle(keyword);
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
    
      private void searchAndDisplayProducts(String keyword) {
    // Tìm kiếm danh sách sản phẩm phù hợp với từ khóa
    List<ItemProductEntity> productEntities = loadProductController.searchProductsByTitle(keyword);

    // Danh sách các ItemProduct trên giao diện
    ItemProduct[] componentsArray = {
        itemProduct1, itemProduct2, itemProduct3,
        itemProduct4, itemProduct5, itemProduct6, itemProduct7, itemProduct8,
        itemProduct10, itemProduct11, itemProduct12, itemProduct13, itemProduct17,
        itemProduct18, itemProduct19, itemProduct20, itemProduct21, itemProduct22,
        itemProduct23, itemProduct24
    };

    for (int i = 0; i < productEntities.size() && i < componentsArray.length; i++) {
        componentsArray[i].setItemProduct(productEntities.get(i));
    }
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        comboBoxSuggestion1 = new com.mycompany.swing.ComboBoxSuggestion();
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
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        comboBoxSuggestion2 = new com.mycompany.swing.ComboBoxSuggestion();
        jPanel3 = new javax.swing.JPanel();
        itemProduct9 = new com.mycompany.component.ItemProduct();
        itemProduct14 = new com.mycompany.component.ItemProduct();
        itemProduct15 = new com.mycompany.component.ItemProduct();
        itemProduct16 = new com.mycompany.component.ItemProduct();
        itemProduct25 = new com.mycompany.component.ItemProduct();
        itemProduct26 = new com.mycompany.component.ItemProduct();
        itemProduct27 = new com.mycompany.component.ItemProduct();
        itemProduct28 = new com.mycompany.component.ItemProduct();
        itemProduct29 = new com.mycompany.component.ItemProduct();
        itemProduct30 = new com.mycompany.component.ItemProduct();
        itemProduct31 = new com.mycompany.component.ItemProduct();
        itemProduct32 = new com.mycompany.component.ItemProduct();
        itemProduct33 = new com.mycompany.component.ItemProduct();
        itemProduct34 = new com.mycompany.component.ItemProduct();
        itemProduct35 = new com.mycompany.component.ItemProduct();
        itemProduct36 = new com.mycompany.component.ItemProduct();
        itemProduct37 = new com.mycompany.component.ItemProduct();
        itemProduct38 = new com.mycompany.component.ItemProduct();
        itemProduct39 = new com.mycompany.component.ItemProduct();
        itemProduct40 = new com.mycompany.component.ItemProduct();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/z6056783267859_fa8269f989fded0dfb04358efd3ba6eb.jpg"))); // NOI18N

        comboBoxSuggestion1.setBorder(new RoundBorder(Color.GRAY,10,1));
        comboBoxSuggestion1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Giá thấp đến cao", "Giá cao xuống thấp", "Số lượt bán" }));
        comboBoxSuggestion1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        comboBoxSuggestion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSuggestion1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 20));
        jPanel1.add(itemProduct1);
        jPanel1.add(itemProduct2);
        jPanel1.add(itemProduct3);
        jPanel1.add(itemProduct4);
        jPanel1.add(itemProduct5);
        jPanel1.add(itemProduct6);
        jPanel1.add(itemProduct7);

        itemProduct8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemProduct8itemProduct4MouseClicked(evt);
            }
        });
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

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Sắp xếp theo: ");

        jTextField1.setText("Tìm kiếm nhanh....");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/z6056783267859_fa8269f989fded0dfb04358efd3ba6eb.jpg"))); // NOI18N

        comboBoxSuggestion2.setBorder(new RoundBorder(Color.GRAY,10,1));
        comboBoxSuggestion2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Giá thấp đến cao", "Giá cao xuống thấp", "Số lượt bán" }));
        comboBoxSuggestion2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        comboBoxSuggestion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSuggestion2ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 20, 20));
        jPanel3.add(itemProduct9);
        jPanel3.add(itemProduct14);
        jPanel3.add(itemProduct15);
        jPanel3.add(itemProduct16);
        jPanel3.add(itemProduct25);
        jPanel3.add(itemProduct26);
        jPanel3.add(itemProduct27);

        itemProduct28.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemProduct28itemProduct4MouseClicked(evt);
            }
        });
        jPanel3.add(itemProduct28);
        jPanel3.add(itemProduct29);
        jPanel3.add(itemProduct30);
        jPanel3.add(itemProduct31);
        jPanel3.add(itemProduct32);
        jPanel3.add(itemProduct33);
        jPanel3.add(itemProduct34);
        jPanel3.add(itemProduct35);
        jPanel3.add(itemProduct36);
        jPanel3.add(itemProduct37);
        jPanel3.add(itemProduct38);
        jPanel3.add(itemProduct39);
        jPanel3.add(itemProduct40);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Sắp xếp theo: ");

        jTextField2.setText("Tìm kiếm nhanh....");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxSuggestion2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBoxSuggestion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 2121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxSuggestion1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboBoxSuggestion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 2121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxSuggestion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSuggestion1ActionPerformed
        comboBoxActionPerformed();
    }//GEN-LAST:event_comboBoxSuggestion1ActionPerformed

    private void itemProduct8itemProduct4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemProduct8itemProduct4MouseClicked

    }//GEN-LAST:event_itemProduct8itemProduct4MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
           String keyword = jTextField1.getText();
    if (keyword.isEmpty()) {
        // Nếu text field rỗng, hiển thị tất cả sản phẩm
        setupProductComponents(currentCategoryId);
    } else {
        // Tìm kiếm và hiển thị các sản phẩm phù hợp với từ khóa
        searchAndDisplayProducts(keyword);
    }
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void comboBoxSuggestion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSuggestion2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxSuggestion2ActionPerformed

    private void itemProduct28itemProduct4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemProduct28itemProduct4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_itemProduct28itemProduct4MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.swing.ComboBoxSuggestion comboBoxSuggestion1;
    private com.mycompany.swing.ComboBoxSuggestion comboBoxSuggestion2;
    private com.mycompany.component.ItemProduct itemProduct1;
    private com.mycompany.component.ItemProduct itemProduct10;
    private com.mycompany.component.ItemProduct itemProduct11;
    private com.mycompany.component.ItemProduct itemProduct12;
    private com.mycompany.component.ItemProduct itemProduct13;
    private com.mycompany.component.ItemProduct itemProduct14;
    private com.mycompany.component.ItemProduct itemProduct15;
    private com.mycompany.component.ItemProduct itemProduct16;
    private com.mycompany.component.ItemProduct itemProduct17;
    private com.mycompany.component.ItemProduct itemProduct18;
    private com.mycompany.component.ItemProduct itemProduct19;
    private com.mycompany.component.ItemProduct itemProduct2;
    private com.mycompany.component.ItemProduct itemProduct20;
    private com.mycompany.component.ItemProduct itemProduct21;
    private com.mycompany.component.ItemProduct itemProduct22;
    private com.mycompany.component.ItemProduct itemProduct23;
    private com.mycompany.component.ItemProduct itemProduct24;
    private com.mycompany.component.ItemProduct itemProduct25;
    private com.mycompany.component.ItemProduct itemProduct26;
    private com.mycompany.component.ItemProduct itemProduct27;
    private com.mycompany.component.ItemProduct itemProduct28;
    private com.mycompany.component.ItemProduct itemProduct29;
    private com.mycompany.component.ItemProduct itemProduct3;
    private com.mycompany.component.ItemProduct itemProduct30;
    private com.mycompany.component.ItemProduct itemProduct31;
    private com.mycompany.component.ItemProduct itemProduct32;
    private com.mycompany.component.ItemProduct itemProduct33;
    private com.mycompany.component.ItemProduct itemProduct34;
    private com.mycompany.component.ItemProduct itemProduct35;
    private com.mycompany.component.ItemProduct itemProduct36;
    private com.mycompany.component.ItemProduct itemProduct37;
    private com.mycompany.component.ItemProduct itemProduct38;
    private com.mycompany.component.ItemProduct itemProduct39;
    private com.mycompany.component.ItemProduct itemProduct4;
    private com.mycompany.component.ItemProduct itemProduct40;
    private com.mycompany.component.ItemProduct itemProduct5;
    private com.mycompany.component.ItemProduct itemProduct6;
    private com.mycompany.component.ItemProduct itemProduct7;
    private com.mycompany.component.ItemProduct itemProduct8;
    private com.mycompany.component.ItemProduct itemProduct9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}

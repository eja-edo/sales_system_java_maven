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
    return loadProductController.searchProductsByTitle(keyword,currentCategoryId);
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
    
     
private void searchAndDisplayProducts(String keyword, Integer categoryId) {
    List<ItemProductEntity> productEntities = loadProductController.searchProductsByTitle(keyword, categoryId);

    // Danh sách các ItemProduct trên giao diện
    ItemProduct[] componentsArray = {
        itemProduct1, itemProduct2, itemProduct3,
        itemProduct4, itemProduct5, itemProduct6, itemProduct7, itemProduct8,
        itemProduct10, itemProduct11, itemProduct12, itemProduct13, itemProduct17,
        itemProduct18, itemProduct19, itemProduct20, itemProduct21, itemProduct22,
        itemProduct23, itemProduct24
    };

    for (int i = 0; i < componentsArray.length; i++) {
        if (i < productEntities.size()) {
            componentsArray[i].setItemProduct(productEntities.get(i));
            componentsArray[i].setVisible(true); // Hiển thị thành phần
        } else {
            componentsArray[i].setVisible(false); // Ẩn thành phần
        }
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
        panelRound1 = new com.mycompany.swing.PanelRound();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

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

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N

        jTextField1.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jTextField1.setBorder(null);
        jTextField1.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jTextField1.setSelectedTextColor(new java.awt.Color(242, 242, 242));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboBoxSuggestion1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(comboBoxSuggestion1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 2121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxSuggestion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSuggestion1ActionPerformed
        comboBoxActionPerformed();
    }//GEN-LAST:event_comboBoxSuggestion1ActionPerformed

    private void itemProduct8itemProduct4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemProduct8itemProduct4MouseClicked

    }//GEN-LAST:event_itemProduct8itemProduct4MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
       
    String keyword = jTextField1.getText();

    // Gọi phương thức searchAndDisplayProducts với từ khóa
    searchAndDisplayProducts(keyword,currentCategoryId);

    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private com.mycompany.swing.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}

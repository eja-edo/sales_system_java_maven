/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.tab;

import com.mycompany.component.ItemProduct;
import com.mycompany.component.header;
import com.mycompany.controller.LoadProductController;
import com.mycompany.model.entity.ItemProductEntity;
import com.mycompany.model.entity.Users;
import com.mycompany.utils.CurrentUser;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;



/**
 *
 * @author duyan
 */
public class Home extends javax.swing.JPanel {

    
   private final LoadProductController loadProductController;

    public Home() {
        initComponents();
        loadProductController  = new LoadProductController();
//        setupProductComponents();
    }

    private void setupProductComponents() {
        List<ItemProductEntity> productEntities = loadProductController.loadNewProducts(4);

        ItemProduct[] componentsArray = {
            itemProduct1, itemProduct2, itemProduct3,
            itemProduct4
        };

        for (int i = 0; i < productEntities.size() && i < componentsArray.length; i++) {
            componentsArray[i].setItemProduct(productEntities.get(i));
        }

        List<ItemProductEntity> bestSellers = loadProductController.loadBestSellers(8);

        ItemProduct[] bestSellersArray = {
            itemProduct6, itemProduct7, itemProduct8,
            itemProduct9, itemProduct16,
            itemProduct17, itemProduct18, itemProduct19,
        };
        
        

        for (int i = 0; i < bestSellers.size() && i < bestSellersArray.length; i++) {
            bestSellersArray[i].setItemProduct(bestSellers.get(i));
        }
    }
     
    public void openDetail(ItemProduct item) {
            int id = item.getId();
            detailProduct detal = new detailProduct(id); // Tạo panel detailProduct

            // Tạo JScrollPane bao bọc panel detailProduct
            JScrollPane scrollPane = new JScrollPane(detal);
            scrollPane.setPreferredSize(new Dimension(945, 800)); // Đặt kích thước mong muốn (tùy chỉnh theo nội dung)

            // Tạo JDialog chứa JScrollPane
            JDialog dialog = new JDialog((Frame) null, "Chi tiết sản phẩm", true);
            dialog.getContentPane().add(scrollPane); // Thêm JScrollPane vào dialog
            dialog.pack(); // Căn chỉnh kích thước
            dialog.setLocationRelativeTo(null); // Căn giữa màn hình
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // Đóng dialog
            dialog.setVisible(true); // Hiển thị dialog  

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        itemProduct1 = new com.mycompany.component.ItemProduct();
        itemProduct2 = new com.mycompany.component.ItemProduct();
        itemProduct4 = new com.mycompany.component.ItemProduct();
        itemProduct3 = new com.mycompany.component.ItemProduct();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        itemProduct6 = new com.mycompany.component.ItemProduct();
        itemProduct7 = new com.mycompany.component.ItemProduct();
        itemProduct8 = new com.mycompany.component.ItemProduct();
        itemProduct9 = new com.mycompany.component.ItemProduct();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        itemProduct16 = new com.mycompany.component.ItemProduct();
        itemProduct17 = new com.mycompany.component.ItemProduct();
        itemProduct18 = new com.mycompany.component.ItemProduct();
        itemProduct19 = new com.mycompany.component.ItemProduct();
        jPanel7 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sản phẩm bán chạy");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        itemProduct1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemProduct1MouseClicked(evt);
            }
        });
        jPanel1.add(itemProduct1);

        itemProduct2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemProduct2MouseClicked(evt);
            }
        });
        jPanel1.add(itemProduct2);

        itemProduct4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemProduct4MouseClicked(evt);
            }
        });
        jPanel1.add(itemProduct4);

        itemProduct3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemProduct3MouseClicked(evt);
            }
        });
        jPanel1.add(itemProduct3);

        jPanel2.setPreferredSize(new java.awt.Dimension(1000, 1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);

        jButton1.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(152, 117, 83));
        jButton1.setText("XEM THÊM >>");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 1, 1));
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sản phẩm mới");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        itemProduct6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemProduct6MouseClicked(evt);
            }
        });
        jPanel3.add(itemProduct6);

        itemProduct7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemProduct7MouseClicked(evt);
            }
        });
        jPanel3.add(itemProduct7);

        itemProduct8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemProduct8MouseClicked(evt);
            }
        });
        jPanel3.add(itemProduct8);

        itemProduct9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemProduct9MouseClicked(evt);
            }
        });
        jPanel3.add(itemProduct9);

        jPanel4.setPreferredSize(new java.awt.Dimension(1000, 1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel4);

        jButton2.setFont(new java.awt.Font("Candara", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(152, 117, 83));
        jButton2.setText("XEM THÊM >>");
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 1, 1, 1));
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel6.setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bg.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel6.add(jLabel1);
        jLabel1.setBounds(-10, 0, 1340, 450);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        itemProduct16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemProduct16MouseClicked(evt);
            }
        });
        jPanel5.add(itemProduct16);

        itemProduct17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemProduct17MouseClicked(evt);
            }
        });
        jPanel5.add(itemProduct17);

        itemProduct18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemProduct18MouseClicked(evt);
            }
        });
        jPanel5.add(itemProduct18);

        itemProduct19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemProduct19MouseClicked(evt);
            }
        });
        jPanel5.add(itemProduct19);

        jPanel7.setPreferredSize(new java.awt.Dimension(1000, 1));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(124, 124, 124))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 491, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(456, 456, 456)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(1186, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(561, 561, 561)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void itemProduct1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemProduct1MouseClicked
    // Lấy Component đã được click
    Component clickedComponent = (Component) evt.getSource();
    
    // Kiểm tra nếu clickedComponent là kiểu ItemProduct (nếu đúng kiểu)
    if (clickedComponent instanceof ItemProduct) {
        ItemProduct item = (ItemProduct) clickedComponent;
        
        // Gọi phương thức openDetail với item đã được click
        openDetail(item);
    }
    }//GEN-LAST:event_itemProduct1MouseClicked

    private void itemProduct2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemProduct2MouseClicked
        // TODO add your handling code here:
        // Lấy Component đã được click
    Component clickedComponent = (Component) evt.getSource();
    
    // Kiểm tra nếu clickedComponent là kiểu ItemProduct (nếu đúng kiểu)
    if (clickedComponent instanceof ItemProduct) {
        ItemProduct item = (ItemProduct) clickedComponent;
        
        // Gọi phương thức openDetail với item đã được click
        openDetail(item);
    }
    }//GEN-LAST:event_itemProduct2MouseClicked

    private void itemProduct4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemProduct4MouseClicked
        // TODO add your handling code here:
        // Lấy Component đã được click
    Component clickedComponent = (Component) evt.getSource();
    
    // Kiểm tra nếu clickedComponent là kiểu ItemProduct (nếu đúng kiểu)
    if (clickedComponent instanceof ItemProduct) {
        ItemProduct item = (ItemProduct) clickedComponent;
        
        // Gọi phương thức openDetail với item đã được click
        openDetail(item);
    }
    }//GEN-LAST:event_itemProduct4MouseClicked

    private void itemProduct3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemProduct3MouseClicked
       // TODO add your handling code here:
        // Lấy Component đã được click
    Component clickedComponent = (Component) evt.getSource();
    
    // Kiểm tra nếu clickedComponent là kiểu ItemProduct (nếu đúng kiểu)
    if (clickedComponent instanceof ItemProduct) {
        ItemProduct item = (ItemProduct) clickedComponent;
        
        // Gọi phương thức openDetail với item đã được click
        openDetail(item);
    }
    }//GEN-LAST:event_itemProduct3MouseClicked

    private void itemProduct6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemProduct6MouseClicked
       // TODO add your handling code here:
        // Lấy Component đã được click
    Component clickedComponent = (Component) evt.getSource();
    
    // Kiểm tra nếu clickedComponent là kiểu ItemProduct (nếu đúng kiểu)
    if (clickedComponent instanceof ItemProduct) {
        ItemProduct item = (ItemProduct) clickedComponent;
        
        // Gọi phương thức openDetail với item đã được click
        openDetail(item);
    }
    }//GEN-LAST:event_itemProduct6MouseClicked

    private void itemProduct7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemProduct7MouseClicked
         // TODO add your handling code here:
        // Lấy Component đã được click
    Component clickedComponent = (Component) evt.getSource();
    
    // Kiểm tra nếu clickedComponent là kiểu ItemProduct (nếu đúng kiểu)
    if (clickedComponent instanceof ItemProduct) {
        ItemProduct item = (ItemProduct) clickedComponent;
        
        // Gọi phương thức openDetail với item đã được click
        openDetail(item);
    }
    }//GEN-LAST:event_itemProduct7MouseClicked

    private void itemProduct8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemProduct8MouseClicked
       // TODO add your handling code here:
        // Lấy Component đã được click
    Component clickedComponent = (Component) evt.getSource();
    
    // Kiểm tra nếu clickedComponent là kiểu ItemProduct (nếu đúng kiểu)
    if (clickedComponent instanceof ItemProduct) {
        ItemProduct item = (ItemProduct) clickedComponent;
        
        // Gọi phương thức openDetail với item đã được click
        openDetail(item);
    }
    }//GEN-LAST:event_itemProduct8MouseClicked

    private void itemProduct9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemProduct9MouseClicked
         // TODO add your handling code here:
        // Lấy Component đã được click
    Component clickedComponent = (Component) evt.getSource();
    
    // Kiểm tra nếu clickedComponent là kiểu ItemProduct (nếu đúng kiểu)
    if (clickedComponent instanceof ItemProduct) {
        ItemProduct item = (ItemProduct) clickedComponent;
        
        // Gọi phương thức openDetail với item đã được click
        openDetail(item);
    }
    }//GEN-LAST:event_itemProduct9MouseClicked

    private void itemProduct16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemProduct16MouseClicked
       // TODO add your handling code here:
        // Lấy Component đã được click
    Component clickedComponent = (Component) evt.getSource();
    
    // Kiểm tra nếu clickedComponent là kiểu ItemProduct (nếu đúng kiểu)
    if (clickedComponent instanceof ItemProduct) {
        ItemProduct item = (ItemProduct) clickedComponent;
        
        // Gọi phương thức openDetail với item đã được click
        openDetail(item);
    }
    }//GEN-LAST:event_itemProduct16MouseClicked

    private void itemProduct17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemProduct17MouseClicked
        // TODO add your handling code here:
        // Lấy Component đã được click
    Component clickedComponent = (Component) evt.getSource();
    
    // Kiểm tra nếu clickedComponent là kiểu ItemProduct (nếu đúng kiểu)
    if (clickedComponent instanceof ItemProduct) {
        ItemProduct item = (ItemProduct) clickedComponent;
        
        // Gọi phương thức openDetail với item đã được click
        openDetail(item);
    }
    }//GEN-LAST:event_itemProduct17MouseClicked

    private void itemProduct18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemProduct18MouseClicked
       // TODO add your handling code here:
        // Lấy Component đã được click
    Component clickedComponent = (Component) evt.getSource();
    
    // Kiểm tra nếu clickedComponent là kiểu ItemProduct (nếu đúng kiểu)
    if (clickedComponent instanceof ItemProduct) {
        ItemProduct item = (ItemProduct) clickedComponent;
        
        // Gọi phương thức openDetail với item đã được click
        openDetail(item);
    }
    }//GEN-LAST:event_itemProduct18MouseClicked

    private void itemProduct19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemProduct19MouseClicked
       // TODO add your handling code here:
        // Lấy Component đã được click
    Component clickedComponent = (Component) evt.getSource();
    
    // Kiểm tra nếu clickedComponent là kiểu ItemProduct (nếu đúng kiểu)
    if (clickedComponent instanceof ItemProduct) {
        ItemProduct item = (ItemProduct) clickedComponent;
        
        // Gọi phương thức openDetail với item đã được click
        openDetail(item);
    }
    }//GEN-LAST:event_itemProduct19MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.component.ItemProduct itemProduct1;
    private com.mycompany.component.ItemProduct itemProduct16;
    private com.mycompany.component.ItemProduct itemProduct17;
    private com.mycompany.component.ItemProduct itemProduct18;
    private com.mycompany.component.ItemProduct itemProduct19;
    private com.mycompany.component.ItemProduct itemProduct2;
    private com.mycompany.component.ItemProduct itemProduct3;
    private com.mycompany.component.ItemProduct itemProduct4;
    private com.mycompany.component.ItemProduct itemProduct6;
    private com.mycompany.component.ItemProduct itemProduct7;
    private com.mycompany.component.ItemProduct itemProduct8;
    private com.mycompany.component.ItemProduct itemProduct9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    // End of variables declaration//GEN-END:variables
}

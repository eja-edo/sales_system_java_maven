/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.component;

import java.awt.Color;

/**
 *
 * @author haidu
 */
public class Menu extends javax.swing.JPanel {

    
    Color DefaultColor,ClickedColor;
    
    public Menu() {
        initComponents();
         // Khởi tạo màu mặc định
    DefaultColor = new Color(255,255,255);
    ClickedColor = new Color(190,162,136);
    
    // Đặt màu mặc định cho tất cả menu
    menu1.setOpaque(true);
    menu2.setOpaque(true);
    menu3.setOpaque(true);
    menu4.setOpaque(true);
    menu5.setOpaque(true);
    menu6.setOpaque(true);
    menu7.setOpaque(true);
    menu8.setOpaque(true);
    
    menu1.setBackground(DefaultColor);
    menu2.setBackground(DefaultColor);
    menu3.setBackground(DefaultColor);
    menu4.setBackground(DefaultColor);
    menu5.setBackground(DefaultColor);
    menu6.setBackground(DefaultColor);
    menu7.setBackground(DefaultColor);
    menu8.setBackground(DefaultColor);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPanel();
        menu1 = new javax.swing.JPanel();
        lbl_tt = new javax.swing.JLabel();
        menu2 = new javax.swing.JPanel();
        lbl_ttc = new javax.swing.JLabel();
        menu3 = new javax.swing.JPanel();
        lbl_dh = new javax.swing.JLabel();
        menu4 = new javax.swing.JPanel();
        lbl_qt = new javax.swing.JLabel();
        menu5 = new javax.swing.JPanel();
        lbl_th = new javax.swing.JLabel();
        menu6 = new javax.swing.JPanel();
        lbl_bst = new javax.swing.JLabel();
        menu7 = new javax.swing.JPanel();
        lbl_ls = new javax.swing.JLabel();
        menu8 = new javax.swing.JPanel();
        lbl_khtt = new javax.swing.JLabel();

        Menu.setBackground(new java.awt.Color(255, 255, 255));
        Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu1.setBackground(java.awt.Color.white);
        menu1.setPreferredSize(new java.awt.Dimension(200, 60));
        menu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menu1MousePressed(evt);
            }
        });

        lbl_tt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_tt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/menu1.png"))); // NOI18N
        lbl_tt.setText("       Trang chủ");
        lbl_tt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ttMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_ttMousePressed(evt);
            }
        });

        javax.swing.GroupLayout menu1Layout = new javax.swing.GroupLayout(menu1);
        menu1.setLayout(menu1Layout);
        menu1Layout.setHorizontalGroup(
            menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbl_tt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menu1Layout.setVerticalGroup(
            menu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu1Layout.createSequentialGroup()
                .addComponent(lbl_tt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Menu.add(menu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 60));

        menu2.setBackground(java.awt.Color.white);
        menu2.setPreferredSize(new java.awt.Dimension(200, 60));
        menu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menu2MousePressed(evt);
            }
        });

        lbl_ttc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_ttc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/menu2.png"))); // NOI18N
        lbl_ttc.setText("       Trang sức cưới");
        lbl_ttc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_ttcMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_ttcMousePressed(evt);
            }
        });

        javax.swing.GroupLayout menu2Layout = new javax.swing.GroupLayout(menu2);
        menu2.setLayout(menu2Layout);
        menu2Layout.setHorizontalGroup(
            menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbl_ttc, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menu2Layout.setVerticalGroup(
            menu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu2Layout.createSequentialGroup()
                .addComponent(lbl_ttc, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Menu.add(menu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, -1, -1));

        menu3.setBackground(java.awt.Color.white);
        menu3.setPreferredSize(new java.awt.Dimension(200, 60));
        menu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menu3MousePressed(evt);
            }
        });

        lbl_dh.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_dh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/menu3.png"))); // NOI18N
        lbl_dh.setText("       Đồng hồ");
        lbl_dh.setAutoscrolls(true);
        lbl_dh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_dhMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_dhMousePressed(evt);
            }
        });

        javax.swing.GroupLayout menu3Layout = new javax.swing.GroupLayout(menu3);
        menu3.setLayout(menu3Layout);
        menu3Layout.setHorizontalGroup(
            menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbl_dh, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menu3Layout.setVerticalGroup(
            menu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu3Layout.createSequentialGroup()
                .addComponent(lbl_dh, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Menu.add(menu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 200, 60));

        menu4.setBackground(java.awt.Color.white);
        menu4.setPreferredSize(new java.awt.Dimension(200, 60));
        menu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menu4MousePressed(evt);
            }
        });

        lbl_qt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_qt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/menu4.png"))); // NOI18N
        lbl_qt.setText("       Quà tặng");
        lbl_qt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_qtMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_qtMousePressed(evt);
            }
        });

        javax.swing.GroupLayout menu4Layout = new javax.swing.GroupLayout(menu4);
        menu4.setLayout(menu4Layout);
        menu4Layout.setHorizontalGroup(
            menu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbl_qt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menu4Layout.setVerticalGroup(
            menu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu4Layout.createSequentialGroup()
                .addComponent(lbl_qt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Menu.add(menu4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 195, 200, 60));

        menu5.setBackground(java.awt.Color.white);
        menu5.setPreferredSize(new java.awt.Dimension(200, 60));
        menu5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menu5MousePressed(evt);
            }
        });

        lbl_th.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_th.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/menu5.png"))); // NOI18N
        lbl_th.setText("       Thương hiệu");
        lbl_th.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_thMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_thMousePressed(evt);
            }
        });

        javax.swing.GroupLayout menu5Layout = new javax.swing.GroupLayout(menu5);
        menu5.setLayout(menu5Layout);
        menu5Layout.setHorizontalGroup(
            menu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbl_th, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menu5Layout.setVerticalGroup(
            menu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu5Layout.createSequentialGroup()
                .addComponent(lbl_th, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Menu.add(menu5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 200, 60));

        menu6.setBackground(java.awt.Color.white);
        menu6.setPreferredSize(new java.awt.Dimension(200, 60));
        menu6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menu6MousePressed(evt);
            }
        });

        lbl_bst.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_bst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/menu6.png"))); // NOI18N
        lbl_bst.setText("       Bộ sưu tập");
        lbl_bst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_bstMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_bstMousePressed(evt);
            }
        });

        javax.swing.GroupLayout menu6Layout = new javax.swing.GroupLayout(menu6);
        menu6.setLayout(menu6Layout);
        menu6Layout.setHorizontalGroup(
            menu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbl_bst, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menu6Layout.setVerticalGroup(
            menu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu6Layout.createSequentialGroup()
                .addComponent(lbl_bst, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Menu.add(menu6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 325, 200, 60));

        menu7.setBackground(java.awt.Color.white);
        menu7.setPreferredSize(new java.awt.Dimension(200, 60));
        menu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menu7MousePressed(evt);
            }
        });

        lbl_ls.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_ls.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/menu7.png"))); // NOI18N
        lbl_ls.setText("       Livestream");
        lbl_ls.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_lsMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_lsMousePressed(evt);
            }
        });

        javax.swing.GroupLayout menu7Layout = new javax.swing.GroupLayout(menu7);
        menu7.setLayout(menu7Layout);
        menu7Layout.setHorizontalGroup(
            menu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbl_ls, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menu7Layout.setVerticalGroup(
            menu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menu7Layout.createSequentialGroup()
                .addComponent(lbl_ls, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Menu.add(menu7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 200, 60));

        menu8.setBackground(java.awt.Color.white);
        menu8.setPreferredSize(new java.awt.Dimension(200, 60));
        menu8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menu8MousePressed(evt);
            }
        });

        lbl_khtt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_khtt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/menu8.png"))); // NOI18N
        lbl_khtt.setText("       KHTT");
        lbl_khtt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_khttMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_khttMousePressed(evt);
            }
        });

        javax.swing.GroupLayout menu8Layout = new javax.swing.GroupLayout(menu8);
        menu8.setLayout(menu8Layout);
        menu8Layout.setHorizontalGroup(
            menu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbl_khtt, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menu8Layout.setVerticalGroup(
            menu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menu8Layout.createSequentialGroup()
                .addComponent(lbl_khtt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Menu.add(menu8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 455, 200, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_ttMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ttMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_ttMouseClicked

    private void lbl_ttMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ttMousePressed
       menu1.setBackground(ClickedColor);
    
    // Reset màu các menu khác về mặc định
    menu2.setBackground(DefaultColor);
    menu3.setBackground(DefaultColor);
    menu4.setBackground(DefaultColor);
    menu5.setBackground(DefaultColor);
    menu6.setBackground(DefaultColor);
    menu7.setBackground(DefaultColor);
    menu8.setBackground(DefaultColor);
    
    // Cập nhật giao diện
    menu1.revalidate();
    menu1.repaint();
    }//GEN-LAST:event_lbl_ttMousePressed

    private void menu1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu1MousePressed
        menu1.setBackground(ClickedColor);
    
    // Reset màu các menu khác về mặc định
    menu2.setBackground(DefaultColor);
    menu3.setBackground(DefaultColor);
    menu4.setBackground(DefaultColor);
    menu5.setBackground(DefaultColor);
    menu6.setBackground(DefaultColor);
    menu7.setBackground(DefaultColor);
    menu8.setBackground(DefaultColor);
    
    // Cập nhật giao diện
    menu1.revalidate();
    menu1.repaint();
    }//GEN-LAST:event_menu1MousePressed

    private void lbl_ttcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ttcMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_ttcMouseClicked

    private void lbl_ttcMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_ttcMousePressed
        menu1.setBackground(DefaultColor);
    
    // Reset màu các menu khác về mặc định
    menu2.setBackground(ClickedColor);
    menu3.setBackground(DefaultColor);
    menu4.setBackground(DefaultColor);
    menu5.setBackground(DefaultColor);
    menu6.setBackground(DefaultColor);
    menu7.setBackground(DefaultColor);
    menu8.setBackground(DefaultColor);
    
    // Cập nhật giao diện
    menu1.revalidate();
    menu1.repaint();
    }//GEN-LAST:event_lbl_ttcMousePressed

    private void menu2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu2MousePressed
         menu1.setBackground(DefaultColor);
    
    // Reset màu các menu khác về mặc định
    menu2.setBackground(ClickedColor);
    menu3.setBackground(DefaultColor);
    menu4.setBackground(DefaultColor);
    menu5.setBackground(DefaultColor);
    menu6.setBackground(DefaultColor);
    menu7.setBackground(DefaultColor);
    menu8.setBackground(DefaultColor);
    
    // Cập nhật giao diện
    menu1.revalidate();
    menu1.repaint();
    }//GEN-LAST:event_menu2MousePressed

    private void lbl_dhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_dhMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_dhMouseClicked

    private void lbl_dhMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_dhMousePressed
       menu1.setBackground(DefaultColor);
    
    // Reset màu các menu khác về mặc định
    menu2.setBackground(DefaultColor);
    menu3.setBackground(ClickedColor);
    menu4.setBackground(DefaultColor);
    menu5.setBackground(DefaultColor);
    menu6.setBackground(DefaultColor);
    menu7.setBackground(DefaultColor);
    menu8.setBackground(DefaultColor);
    
    // Cập nhật giao diện
    menu1.revalidate();
    menu1.repaint();
    }//GEN-LAST:event_lbl_dhMousePressed

    private void menu3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu3MousePressed
        menu1.setBackground(DefaultColor);
    
    // Reset màu các menu khác về mặc định
    menu2.setBackground(DefaultColor);
    menu3.setBackground(ClickedColor);
    menu4.setBackground(DefaultColor);
    menu5.setBackground(DefaultColor);
    menu6.setBackground(DefaultColor);
    menu7.setBackground(DefaultColor);
    menu8.setBackground(DefaultColor);
    
    // Cập nhật giao diện
    menu1.revalidate();
    menu1.repaint();
    }//GEN-LAST:event_menu3MousePressed

    private void lbl_qtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_qtMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_qtMouseClicked

    private void lbl_qtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_qtMousePressed
          menu1.setBackground(DefaultColor);
    
    // Reset màu các menu khác về mặc định
    menu2.setBackground(DefaultColor);
    menu3.setBackground(DefaultColor);
    menu4.setBackground(ClickedColor);
    menu5.setBackground(DefaultColor);
    menu6.setBackground(DefaultColor);
    menu7.setBackground(DefaultColor);
    menu8.setBackground(DefaultColor);
    
    // Cập nhật giao diện
    menu1.revalidate();
    menu1.repaint();
    }//GEN-LAST:event_lbl_qtMousePressed

    private void menu4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu4MousePressed
       menu1.setBackground(DefaultColor);
    
    // Reset màu các menu khác về mặc định
    menu2.setBackground(DefaultColor);
    menu3.setBackground(DefaultColor);
    menu4.setBackground(ClickedColor);
    menu5.setBackground(DefaultColor);
    menu6.setBackground(DefaultColor);
    menu7.setBackground(DefaultColor);
    menu8.setBackground(DefaultColor);
    
    // Cập nhật giao diện
    menu1.revalidate();
    menu1.repaint();
    }//GEN-LAST:event_menu4MousePressed

    private void lbl_thMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_thMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_thMouseClicked

    private void lbl_thMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_thMousePressed
        menu1.setBackground(DefaultColor);
    
    // Reset màu các menu khác về mặc định
    menu2.setBackground(DefaultColor);
    menu3.setBackground(DefaultColor);
    menu4.setBackground(DefaultColor);
    menu5.setBackground(ClickedColor);
    menu6.setBackground(DefaultColor);
    menu7.setBackground(DefaultColor);
    menu8.setBackground(DefaultColor);
    
    // Cập nhật giao diện
    menu1.revalidate();
    menu1.repaint();
    }//GEN-LAST:event_lbl_thMousePressed

    private void menu5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu5MousePressed
          menu1.setBackground(DefaultColor);
    
    // Reset màu các menu khác về mặc định
    menu2.setBackground(DefaultColor);
    menu3.setBackground(DefaultColor);
    menu4.setBackground(DefaultColor);
    menu5.setBackground(ClickedColor);
    menu6.setBackground(DefaultColor);
    menu7.setBackground(DefaultColor);
    menu8.setBackground(DefaultColor);
    
    // Cập nhật giao diện
    menu1.revalidate();
    menu1.repaint();
    }//GEN-LAST:event_menu5MousePressed

    private void lbl_bstMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_bstMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_bstMouseClicked

    private void lbl_bstMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_bstMousePressed
        menu1.setBackground(DefaultColor);
    
    // Reset màu các menu khác về mặc định
    menu2.setBackground(DefaultColor);
    menu3.setBackground(DefaultColor);
    menu4.setBackground(DefaultColor);
    menu5.setBackground(DefaultColor);
    menu6.setBackground(ClickedColor);
    menu7.setBackground(DefaultColor);
    menu8.setBackground(DefaultColor);
    
    // Cập nhật giao diện
    menu1.revalidate();
    menu1.repaint();
    }//GEN-LAST:event_lbl_bstMousePressed

    private void menu6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu6MousePressed
        menu1.setBackground(DefaultColor);
    
    // Reset màu các menu khác về mặc định
    menu2.setBackground(DefaultColor);
    menu3.setBackground(DefaultColor);
    menu4.setBackground(DefaultColor);
    menu5.setBackground(DefaultColor);
    menu6.setBackground(ClickedColor);
    menu7.setBackground(DefaultColor);
    menu8.setBackground(DefaultColor);
    
    // Cập nhật giao diện
    menu1.revalidate();
    menu1.repaint();
    }//GEN-LAST:event_menu6MousePressed

    private void lbl_lsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_lsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_lsMouseClicked

    private void lbl_lsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_lsMousePressed
        menu1.setBackground(DefaultColor);
    
    // Reset màu các menu khác về mặc định
    menu2.setBackground(DefaultColor);
    menu3.setBackground(DefaultColor);
    menu4.setBackground(DefaultColor);
    menu5.setBackground(DefaultColor);
    menu6.setBackground(DefaultColor);
    menu7.setBackground(ClickedColor);
    menu8.setBackground(DefaultColor);
    
    // Cập nhật giao diện
    menu1.revalidate();
    menu1.repaint();
    }//GEN-LAST:event_lbl_lsMousePressed

    private void menu7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu7MousePressed
        menu1.setBackground(DefaultColor);
    
    // Reset màu các menu khác về mặc định
    menu2.setBackground(DefaultColor);
    menu3.setBackground(DefaultColor);
    menu4.setBackground(DefaultColor);
    menu5.setBackground(DefaultColor);
    menu6.setBackground(DefaultColor);
    menu7.setBackground(ClickedColor);
    menu8.setBackground(DefaultColor);
    
    // Cập nhật giao diện
    menu1.revalidate();
    menu1.repaint();
    }//GEN-LAST:event_menu7MousePressed

    private void lbl_khttMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_khttMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_khttMouseClicked

    private void lbl_khttMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_khttMousePressed
         menu1.setBackground(DefaultColor);
    
    // Reset màu các menu khác về mặc định
    menu2.setBackground(DefaultColor);
    menu3.setBackground(DefaultColor);
    menu4.setBackground(DefaultColor);
    menu5.setBackground(DefaultColor);
    menu6.setBackground(DefaultColor);
    menu7.setBackground(DefaultColor);
    menu8.setBackground(ClickedColor);
    
    // Cập nhật giao diện
    menu1.revalidate();
    menu1.repaint();
    }//GEN-LAST:event_lbl_khttMousePressed

    private void menu8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu8MousePressed
        menu1.setBackground(DefaultColor);
    
    // Reset màu các menu khác về mặc định
    menu2.setBackground(DefaultColor);
    menu3.setBackground(DefaultColor);
    menu4.setBackground(DefaultColor);
    menu5.setBackground(DefaultColor);
    menu6.setBackground(DefaultColor);
    menu7.setBackground(DefaultColor);
    menu8.setBackground(ClickedColor);
    
    // Cập nhật giao diện
    menu1.revalidate();
    menu1.repaint();
    }//GEN-LAST:event_menu8MousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Menu;
    public static javax.swing.JLabel lbl_bst;
    public static javax.swing.JLabel lbl_dh;
    public static javax.swing.JLabel lbl_khtt;
    public static javax.swing.JLabel lbl_ls;
    public static javax.swing.JLabel lbl_qt;
    public static javax.swing.JLabel lbl_th;
    public static javax.swing.JLabel lbl_tt;
    public static javax.swing.JLabel lbl_ttc;
    public static javax.swing.JPanel menu1;
    public static javax.swing.JPanel menu2;
    public static javax.swing.JPanel menu3;
    public static javax.swing.JPanel menu4;
    public static javax.swing.JPanel menu5;
    public static javax.swing.JPanel menu6;
    public static javax.swing.JPanel menu7;
    public static javax.swing.JPanel menu8;
    // End of variables declaration//GEN-END:variables
}

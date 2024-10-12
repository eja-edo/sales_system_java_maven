/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.component;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
/**
 *
 * @author duyan
 */
public class ItemProduct extends javax.swing.JPanel {
    private int radius = 10;  // Đặt bán kính cho bo tròn

    public ItemProduct() {
        initComponents();
 
        
        imgProduct.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                scaleImg();
            }
        });

        // Thêm văn bản vào JTextPane
        StyledDocument doc = jtitle.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D g2d = (Graphics2D) g.create();

        // Chống răng cưa để làm mịn đường viền bo tròn
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Vẽ hình chữ nhật với các góc bo tròn
        g2d.setColor(getBackground()); // Đặt màu nền cho JPanel (có thể thay đổi nếu muốn)
        g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), radius, radius));

        g2d.dispose();
    }
    
    
    
    
     public void scaleImg() {
    try {
        // Tải hình ảnh từ URL
        URL url = new URL("https://placehold.co/259X259/png");  // Đảm bảo URL hợp lệ
        Image img = ImageIO.read(url);  // Sử dụng ImageIO để tải hình ảnh từ URL
        
        // Kiểm tra nếu hình ảnh được tải thành công
        if (img != null) {
            // Kiểm tra kích thước imgProduct trước khi thay đổi kích thước hình ảnh
            if (imgProduct.getWidth() > 0 && imgProduct.getHeight() > 0) {
                // Thay đổi kích thước hình ảnh theo kích thước hiện tại của imgProduct
                Image imgScale = img.getScaledInstance(imgProduct.getWidth(), imgProduct.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imgIcon = new ImageIcon(imgScale);
                
                // Đặt hình ảnh đã thay đổi kích thước làm icon cho imgProduct
                imgProduct.setIcon(imgIcon);
            }
        } else {
            System.out.println("Error: Image could not be loaded from the URL.");
        }
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Error loading image: " + e.getMessage());
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
        imgProduct = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtitle = new javax.swing.JTextPane();
        rating = new javax.swing.JLabel();
        views = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setFocusable(false);
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(260, 394));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
<<<<<<< HEAD
=======
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/rsz_tragop.png"))); // NOI18N
>>>>>>> c8154a75e44bc6fe8eb0f7940a80a745ff968593
        jLabel1.setRequestFocusEnabled(false);
        jLabel1.setVerifyInputWhenFocusTarget(false);
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 31, 35));

        imgProduct.setBackground(new java.awt.Color(102, 102, 102));
        add(imgProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 260));

        price.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        price.setForeground(new java.awt.Color(197, 142, 74));
        price.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        price.setText("43.000.000đ");
        price.setToolTipText("");
        add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 317, 259, 18));

        jLabel3.setForeground(new java.awt.Color(234, 112, 112));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Quà tặng trang sức");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 259, -1));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);

        jtitle.setEditable(false);
        jtitle.setBackground(new java.awt.Color(255, 255, 255));
        jtitle.setBorder(null);
        jtitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtitle.setText("Bông tai Kim cương Vàng trắng 14K PNJ DDDDW000176");
        jtitle.setAutoscrolls(false);
        jtitle.setFocusable(false);
        jScrollPane2.setViewportView(jtitle);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 265, 259, 46));

        rating.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
<<<<<<< HEAD
=======
        rating.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/rsz_1star.png"))); // NOI18N
>>>>>>> c8154a75e44bc6fe8eb0f7940a80a745ff968593
        rating.setText("5(10)");
        add(rating, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 374, 45, 13));

        views.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        views.setText("10k");
        add(views, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 373, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imgProduct;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jtitle;
    private javax.swing.JLabel price;
    private javax.swing.JLabel rating;
    private javax.swing.JLabel views;
    // End of variables declaration//GEN-END:variables
}

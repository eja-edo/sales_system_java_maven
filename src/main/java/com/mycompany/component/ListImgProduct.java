/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.component;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;






public class ListImgProduct extends javax.swing.JPanel {

    private DefaultListModel<String> imageListModel;

    // Constructor where you can pass a list of image file paths
    public ListImgProduct() {
        initComponents();
        imageListModel = new DefaultListModel<>();
        jList1.setModel(imageListModel);
        jList1.setCellRenderer((ListCellRenderer<? super String>) new ImageListRenderer());
        
        for (int i = 1; i <= 10; i++) {
            String imageUrl = "https://placehold.co/76x76/png/"; // Tạo các liên kết
            addImage(imageUrl);
        }
    }

    // Method to add an image URL to the list
    public void addImage(String imagePath) {
        imageListModel.addElement(imagePath);
    }

    // Method to add multiple image URLs to the list
    public void addImages(List<String> imagePaths) {
        for (String imagePath : imagePaths) {
            imageListModel.addElement(imagePath);
        }
    }

    // Custom ListCellRenderer for the JList to display rounded images
    private class ImageListRenderer extends JLabel implements ListCellRenderer<String> {

        @Override
        public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {
            BufferedImage image = null;
            try {
                image = ImageIO.read(new URL(value));
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (image != null) {
                // Convert the image to a rounded one
                ImageIcon roundedIcon = new ImageIcon(getRoundedImage(image, 10)); // Radius of 10px
                setIcon(roundedIcon);
            } else {
                setIcon(null); // No image found, set icon to null
            }

//            if (isSelected) {
//                setBackground();
//                setOpaque(true);  // Hiển thị nền khi chọn
//            } else {
//                setBackground(list.getBackground());
//                setOpaque(false);  // Ẩn nền khi không chọn
//            }


            // Set padding/margin between images
            setBorder(BorderFactory.createEmptyBorder(0, 1, 10, 1));

            // Set preferred size to ensure enough space for images
            setPreferredSize(new Dimension(78, 86)); // Adjust based on your needs
            return this;
        }

        // Method to create rounded corners for the image
        private BufferedImage getRoundedImage(BufferedImage image, int radius) {
            int w = image.getWidth();
            int h = image.getHeight(); 
            BufferedImage roundedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2 = roundedImage.createGraphics();
            g2.setComposite(AlphaComposite.Src);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(Color.WHITE); // Background color, if necessary
            g2.fill(new RoundRectangle2D.Float(0, 0, w, h, radius, radius));
            g2.setComposite(AlphaComposite.SrcAtop);
            g2.drawImage(image, 0, 0, null);
            g2.dispose();

            return roundedImage;
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(78, 460));
        setMinimumSize(new java.awt.Dimension(78, 76));
        setPreferredSize(new java.awt.Dimension(78, 460));
        setLayout(new java.awt.BorderLayout());

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/rsz_up-arrow.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        add(jButton1, java.awt.BorderLayout.PAGE_START);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/rsz_down-arrow.png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        add(jButton2, java.awt.BorderLayout.PAGE_END);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 10, 0));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setMaximumSize(new java.awt.Dimension(78, 420));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(78, 420));
        jScrollPane2.setName(""); // NOI18N
        jScrollPane2.setPreferredSize(new java.awt.Dimension(78, 420));

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setAutoscrolls(false);
        jScrollPane2.setViewportView(jList1);

        add(jScrollPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

package com.mycompany.test;

import java.awt.Dimension;
import javax.swing.ImageIcon;

public class TestForm1 extends javax.swing.JFrame {
    
    public TestForm1() {
        initComponents();
    }
    
    private void initComponents() {
        resizableImageLabel2 = new com.mycompany.swing.ResizableImageLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        
        // Đặt ảnh vào JLabel
        ImageIcon icon = new ImageIcon(getClass().getResource("/thekhachhang.jpg"));
        resizableImageLabel2.setIcon(icon);
        
        // Cập nhật lại kích thước của JLabel theo ảnh
        int imageWidth = icon.getIconWidth();
        int imageHeight = icon.getIconHeight();
        resizableImageLabel2.setPreferredSize(new Dimension(100, 100));

        getContentPane().add(resizableImageLabel2);
        resizableImageLabel2.setBounds(106, 74, imageWidth, imageHeight);
        
        pack();  // Cập nhật layout
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestForm2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private com.mycompany.swing.ResizableImageLabel resizableImageLabel2;
    // End of variables declaration                   
}
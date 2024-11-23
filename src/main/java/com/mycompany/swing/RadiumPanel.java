/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.swing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.Serializable;
import javax.swing.JPanel;

public class RadiumPanel extends JPanel implements Serializable {
    private int radium = 15; // Giá trị mặc định

    // Constructor
    public RadiumPanel() {
        initComponents();
        setOpaque(false); // Để hiển thị nền trong suốt
    }

    // Getter và Setter cho radium
    public int getRadium() {
        return radium;
    }

    public void setRadium(int radium) {
        if (radium < 0) { // Đảm bảo radium >= 0
            throw new IllegalArgumentException("Radium must be >= 0");
        }
        this.radium = radium;
        repaint(); // Cập nhật giao diện khi thay đổi radium
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Vẽ panel với góc bo tròn
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radium, radium);

        super.paintComponent(grphcs); // Vẽ các thành phần con
    }

    // Phương thức khởi tạo tự động (tùy vào IDE có thể giữ hoặc chỉnh sửa)
    private void initComponents() {
        // IDE có thể tạo tự động nội dung cho phương thức này
    }
}
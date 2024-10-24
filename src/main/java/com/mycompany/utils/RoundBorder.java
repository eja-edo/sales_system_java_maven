
package com.mycompany.utils;

import javax.swing.border.AbstractBorder;
import java.awt.*;

public class RoundBorder extends AbstractBorder {
    private Color color;
    private int radius;
    private int stroke;

    public RoundBorder(Color color, int radius , int stroke) {
        this.color = color;
        this.radius = radius;
        this.stroke = stroke;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height ) {
        Graphics2D g2 = (Graphics2D) g.create(); // Tạo bản sao đồ họa để tránh thay đổi toàn cục
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Bật làm mịn
        g2.setColor(color);
        g2.setStroke(new BasicStroke(stroke)); // Độ dày của viền
        g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        g2.dispose(); // Giải phóng tài nguyên
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(10, 10, 10, 10); // Khoảng cách giữa nội dung và đường viền
    }
}
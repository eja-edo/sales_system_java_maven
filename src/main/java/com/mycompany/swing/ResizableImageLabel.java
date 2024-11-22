package com.mycompany.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ResizableImageLabel extends JLabel {
    private Image originalImage;

    public ResizableImageLabel() {
        setHorizontalAlignment(CENTER); // Đảm bảo ảnh nằm giữa
    }

    public ResizableImageLabel(Image image) {
        this.originalImage = image;
        setHorizontalAlignment(CENTER); // Đảm bảo ảnh nằm giữa
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawResizedImage(g);
    }

    private void drawResizedImage(Graphics g) {
        int labelWidth = getWidth();
        int labelHeight = getHeight();

        if (labelWidth > 0 && labelHeight > 0) {
            // Lấy kích thước gốc của ảnh
            int originalWidth = originalImage.getWidth(null);
            int originalHeight = originalImage.getHeight(null);

            // Tính toán kích thước mới để chiều ngang đầy khung và giữ tỉ lệ
            float aspectRatio = (float) originalHeight / originalWidth;
            int newHeight = (int) (labelWidth * aspectRatio);
            setPreferredSize(new Dimension(labelWidth, newHeight));
            revalidate();
            repaint();
            // Căn giữa ảnh theo chiều dọc nếu cần
            int yOffset = (labelHeight - newHeight) / 2;
            
            g.drawImage(originalImage, 0, yOffset, labelWidth, newHeight, this);
        }
    }

    public void setImage(Image image) {
        this.originalImage = image;
        repaint();
        revalidate(); // Cập nhật lại kích thước của JLabel
    }

    // Phương thức tự động gọi khi setIcon
    @Override
    public void setIcon(Icon icon) {
        super.setIcon(null); // Đảm bảo JLabel vẫn lưu trữ Icon nếu cần
        if (icon != null) {
            setImageFromIcon(icon); // Tự động cập nhật originalImage
        }
    }

    // Phương thức chuyển Icon thành Image
    public void setImageFromIcon(Icon icon) {
        if (icon instanceof ImageIcon) {
            this.originalImage = ((ImageIcon) icon).getImage();
        } else {
            int width = icon.getIconWidth();
            int height = icon.getIconHeight();
            Image img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics g = img.getGraphics();
            icon.paintIcon(null, g, 0, 0);
            g.dispose();
            this.originalImage = img;
        }
        repaint(); // Vẽ lại ảnh
        revalidate(); // Cập nhật lại kích thước của JLabel
    }
}
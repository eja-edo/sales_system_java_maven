/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.component;

import com.mycompany.utils.RoundBorder;
import static com.mycompany.utils.resizeIcon.resizeIcon;
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
import java.util.HashMap;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;






public class ListImgProduct extends javax.swing.JPanel {
    private DefaultListModel<String> imageListModel;
    private ImageSelectionListener imageSelectionListener; // Thêm biến để lắng nghe sự thay đổi chọn
    private HashMap<String, BufferedImage> imageCache = new HashMap<>(); // Bộ nhớ đệm hình ảnh
    // Constructor
    public ListImgProduct() {
        initComponents();
        imageListModel = new DefaultListModel<>();
        jList1.setModel(imageListModel);
        jList1.setCellRenderer(new ImageListRenderer());

        // Đăng ký ListSelectionListener để lắng nghe thay đổi khi chọn mục trong JList
        jList1.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) { // Đảm bảo chỉ khi thay đổi cuối cùng
                int selectedIndex = jList1.getSelectedIndex();
                System.out.println(selectedIndex);
                if (selectedIndex != -1 && imageSelectionListener != null && imageListModel.size()>0) {
                    // Lấy imagePath từ danh sách và gửi đến panel lớn hơn
                    String selectedImagePath = imageListModel.getElementAt(selectedIndex);
                    imageSelectionListener.onImageSelected(selectedImagePath);
                }
            }
        });

    }

    // Phương thức để thêm hình ảnh vào danh sách
    public void addImage(String imagePath) {
        imageListModel.addElement(imagePath);
    }

    // Phương thức để thêm nhiều hình ảnh vào danh sách
    public void addImages(List<String> imagePaths) {
        imageListModel.removeAllElements();
        for (String imagePath : imagePaths) {
            imageListModel.addElement(imagePath);
        }
    }

    public void setSelectedIndex(int i) {
        jList1.setSelectedIndex(i);
    }

    
    // Phương thức để đăng ký listener từ panel ngoài
    public void setImageSelectionListener(ImageSelectionListener listener) {
        this.imageSelectionListener = listener;
    }

    // Custom ListCellRenderer for the JList to display rounded images
//    private class ImageListRenderer extends JLabel implements ListCellRenderer<String> {
//        @Override
//        public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {
//            BufferedImage image = null;
//            try {
//                // Tải hình ảnh từ resources
//                URL imageUrl = getClass().getResource(value); // Dùng đường dẫn tương đối từ thư mục resources
//                if (imageUrl != null) {
//                    image = ImageIO.read(imageUrl);
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            if (image != null) {
//                image = resizeIcon(image, 76, 76);
//                // Convert the image to a rounded one
//                BufferedImage roundedImage = getRoundedImage(image, 10); // Radius of 10px
//                if (isSelected) {
//                    // Vẽ đường viền bo tròn lên hình ảnh khi được chọn
//                    roundedImage = drawRoundedBorder(roundedImage, 10, Color.GRAY, 1);
//                }
//                setIcon(new ImageIcon(roundedImage));
//            } else {
//                setIcon(null); // No image found, set icon to null
//            }
//
//            // Điều chỉnh kích thước của phần tử
//            setPreferredSize(new Dimension(78, 86)); // Điều chỉnh chiều cao và chiều rộng mỗi phần tử
//
//            return this;
//        }

    private class ImageListRenderer extends JLabel implements ListCellRenderer<String> {
        @Override
        public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {
            BufferedImage image = getImageFromCache(value);
            if (image == null) {
                image = loadImage(value);
                if (image != null) {
                    image = resizeIcon(image, 76, 76); // Resize once
                    image = getRoundedImage(image, 10); // Apply rounded corners
                    cacheImage(value, image); // Save to cache for reuse
                }
            }
        // Tạo bản sao của ảnh đã lưu trong bộ nhớ đệm để vẽ viền lên
        if (image != null) {
            BufferedImage imageWithBorder = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = imageWithBorder.createGraphics();
            g2.drawImage(image, 0, 0, null); // Vẽ ảnh đã thu nhỏ và bo viền vào bản sao
            g2.dispose();
            
            // Vẽ viền cho bản sao nếu cần
            if (isSelected) {
                imageWithBorder = drawRoundedBorder(imageWithBorder, 10, Color.GRAY, 1); // Vẽ viền khi được chọn
            } else {
                imageWithBorder = drawRoundedBorder(imageWithBorder, 10, Color.WHITE, 0); // Không vẽ viền nếu không được chọn
            }
            
            setIcon(new ImageIcon(imageWithBorder)); // Hiển thị ảnh đã vẽ viền
        } else {
            setIcon(null); // Nếu không có ảnh, bỏ qua
        }
        
        setPreferredSize(new Dimension(78, 86)); // Điều chỉnh kích thước cho phần tử
        return this;
        }
            
        private BufferedImage loadImage(String imagePath) {
                BufferedImage image = null;
                try {
                    URL imageUrl = getClass().getResource(imagePath);
                    if (imageUrl != null) {
                        image = ImageIO.read(imageUrl);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return image;
            }

        private BufferedImage getImageFromCache(String imagePath) {
                return imageCache.get(imagePath); // Trả về hình ảnh nếu đã có trong bộ nhớ đệm
            }

        private void cacheImage(String imagePath, BufferedImage image) {
                imageCache.put(imagePath, image); // Lưu hình ảnh vào bộ nhớ đệm
            }        

            // Phương thức để tạo hình ảnh bo tròn
            private BufferedImage getRoundedImage(BufferedImage image, int radius) {
                int w = image.getWidth();
                int h = image.getHeight(); 
                BufferedImage roundedImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2 = roundedImage.createGraphics();
                g2.setComposite(AlphaComposite.Src);
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(Color.WHITE); // Màu nền, có thể thay đổi nếu cần
                g2.fill(new RoundRectangle2D.Float(0, 0, w, h, radius, radius));
                g2.setComposite(AlphaComposite.SrcAtop);
                g2.drawImage(image, 0, 0, null);
                g2.dispose();
                return roundedImage;
            }

            // Phương thức để vẽ đường viền bo tròn lên hình ảnh
            private BufferedImage drawRoundedBorder(BufferedImage image, int radius, Color color, int thickness) {
                int w = image.getWidth();
                int h = image.getHeight(); 
                Graphics2D g2 = image.createGraphics();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(color);
                g2.setStroke(new java.awt.BasicStroke(thickness));
                g2.drawRoundRect(0, 0, w - 1, h - 1, radius, radius);  // Vẽ đường viền bo tròn lên hình ảnh
                g2.dispose();
                return image;
            }
    }

    // Interface để gửi thông tin hình ảnh được chọn
    public interface ImageSelectionListener {
        void onImageSelected(String imagePath);  // Phương thức sẽ gọi khi chọn một hình ảnh
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

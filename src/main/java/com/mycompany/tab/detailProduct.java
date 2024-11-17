/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.tab;

import com.mycompany.utils.RoundBorder;
import static com.mycompany.utils.ScaleImg.scaleImg;
import static com.mycompany.utils.resizeIcon.resizeIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import javax.swing.text.html.HTMLEditorKit;


class IconText {
    private String text;
    private Icon icon;

    public IconText(String text, Icon icon) {
        this.text = text;
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public Icon getIcon() {
        return icon;
    }

    @Override
    public String toString() {
        return text; // Để hiển thị text trong JComboBox
    }
}

class IconTextRenderer extends BasicComboBoxRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof IconText) {
            IconText iconText = (IconText) value;
            label.setText(iconText.getText());
            label.setIcon(iconText.getIcon());
            
            label.setHorizontalTextPosition(SwingConstants.LEFT);
            label.setVerticalTextPosition(SwingConstants.CENTER);
            label.setIconTextGap(3); // Khoảng cách giữa text và icon
        }
        
        // Áp dụng màu nền và màu chữ khi được chọn hoặc di chuột vào
        if (isSelected) {
            label.setBackground(new java.awt.Color(102, 51, 255));
            label.setForeground(list.getSelectionForeground());
        } else {
            label.setBackground(list.getBackground());
            label.setForeground(list.getForeground());
        }
        
        // Đảm bảo JLabel hoạt động trong suốt để màu nền hiển thị đúng
        label.setOpaque(true);
        
        
        return label;
    }
}



public class detailProduct extends javax.swing.JPanel {

    /**
     * Creates new form detailProduct
     */
    public detailProduct() {
        initComponents();
        
        // Đăng ký ImageSelectionListener để nhận imagePath
        listImgProduct.setImageSelectionListener(imagePath -> {
            System.out.println("Hình ảnh đã chọn: " + imagePath);
            // Thực hiện hành động khi chọn hình ảnh (ví dụ: hiển thị hình ảnh)
            showSelectedImage(imagePath);
        });
        for (int i = 1; i <= 10; i++) {
            String imageUrl = "/image/png76X76.png"; // Tạo các liên kết
            listImgProduct.addImage(imageUrl);
        }
        listImgProduct.setSelectedIndex(0);
        
        IconText[] items = {
        new IconText("5", new ImageIcon(getClass().getResource("/icon/rsz_1star.png"))),
        new IconText("4", new ImageIcon(getClass().getResource("/icon/rsz_1star.png"))),
        new IconText("3", new ImageIcon(getClass().getResource("/icon/rsz_1star.png"))),
        new IconText("2", new ImageIcon(getClass().getResource("/icon/rsz_1star.png"))),
        new IconText("1", new ImageIcon(getClass().getResource("/icon/rsz_1star.png")))
        };
        
        for (IconText item : items) {
            ComboStart.addItem(item);
        }
        
        ComboStart.setRenderer(new IconTextRenderer()); // Thiết lập renderer
    }

        // Phương thức để hiển thị hình ảnh đã chọn
    private void showSelectedImage(String imagePath) {
        try {
            BufferedImage image = ImageIO.read(getClass().getResource(imagePath));
            ImageIcon icon = new ImageIcon(image);
            imgMain.setIcon(resizeIcon(icon,470,470));
            scaleImg(imgMain);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listOffer = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        button1 = new com.mycompany.swing.Button();
        jPanel6 = new javax.swing.JPanel();
        button2 = new com.mycompany.swing.Button();
        button3 = new com.mycompany.swing.Button();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        listImgProduct = new com.mycompany.component.ListImgProduct();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        imgMain = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        button21 = new com.raven.swing.Button2();
        ComboStart = new com.mycompany.swing.ComboBoxSuggestion();
        button22 = new com.raven.swing.Button2();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 20));

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 20)); // NOI18N
        jLabel11.setText("Đánh giá từ khách hàng");

        jLabel12.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 30)); // NOI18N
        jLabel12.setText("5.0");
        jLabel12.setToolTipText("");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel13.setText("Tổng cộng 5 đánh giá từ khách hàng");

        jSplitPane1.setDividerSize(0);
        jSplitPane1.setResizeWeight(0.7);

        jPanel4.setOpaque(false);

        jLabel3.setBackground(new java.awt.Color(0, 52, 104));
        jLabel3.setForeground(new java.awt.Color(0, 52, 104));
        jLabel3.setOpaque(true);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("(Giá của sản phẩm thay đổi tùy theo trong lượng vàng và đá)");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("2000+ đã bán");

        jLabel5.setText("GNXMXMW005481");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(new RoundBorder(Color.BLACK, 20, 1), "Ưu đãi:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP));
        jScrollPane2.setOpaque(false);

        listOffer.setBorder(new RoundBorder(Color.BLACK, 20, 1));
        listOffer.setEnabled(false);
        listOffer.setOpaque(false);
        jScrollPane2.setViewportView(listOffer);

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextPane1.setEditable(false);
        jTextPane1.setBorder(null);
        jTextPane1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jTextPane1.setForeground(new java.awt.Color(0, 52, 104));
        jTextPane1.setText("Nhẫn Vàng trắng 14K Đính đá ECZ DAL XMXMW005481");
        jScrollPane1.setViewportView(jTextPane1);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/rsz_1star.png"))); // NOI18N
        jLabel6.setText("(0)");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 52, 104));
        jLabel8.setText("<html>8.203.000 <u>đ</u></html>");

        jLabel4.setText("Mã:");

        button1.setBackground(new java.awt.Color(173, 42, 54));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("<html><center>Mua ngay</center><i><p style =\"font-size :8px\">(Giao hàng miến phí tận nhà hoặc tại của hàng)<p></i></html>");
        button1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jPanel6.setLayout(new java.awt.GridLayout(1, 0, 3, 0));

        button2.setBackground(new java.awt.Color(0, 52, 104));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("Thêm vào giỏ hàng");
        button2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        button2.setPreferredSize(new java.awt.Dimension(42, 21));
        jPanel6.add(button2);

        button3.setBackground(new java.awt.Color(0, 52, 104));
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setText("Gọi ngay (miễn phí)");
        button3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jPanel6.add(button3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button1)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(38, 38, 38)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(412, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(jPanel4);

        jPanel7.setOpaque(false);

        jPanel8.setMaximumSize(new java.awt.Dimension(700, 600));
        jPanel8.setPreferredSize(new java.awt.Dimension(557, 450));
        jPanel8.setLayout(new java.awt.BorderLayout());
        jPanel8.add(listImgProduct, java.awt.BorderLayout.LINE_START);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(450, 450));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(0, 52, 104));
        jLabel2.setText("icon");
        jLabel2.setOpaque(true);
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 40, 40));

        imgMain.setText("      hình ảnh sản phẩm");
        jPanel3.add(imgMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 460));

        jPanel8.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        jButton2.setText("<html>chính sách hậu mãi</html>");
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jPanel5.add(jButton2);

        jButton3.setText("<html>Mô tả sản phẩm</html>");
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jPanel5.add(jButton3);

        jButton4.setText("<html>Câu hỏi thường gặp</html>");
        jButton4.setBorder(null);
        jButton4.setContentAreaFilled(false);
        jPanel5.add(jButton4);

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 5, 5));
        jTextPane2.setEditorKit(new HTMLEditorKit());
        jTextPane2.setText("<b>Miễn phí bảo hành 6 tháng</b><br>\n     • Bảo hành 6 tháng lỗi kỹ thuật, nước xi.<br>\n<b>Miễn phí siêu âm và đánh bóng bằng máy chuyên dụng trọn đời</b><br>\n     • Đối với sản phẩm bị oxy hóa, xuống màu, sẽ được siêu âm làm sạch bằng máy chuyên dụng (siêu âm, không xi) miễn phí trọn đời tại cửa hàng.<br>\n     • Miễn phí đánh bóng, siêu âm trọn đời.<br>\n     • Đối với nhẫn cưới được làm mới, đánh bóng, xi miễn phí trọn đời.<br>\n<b>Miễn phí thay đá ECZ, CZ và đá tổng hợp</b><br>\n     • Miễn phí thay đá tổng hợp, ECZ và CZ trong suốt thời gian bảo hành.<br>\n<b>Không áp dụng bảo hành cho các trường hợp sau:</b><br>\n     • Dây chuyển, lắc chế tác bị đứt gãy.<br>\n     • Sản phẩm bị lỗi do tác động bên ngoài, do quá trình sử dụng hoặc sử dụng không đúng cách dẫn đến sản phẩm bị biến dạng hoặc hư hỏng.<br>\n     • Không bảo hành kiếng, vòng, nữ trang 22K, 24K, dây chuyển, dây cổ chế tác, lắc chế tác bị đứt, gãy và sản phẩm bị lỗi do tác động bên ngoài.<br>\n     • Khách hàng cung cấp thông tin truy lục hóa đơn không chính xác.<br>\n<b>Lưu ý về chính sách bảo hành:</b><br>\n     • PNJ bảo hành các sản phẩm thuộc hệ thống cửa hàng kênh lẻ và online của PNJ.<br>\n     • Chế độ bảo hành sản phẩm có thể thay đổi theo chính sách của PNJ đối với các dòng hàng và chương trình khuyến mãi vào từng thời điểm.<br>\n     • Xem thông tin chi tiết về chính sách bảo hành vui lòng truy cập tại đây.<br>");
        jScrollPane3.setViewportView(jTextPane2);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 38, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanel7);

        button21.setBackground(new java.awt.Color(204, 204, 204));
        button21.setBorder(new RoundBorder(new Color(153,153,153),10,1));
        button21.setText("Có hình ảnh/ video");
        button21.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        button21.setRadium(10);

        ComboStart.setBorder(new RoundBorder(new Color(153,153,153),10,1));
        ComboStart.setEditable(false);

        button22.setBackground(new java.awt.Color(204, 204, 204));
        button22.setBorder(new RoundBorder(new Color(153,153,153),10,1));
        button22.setText("Tất cả đánh giá");
        button22.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        button22.setRadium(10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 903, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button22, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button21, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ComboStart, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(907, 907, 907)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button21, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button22, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel13))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 873, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(606, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.swing.ComboBoxSuggestion ComboStart;
    private com.mycompany.swing.Button button1;
    private com.mycompany.swing.Button button2;
    private com.raven.swing.Button2 button21;
    private com.raven.swing.Button2 button22;
    private com.mycompany.swing.Button button3;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel imgMain;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private com.mycompany.component.ListImgProduct listImgProduct;
    private javax.swing.JList<String> listOffer;
    // End of variables declaration//GEN-END:variables
}

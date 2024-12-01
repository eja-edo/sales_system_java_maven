
package com.mycompany.component;

<<<<<<< HEAD
import com.mycompany.model.entity.ItemProductEntity;

import com.mycompany.utils.ScaleImg;
import static com.mycompany.utils.resizeIcon.resizeIcon;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author duyan
 */
public class ItemProduct extends javax.swing.JPanel {
    private int radius = 10;  // Đặt bán kính cho bo tròn

    public void setItemProduct(String urlImgProduct, String title, String price, String views, String rating   ) 
    {
        //            URL url = new URL( urlImgProduct );  // Đảm bảo URL hợp lệ
//            Image img = ImageIO.read(url);  // Sử dụng ImageIO để 
//            ImageIcon imgIcon = new ImageIcon(img);
        imgProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlImgProduct)));
        ScaleImg.scaleImg(imgProduct);
        jtitle.setText(title);
        jprice.setText(price);
        jrating.setText(rating);
        jviews.setText(views);
        
    }

    
    public ItemProduct() {
        initComponents();

        TraGop.setIcon(resizeIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/traGop.png")),31,35));
        imgProduct.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                ScaleImg.scaleImg(imgProduct);
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
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TraGop = new javax.swing.JLabel();
        imgProduct = new javax.swing.JLabel();
        jprice = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtitle = new javax.swing.JTextPane();
        jrating = new javax.swing.JLabel();
        jviews = new javax.swing.JLabel();

        setBackground(new java.awt.Color(248, 248, 248));
        setFocusable(false);
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(260, 394));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TraGop.setBackground(new java.awt.Color(255, 255, 255));
        TraGop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/traGop.png"))); // NOI18N
        TraGop.setRequestFocusEnabled(false);
        TraGop.setVerifyInputWhenFocusTarget(false);
        add(TraGop, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 31, 35));

        imgProduct.setBackground(new java.awt.Color(102, 102, 102));
        imgProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/png259X259.png"))); // NOI18N
        add(imgProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 260));

        jprice.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jprice.setForeground(new java.awt.Color(197, 142, 74));
        jprice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jprice.setText("43.000.000đ");
        jprice.setToolTipText("");
        add(jprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 317, 260, 18));

        jLabel3.setForeground(new java.awt.Color(234, 112, 112));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Quà tặng trang sức");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 259, -1));

        jtitle.setEditable(false);
        jtitle.setBackground(new java.awt.Color(248, 248, 248));
        jtitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 1, 1, 1));
        jtitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jtitle.setText("Bông tai Kim cương Vàng trắng 14K PNJ DDDDW000176");
        jtitle.setAutoscrolls(false);
        jtitle.setFocusable(false);
        jtitle.setOpaque(false);
        add(jtitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 260, 50));

        jrating.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jrating.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/rsz_1star.png"))); // NOI18N
        jrating.setText("5(10)");
        add(jrating, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 374, 45, 13));

        jviews.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jviews.setText("10k");
        add(jviews, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 373, 30, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TraGop;
    private javax.swing.JLabel imgProduct;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jprice;
    private javax.swing.JLabel jrating;
    private javax.swing.JTextPane jtitle;
    private javax.swing.JLabel jviews;
    // End of variables declaration//GEN-END:variables

}

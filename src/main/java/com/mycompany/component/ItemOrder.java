/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.component;

import com.mycompany.model.entity.ProductDetail;
import com.mycompany.utils.Formatter;
import static com.mycompany.utils.Formatter.formatPrice;
import static com.mycompany.utils.Formatter.parsePrice;
import static com.mycompany.utils.resizeIcon.resizeIcon;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


public class ItemOrder extends javax.swing.JPanel {

    public ProductDetail getItem() {
        return Item;
    }

    public void setItem(ProductDetail Item) {
        this.Item = Item;
    }

    /**
     * Creates new form ItemOrder
     */
    public ItemOrder() {
        initComponents();
    }
    
        public double getTotalItem() {
        try {
            double price = Formatter.parsePrice(labPrice.getText()); // Chuyển đổi giá từ chuỗi
            int quantity = (int) jSpinner1.getValue(); // Lấy số lượng từ JSpinner
            return price * quantity; // Tính tổng giá trị
        } catch (ParseException ex) {
            Logger.getLogger(ItemCart.class.getName()).log(Level.SEVERE, null, ex);
            return 0.0; // Giá trị mặc định nếu xảy ra lỗi
        }
    }
    
    
    private ProductDetail Item;
    
    public ItemOrder(ProductDetail item) {
    // Gọi hàm khởi tạo mặc định để khởi tạo giao diện
        this();
        Item = item;
        
        // Gán giá trị cho các thành phần giao diện
        labTitle.setText(Item.getTitle()); // Gán tiêu đề sản phẩm
        labIdProduct.setText("Mã: " + Item.getProductId()); // Gán mã sản phẩm
        labPrice.setText(formatPrice(Item.getPrice())); // Gán giá sản phẩm

        // Đặt hình ảnh sản phẩm
        ImageIcon icon = new ImageIcon(getClass().getResource(item.getImageUrl()));
        imgProduct.setIcon(resizeIcon(icon,90,90));

        // Gán các kích thước vào ComboBox
        combSize.removeAllItems(); // Xóa các mục hiện có
        combSize.removeAllItems(); // Xóa các mục hiện có
        combSize.addItem(item.getSize().toString()); // Thêm từng kích thước vào ComboBox
        jSpinner1.setValue(Item.getSoLuong());
    }
    
    
    public ItemOrder(String title, String urlImg, double price, List<Integer> size, String ID) {
    // Gọi hàm khởi tạo mặc định để khởi tạo giao diện
        this();

        // Gán giá trị cho các thành phần giao diện
        labTitle.setText(title); // Gán tiêu đề sản phẩm
        labIdProduct.setText("Mã: " + ID); // Gán mã sản phẩm
        labPrice.setText(formatPrice(price)); // Gán giá sản phẩm

        // Đặt hình ảnh sản phẩm
        if (urlImg != null && !urlImg.isEmpty()) {
            imgProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource(urlImg)));
        } else {
            imgProduct.setText("Không có ảnh"); // Nếu không có URL, hiển thị thông báo
        }

        // Gán các kích thước vào ComboBox
        combSize.removeAllItems(); // Xóa các mục hiện có
        for (Integer s : size) {
            combSize.addItem(s.toString()); // Thêm từng kích thước vào ComboBox
        }
    }

//public double getTotal() {
//    try {
//        // Chuyển đổi giá trị từ labPrice (string) thành double
//        double price = parsePrice(labPrice.getText());
//
//        // Chuyển đổi số lượng từ string thành int (hoặc double nếu cần)
//        int quantity = Integer.parseInt();
//
//        // Tính tổng và trả về kết quả
//        return price * quantity;
//
//    } catch (ParseException e) {
//        // Xử lý trường hợp không thể phân tích giá trị
//        e.printStackTrace();
//        return 0;  // Hoặc trả về giá trị mặc định khác
//    } catch (NumberFormatException e) {
//        // Xử lý trường hợp không thể chuyển đổi số lượng sang int
//        e.printStackTrace();
//        return 0;  // Hoặc giá trị mặc định khác
//    }
//}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        imgProduct = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        labTitle = new javax.swing.JTextPane();
        labIdProduct = new javax.swing.JLabel();
        labPrice = new javax.swing.JLabel();
        radiumPanel1 = new com.mycompany.swing.RadiumPanel();
        jLabel5 = new javax.swing.JLabel();
        combSize = new com.mycompany.swing.ComboBoxSuggestion();
        jSpinner1 = new javax.swing.JSpinner();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(117, 90));
        jPanel1.setMinimumSize(new java.awt.Dimension(90, 90));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(90, 90));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        imgProduct.setText("jLabel1");
        imgProduct.setMaximumSize(new java.awt.Dimension(90, 90));
        imgProduct.setMinimumSize(new java.awt.Dimension(90, 90));
        imgProduct.setOpaque(true);
        imgProduct.setPreferredSize(new java.awt.Dimension(90, 90));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel1.add(imgProduct, gridBagConstraints);

        add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 0));
        jPanel3.setOpaque(false);

        labTitle.setEditable(false);
        labTitle.setBorder(null);
        labTitle.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labTitle.setForeground(new java.awt.Color(0, 52, 104));
        labTitle.setText("Nhẫn cưới Kim cương Vàng Trắng 18K PNJ DD00W005844");
        labTitle.setFocusable(false);
        labTitle.setOpaque(false);
        labTitle.setVerifyInputWhenFocusTarget(false);

        labIdProduct.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        labIdProduct.setForeground(new java.awt.Color(102, 102, 102));
        labIdProduct.setText("Mã: DD00W005844");

        labPrice.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        labPrice.setForeground(new java.awt.Color(197, 140, 70));
        labPrice.setText("9.698.000 đ");
        labPrice.setToolTipText("");

        radiumPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        radiumPanel1.setPreferredSize(new java.awt.Dimension(133, 20));

        jLabel5.setText("Kích thước:");

        combSize.setBorder(null);
        combSize.setEditable(false);
        combSize.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "23", "34", "30", "32" }));
        combSize.setFocusable(false);
        combSize.setOpaque(false);

        javax.swing.GroupLayout radiumPanel1Layout = new javax.swing.GroupLayout(radiumPanel1);
        radiumPanel1.setLayout(radiumPanel1Layout);
        radiumPanel1Layout.setHorizontalGroup(
            radiumPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(radiumPanel1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combSize, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        radiumPanel1Layout.setVerticalGroup(
            radiumPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, radiumPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(combSize, javax.swing.GroupLayout.PREFERRED_SIZE, 18, Short.MAX_VALUE))
        );

        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(1, 1, 20, 1));
        jSpinner1.setEditor(new javax.swing.JSpinner.NumberEditor(jSpinner1, ""));
        jSpinner1.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(labIdProduct)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(labTitle)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(radiumPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(labPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(178, 178, 178))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(labTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labIdProduct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(radiumPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.swing.ComboBoxSuggestion combSize;
    private javax.swing.JLabel imgProduct;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel labIdProduct;
    private javax.swing.JLabel labPrice;
    private javax.swing.JTextPane labTitle;
    private com.mycompany.swing.RadiumPanel radiumPanel1;
    // End of variables declaration//GEN-END:variables
}

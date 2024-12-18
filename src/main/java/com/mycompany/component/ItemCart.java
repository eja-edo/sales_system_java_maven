/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.component;

import com.mycompany.model.entity.ProductDetail;
import com.mycompany.utils.Formatter;
import static com.mycompany.utils.Formatter.formatPrice;
import com.mycompany.utils.RoundBorder;
import com.mycompany.utils.ScaleImg;
import static com.mycompany.utils.resizeIcon.resizeIcon;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author duyan
 */
public class ItemCart extends javax.swing.JPanel {

    public ProductDetail getItem() {
        return Item;
    }

    public void setItem(ProductDetail Item) {
        this.Item = Item;
    }
    
    private boolean isSelected = false; // Trạng thái đã chọn hay chưa
    private ActionListener selectAction; // Callback khi ấn chọn/bỏ chọn
    private OnQuantityChangeListener listener; // Callback interface
    private ProductDetail Item;

    
    
    // Đăng ký callback
    public void setOnQuantityChangeListener(OnQuantityChangeListener listener) {
        this.listener = listener;
    }

    // Định nghĩa interface callback
    public interface OnQuantityChangeListener {
        void onQuantityChanged(double total);
    }
    
    public ItemCart() {
        initComponents();
        btnSelect.addActionListener(e -> toggleSelection());
    // Lắng nghe sự thay đổi của JSpinner
        jSpinner1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentQuantity = (int) jSpinner1.getValue();
                int change = currentQuantity - Item.getSoLuong(); // Tính mức thay đổi (+ hoặc -)

                if (currentQuantity != Item.getSoLuong() &&  listener != null && isSelected) {
                    listener.onQuantityChanged(change * Item.getPrice()); // Gửi giá trị thay đổi (tổng tiền) về lớp cha
                }

                Item.setSoLuong(currentQuantity);// Cập nhật giá trị trước đó
            }
        });
    }
    public ItemCart(ProductDetail item)
    {
        this();
        Item = item;
        Item.setSoLuong(1);
        // Gán giá trị cho các thành phần giao diện
        labTitle.setText(item.getTitle()); // Gán tiêu đề sản phẩm
        labIdProduct.setText("Mã: " + item.getProductId()); // Gán mã sản phẩm
        labPrice.setText(formatPrice(item.getPrice())); // Gán giá sản phẩm
        System.out.println(item.getImageUrl());
        ImageIcon icon = new ImageIcon(getClass().getResource(item.getImageUrl()));
        imgProduct.setIcon(resizeIcon(icon,90,90));
//        try {
//            // Chuyển đổi đường dẫn URL thành định dạng hợp lệ
//            String imgPath = item.getImageUrl();
//            if (imgPath != null) {
//                imgPath = imgPath.replace("\\", "/");
//                URL url = getClass().getResource(imgPath);
//
//                if (url != null) {
//                    Image img = ImageIO.read(url);
//                    ImageIcon imgIcon = new ImageIcon(img);
//                    imgProduct.setIcon(imgIcon);
//                } else {
//                    System.out.println("Không thể tìm thấy ảnh từ URL: " + imgPath);
//                    // Đặt ảnh mặc định nếu không thể tìm thấy ảnh từ URL
//                    ImageIcon defaultImgIcon = new ImageIcon(getClass().getResource("/image/png259X259.png"));
//                    
//                }
//            } else {
//                System.out.println("URL Image is null");
//                // Đặt ảnh mặc định nếu không có URL ảnh
//                ImageIcon defaultImgIcon = new ImageIcon(getClass().getResource("/image/png259X259.png"));
//                imgProduct.setIcon(defaultImgIcon);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            // Đặt ảnh mặc định nếu có lỗi khi tải ảnh
//            ImageIcon defaultImgIcon = new ImageIcon(getClass().getResource("/image/png259X259.png"));
//            imgProduct.setIcon(defaultImgIcon);
//        }
        ScaleImg.scaleImg(imgProduct);
        // Gán các kích thước vào ComboBox
        combSize.removeAllItems(); // Xóa các mục hiện có
        combSize.addItem(item.getSize().toString()); // Thêm từng kích thước vào ComboBox
    }
public ItemCart(String title, String urlImg, String price, List<Integer> size, String ID) {
    // Gọi hàm khởi tạo mặc định để khởi tạo giao diện
    this();
    
    // Gán giá trị cho các thành phần giao diện
    labTitle.setText(title); // Gán tiêu đề sản phẩm
    labIdProduct.setText("Mã: " + ID); // Gán mã sản phẩm
    labPrice.setText(price); // Gán giá sản phẩm

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
    
        // Thêm phương thức để gắn ActionListener cho nút xóa
    public void setDeleteAction(ActionListener action) {
        btnDelete.addActionListener(action);
    }
    
        private void toggleSelection() {
        isSelected = !isSelected;
        updateSelectButtonUI();

        // Gọi callback khi trạng thái thay đổi
        if (selectAction != null) {
            selectAction.actionPerformed(null);
        }
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
        
    public void setSelectAction(ActionListener action) {
        this.selectAction = action;
    }

    public void setChangeQuality(ActionListener action)
    {
        
    }

    public boolean isSelected() {
        return isSelected;
    }
        
    private void updateSelectButtonUI() {
        btnSelect.setBackground(isSelected ? new java.awt.Color(76, 175, 80) : new java.awt.Color(153, 153, 153));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        btnDelete = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnSelect = new javax.swing.JToggleButton();
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

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btnDelete.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        btnDelete.setBorderPainted(false);
        btnDelete.setContentAreaFilled(false);
        btnDelete.setMaximumSize(new java.awt.Dimension(25, 25));
        btnDelete.setMinimumSize(new java.awt.Dimension(25, 25));
        btnDelete.setPreferredSize(new java.awt.Dimension(25, 25));
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteMouseExited(evt);
            }
        });
        add(btnDelete, java.awt.BorderLayout.LINE_END);

        jPanel1.setMaximumSize(new java.awt.Dimension(117, 90));
        jPanel1.setMinimumSize(new java.awt.Dimension(117, 90));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(117, 90));
        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {0, 7, 0};
        jPanel1Layout.rowHeights = new int[] {0};
        jPanel1.setLayout(jPanel1Layout);

        btnSelect.setBackground(new java.awt.Color(153, 153, 153));
        btnSelect.setBorder(null);
        btnSelect.setBorderPainted(false);
        btnSelect.setFocusPainted(false);
        btnSelect.setMaximumSize(new java.awt.Dimension(20, 20));
        btnSelect.setMinimumSize(new java.awt.Dimension(20, 20));
        btnSelect.setPreferredSize(new java.awt.Dimension(20, 20));
        jPanel1.add(btnSelect, new java.awt.GridBagConstraints());

        imgProduct.setBackground(new java.awt.Color(255, 255, 255));
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
                .addComponent(labPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(184, 184, 184))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labIdProduct)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(radiumPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(217, Short.MAX_VALUE))
            .addComponent(labTitle)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(labTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labIdProduct)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radiumPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseEntered
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete (1).png")));
    }//GEN-LAST:event_btnDeleteMouseEntered

    private void btnDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseExited
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png")));
    }//GEN-LAST:event_btnDeleteMouseExited

    public String getPrice(){
        return labPrice.getText();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JToggleButton btnSelect;
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

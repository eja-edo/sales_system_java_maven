package com.mycompany.main;

import com.mycompany.component.ItemProduct;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class test2 extends JPanel {

    /**
     * Creates new form test2
     */
    public test2() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        // Tạo 10 ItemProduct
    // Tạo 10 ItemProduct
    itemProducts = new com.mycompany.component.ItemProduct[10];
    for (int i = 0; i < 10; i++) {
        itemProducts[i] = new com.mycompany.component.ItemProduct();
    }

    setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10)); // Sử dụng FlowLayout

    // Thêm tất cả các ItemProduct vào giao diện
    for (int i = 0; i < 10; i++) {
        add(itemProducts[i]);
    }
    }// </editor-fold>                        

    // Variables declaration - do not modify                     
    private com.mycompany.component.ItemProduct[] itemProducts;
    // End of variables declaration                   
}
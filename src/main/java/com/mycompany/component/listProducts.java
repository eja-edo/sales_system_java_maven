/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.component;

import static com.mycompany.utils.resizeIcon.resizeIcon;
import javax.swing.ImageIcon;


public class listProducts extends javax.swing.JPanel {

    public listProducts() {
        initComponents();
        btnBack.setContentAreaFilled(false);
        btnNext.setContentAreaFilled(false);
       
        btnBack.setIcon(resizeIcon(new ImageIcon(getClass().getResource("/icon/back.png")),18,27));
        btnNext.setIcon(resizeIcon(new ImageIcon(getClass().getResource("/icon/next.png")),18,27));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        test21 = new com.mycompany.main.test2();

        setLayout(new java.awt.BorderLayout());

        btnBack.setBorder(null);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, java.awt.BorderLayout.LINE_START);

        btnNext.setBorder(null);
        add(btnNext, java.awt.BorderLayout.LINE_END);

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setViewportView(test21);

        add(jScrollPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNext;
    private javax.swing.JScrollPane jScrollPane2;
    private com.mycompany.main.test2 test21;
    // End of variables declaration//GEN-END:variables
}

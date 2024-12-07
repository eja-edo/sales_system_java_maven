/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.main;

import com.mycompany.component.header;
import com.mycompany.model.entity.Users;
import com.mycompany.swing.ScrollBarWin11UI;
import com.mycompany.utils.CardSelectionListener;
import com.mycompany.utils.CurrentUser;
import com.mycompany.utils.UserChangeListener;
import java.awt.CardLayout;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

/**
 *
 * @author duyan
 */
public class Main extends javax.swing.JFrame implements CardSelectionListener, UserChangeListener{


//    private final String[] cardName;
//    private int CurrentCard;
    private CardLayout cardLayout;
    public Main() {
        initComponents();
//        cardName = new String[]{"jScrollPane1","jScrollPane2","jScrollPane3","jScrollPane4","jScrollPane5","jScrollPane6","jScrollPane7","jScrollPane18"};
//        CurrentCard = 0;
    CurrentUser.addListener(this);
    cardLayout = (CardLayout) jPanel1.getLayout();
    menu1.setParent(this);
    trang_con1.setTrangCon(1);
    trang_con2.setTrangCon(2);
    trang_con3.setTrangCon(3);
    trang_con4.setTrangCon(4);
    }   
   
    private Users user; 

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header1 = new com.mycompany.component.header();
        menu1 = new com.mycompany.component.Menu();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        home1 = new com.mycompany.tab.Home();
        jScrollPane2 = new javax.swing.JScrollPane();
        trang_con1 = new com.mycompany.component.trang_con();
        jScrollPane4 = new javax.swing.JScrollPane();
        trang_con2 = new com.mycompany.component.trang_con();
        jScrollPane5 = new javax.swing.JScrollPane();
        trang_con3 = new com.mycompany.component.trang_con();
        jScrollPane6 = new javax.swing.JScrollPane();
        trang_con4 = new com.mycompany.component.trang_con();
        jScrollPane7 = new javax.swing.JScrollPane();
        trang_con5 = new com.mycompany.component.trang_con();
        jScrollPane3 = new javax.swing.JScrollPane();
        livestream1 = new com.mycompany.component.livestream();
        jScrollPane8 = new javax.swing.JScrollPane();
        ttkh1 = new com.mycompany.tab.ttkh();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(header1, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(menu1, java.awt.BorderLayout.LINE_START);

        jPanel1.setLayout(new java.awt.CardLayout());

        jScrollPane1.setViewportView(home1);

        jPanel1.add(jScrollPane1, "jScrollPane1");

        jScrollPane2.setViewportView(trang_con1);

        jPanel1.add(jScrollPane2, "jScrollPane2");

        jScrollPane4.setViewportView(trang_con2);

        jPanel1.add(jScrollPane4, "jScrollPane3");

        jScrollPane5.setViewportView(trang_con3);

        jPanel1.add(jScrollPane5, "jScrollPane4");

        jScrollPane6.setViewportView(trang_con4);

        jPanel1.add(jScrollPane6, "jScrollPane5");

        jScrollPane7.setViewportView(trang_con5);

        jPanel1.add(jScrollPane7, "jScrollPane6");

        jScrollPane3.setViewportView(livestream1);

        jPanel1.add(jScrollPane3, "jScrollPane7");

        jScrollPane8.setViewportView(ttkh1);

        jPanel1.add(jScrollPane8, "jScrollPane8");

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
                UIDefaults ui = UIManager.getDefaults();
        ui.put("ScrollBarUI", ScrollBarWin11UI.class.getCanonicalName());

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.component.header header1;
    private com.mycompany.tab.Home home1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private com.mycompany.component.livestream livestream1;
    private com.mycompany.component.Menu menu1;
    private com.mycompany.component.trang_con trang_con1;
    private com.mycompany.component.trang_con trang_con2;
    private com.mycompany.component.trang_con trang_con3;
    private com.mycompany.component.trang_con trang_con4;
    private com.mycompany.component.trang_con trang_con5;
    private com.mycompany.tab.ttkh ttkh1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setShowPanel(String card) {
        
        System.out.println("Card selected: " + card);
        cardLayout.show(jPanel1,card);
    }

    @Override
    public void onUserChanged(Users newUser) {
        if (newUser != null) {
            header.cloceLoginDialog();
        } else {
            System.out.println("User has been cleared.");
        }
    } 
}

package com.mycompany.test;

import com.mycompany.swing.ScrollBarWin11UI;
import com.mycompany.tab.Home;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

/**
 *
 * @author duyan
 */
public class TestForm extends javax.swing.JFrame {

    /**
     * Creates new form TestForm
     */
    public TestForm() {
        initComponents();
        loadHomePanel(); // Load home panel initially
    }

    private void loadHomePanel() {
        Home homePanel = new Home();
        jScrollPane1.setViewportView(homePanel);
        jScrollPane1.revalidate();
        jScrollPane1.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        header1 = new com.mycompany.component.header();
        menu2 = new com.mycompany.component.Menu();

        jScrollPane1 = new javax.swing.JScrollPane();
        home1 = new com.mycompany.tab.Home();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(header1, java.awt.BorderLayout.PAGE_START);
        getContentPane().add(menu2, java.awt.BorderLayout.LINE_START);


        jScrollPane1.setViewportView(home1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.LINE_END);

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
            java.util.logging.Logger.getLogger(TestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        UIDefaults ui = UIManager.getDefaults();
        ui.put("ScrollBarUI", ScrollBarWin11UI.class.getCanonicalName());
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestForm().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.component.header header1;

    private com.mycompany.tab.Home home1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.mycompany.component.Menu menu2;

    // End of variables declaration//GEN-END:variables
}

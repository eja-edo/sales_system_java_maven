package com.mycompany.component;

import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;
import java.awt.BorderLayout;
import javax.swing.SwingUtilities;

public class livestream extends javax.swing.JPanel {

    private final EmbeddedMediaPlayerComponent mediaPlayerComponent;

    public livestream() {
        initComponents();
        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        this.setLayout(new BorderLayout());
        this.add(mediaPlayerComponent, BorderLayout.CENTER);

        // Bật debug để kiểm tra
        System.setProperty("vlcj.log", "DEBUG");

        SwingUtilities.invokeLater(() -> {
            if (this.isDisplayable()) {
               String videoPath = "D:/study/monky4/java/BTLON/sales_system_java_maven/vid/5s.mp4";
                mediaPlayerComponent.mediaPlayer().media().play(videoPath);

                boolean success = mediaPlayerComponent.mediaPlayer().media().start(videoPath);
                if (!success) {
                    System.err.println("Failed to play video: " + videoPath);
                }
            } else {
                System.err.println("Component chưa hiển thị, không thể phát video!");
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1200, 650));
        setMinimumSize(new java.awt.Dimension(1200, 650));
        setPreferredSize(new java.awt.Dimension(1200, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1200, 650));
        jPanel1.setMinimumSize(new java.awt.Dimension(1200, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 650));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("LIVE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(529, 529, 529)
                .addComponent(jLabel1)
                .addContainerGap(573, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addContainerGap(624, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

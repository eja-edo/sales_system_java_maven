/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.test;


import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.fullscreen.adaptive.AdaptiveFullScreenStrategy;
import com.sun.jna.NativeLibrary;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import uk.co.caprica.vlcj.binding.support.runtime.RuntimeUtil;

/**
 *
 * @author haidu
 */
public class testlivestream extends javax.swing.JFrame {

     private MediaPlayerFactory mediaPlayerFactory;
    private EmbeddedMediaPlayer mediaPlayer;
    private Canvas videoCanvas; // Heavyweight component for video
    
   public testlivestream() {
        initComponents();
         setupVideoCanvas();
    }
   
   private void setupVideoCanvas() {
        // Tạo Canvas để hiển thị video
    videoCanvas = new Canvas();
    videoCanvas.setBackground(Color.black); // Nền đen cho video
    videoCanvas.setSize(800, 600);

    // Thêm Canvas vào JFrame
    this.setLayout(new BorderLayout());
    this.add(videoCanvas, BorderLayout.CENTER);
    this.setSize(800, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 948, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 908, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
         try {
        // Tắt log VLCJ
        System.setProperty("vlcj.log", "NONE");

        System.out.println("Đang tải thư viện VLC...");
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:/Program Files/VideoLAN/VLC");
        System.out.println("Thư viện VLC đã được tải.");

        // Khởi tạo MediaPlayerFactory với cấu hình bổ sung
        mediaPlayerFactory = new MediaPlayerFactory(
            "--no-video-title-show",
            "--no-embedded-video",
            "--vout=direct3d11"
        );

        // Tạo MediaPlayer
        mediaPlayer = mediaPlayerFactory.mediaPlayers().newEmbeddedMediaPlayer();

        // Gắn video vào Canvas
        mediaPlayer.videoSurface().set(
            mediaPlayerFactory.videoSurfaces().newVideoSurface(videoCanvas)
        );

        // Đường dẫn đến video
        String videoPath = "https://drive.google.com/uc?export=download&id=1nlCr8sdQFpzxX_bVv028RrxVQbvl5Xxc";

        // Phát video
        if (mediaPlayer.media().play(videoPath)) {
            System.out.println("Phát video thành công.");
        } else {
            System.err.println("Không thể phát video. Kiểm tra đường dẫn hoặc codec.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            testlivestream frame = new testlivestream();
            frame.setVisible(true);
            frame.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowOpened(java.awt.event.WindowEvent evt) {
                    frame.formWindowOpened(evt);
                }
            });
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

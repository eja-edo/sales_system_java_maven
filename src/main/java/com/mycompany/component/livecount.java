package com.mycompany.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;

public class livecount extends JPanel {
    private JLabel timeLabel;
    private JLabel imageLabel;
    private Timer timer;
    private int hours = 3;
    private int minutes = 29;
    private int seconds = 0;

    public livecount() {
        setLayout(new BorderLayout(20, 20));

        // Countdown timer
        timeLabel = new JLabel("Thời gian đến phiên LIVE tiếp theo: " + formatTime(hours, minutes, seconds), JLabel.CENTER);
        timeLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
        timeLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0)); // Cách lề trên 30px
        add(timeLabel, BorderLayout.NORTH);

        // Image label
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(JLabel.CENTER); // Căn giữa ảnh
        add(imageLabel, BorderLayout.CENTER);

        String defaultImgPath = "/image/lstream.png";
        try {
            Image image = ImageIO.read(getClass().getResource(defaultImgPath));
            ImageIcon imageIcon = new ImageIcon(image);
            imageLabel.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Timer setup
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (seconds == 0) {
                    if (minutes == 0) {
                        if (hours == 0) {
                            timer.stop();
                        } else {
                            hours--;
                            minutes = 59;
                            seconds = 59;
                        }
                    } else {
                        minutes--;
                        seconds = 59;
                    }
                } else {
                    seconds--;
                }
                timeLabel.setText("Thời gian đến phiên LIVE tiếp theo: " + formatTime(hours, minutes, seconds));
            }
        });
        timer.start();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
        private String formatTime(int hours, int minutes, int seconds) {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
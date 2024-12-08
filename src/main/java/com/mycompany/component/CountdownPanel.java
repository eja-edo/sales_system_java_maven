package com.mycompany.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CountdownPanel extends JPanel {
    private JLabel timeLabel;
    private JLabel imageLabel;
    private JLabel liveLabel;
    private Timer timer;
    private int hours = 3;
    private int minutes = 29;
    private int seconds = 0;

    public CountdownPanel() {
        setLayout(new BorderLayout(20,20));
       
        // Countdown timer
        timeLabel = new JLabel("Thời gian đến phiên LIVE tiếp theo: " + formatTime(hours, minutes, seconds), JLabel.CENTER);
        timeLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
        add(timeLabel, BorderLayout.NORTH);

        // Image label
        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(750, 490));
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

    private String formatTime(int hours, int minutes, int seconds) {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 613));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 613, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
     
     public static void main(String[] args) {
        JFrame frame = new JFrame("Countdown Timer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new CountdownPanel());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

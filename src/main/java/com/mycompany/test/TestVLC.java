/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.test;
import uk.co.caprica.vlcj.factory.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;

public class TestVLC {
    public static void main(String[] args) {
        // Tìm thư viện VLC
        boolean found = new NativeDiscovery().discover();
        System.out.println("VLC library found: " + found);

        // Tạo JFrame và MediaPlayer
        JFrame frame = new JFrame("VLCJ Test");
        EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        frame.setContentPane(mediaPlayerComponent);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hiển thị JFrame trước
        frame.setVisible(true);

        // Đợi JFrame hiển thị hoàn toàn trước khi phát video
        SwingUtilities.invokeLater(() -> {
            String videoPath = "vid/5s.mp4";
            mediaPlayerComponent.mediaPlayer().media().play(videoPath);
        });
    }
}

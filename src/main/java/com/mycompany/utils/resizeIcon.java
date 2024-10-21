/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.utils;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class resizeIcon {
    
    // Method to resize an icon and set it on a JLabel
    public static ImageIcon resizeIcon(ImageIcon originalIcon, int width, int height) {
        // Get the image from the ImageIcon
        Image originalImage = originalIcon.getImage();
        
        // Resize the image to the desired width and height
        Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        
        // Create a new ImageIcon from the resized image
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        
        return resizedIcon;
    }
}

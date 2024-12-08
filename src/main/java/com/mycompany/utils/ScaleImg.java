package com.mycompany.utils;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ScaleImg {

    public static void scaleImg(JLabel lb) {
        // Get the current icon from the label
        ImageIcon icon = (ImageIcon) lb.getIcon();
        // Check if the icon exists
        if (icon != null) {
            Image img = icon.getImage(); // Get the image from the icon
            
            // Check if label's width and height are set
            if (lb.getWidth() > 0 && lb.getHeight() > 0) {
                // Resize the image according to label's dimensions
                Image imgScale = img.getScaledInstance(lb.getWidth(), lb.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon imgIcon = new ImageIcon(imgScale);
                
                // Set the resized image as the label's icon
                lb.setIcon(imgIcon);
            }
        } else {
            System.out.println("Error: JLabel does not have an icon set.");
        }
    }
}
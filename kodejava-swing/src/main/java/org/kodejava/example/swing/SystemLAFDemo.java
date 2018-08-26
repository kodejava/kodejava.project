package org.kodejava.example.swing;

import javax.swing.*;

public class SystemLAFDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(250, 250);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("System LAF Demo");

        try {
            // Use the system look and feel for the swing application
            String className = UIManager.getSystemLookAndFeelClassName();
            System.out.println("className = " + className);
            UIManager.setLookAndFeel(className);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.updateComponentTreeUI(frame);
        frame.setVisible(true);
    }
}

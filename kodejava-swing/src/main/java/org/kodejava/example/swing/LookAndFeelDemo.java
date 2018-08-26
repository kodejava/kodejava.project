package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;

public class LookAndFeelDemo extends JFrame {
    public LookAndFeelDemo() {
        initComponents();
    }

    private void initComponents() {
        setSize(250, 250);
        setTitle("LAF Demo");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));

        JMenu menu = new JMenu("Look and Feel");

        // Get all the available look and feel that we are going to use for
        // creating the JMenuItem and assign the action listener to handle
        // the selection of menu item to change the look and feel.
        UIManager.LookAndFeelInfo[] lookAndFeels = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo lookAndFeelInfo : lookAndFeels) {
            JMenuItem item = new JMenuItem(lookAndFeelInfo.getName());
            item.addActionListener(event -> {
                try {
                    // Set the look and feel for the frame and update the UI
                    // to use a new selected look and feel.
                    UIManager.setLookAndFeel(lookAndFeelInfo.getClassName());
                    SwingUtilities.updateComponentTreeUI(this);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            menu.add(item);
        }

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);

        getContentPane().add(menuBar);
        getContentPane().add(new JButton("Hello"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LookAndFeelDemo().setVisible(true));
    }
}

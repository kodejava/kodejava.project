package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClickEventDemo extends JFrame {
    public MouseClickEventDemo() {
        initComponents();
    }

    private void initComponents() {
        setSize(500, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final JTextArea textArea = new JTextArea();
        textArea.setText("Click Me!");

        textArea.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.NOBUTTON) {
                    textArea.setText("No button clicked...");
                } else if (e.getButton() == MouseEvent.BUTTON1) {
                    textArea.setText("Button 1 clicked...");
                } else if (e.getButton() == MouseEvent.BUTTON2) {
                    textArea.setText("Button 2 clicked...");
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    textArea.setText("Button 3 clicked...");
                }

                textArea.append("Number of click: " + e.getClickCount());
                textArea.append("Click position (X, Y):  " + e.getX() + ", " + e.getY());
            }
        });

        getContentPane().add(textArea);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MouseClickEventDemo().setVisible(true);
            }
        });
    }
}

package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class MouseMotionListenerDemo extends JFrame {
    public MouseMotionListenerDemo() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 400);

        JTextArea textArea = new JTextArea("Hello World... try to move the mouse, click and drag it...");
        textArea.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                System.out.println("Mouse Dragged...");
            }

            public void mouseMoved(MouseEvent e) {
                System.out.println("Mouse Moved...");
            }
        });

        getContentPane().add(textArea);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MouseMotionListenerDemo().setVisible(true));
    }
}

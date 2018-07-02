package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

public class MouseWheelListenerDemo extends JFrame {
    public MouseWheelListenerDemo() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(200, 200);

        JTextArea textArea = new JTextArea();
        textArea.addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent e) {
                System.out.println("MouseWheelListenerDemo.mouseWheelMoved");

                // If wheel rotation value is a negative it means rotate up, while
                // positive value means rotate down
                if (e.getWheelRotation() < 0) {
                    System.out.println("Rotated Up... " + e.getWheelRotation());
                } else {
                    System.out.println("Rotated Down... " + e.getWheelRotation());
                }

                // Get scrolled unit amount
                System.out.println("ScrollAmount: " + e.getScrollAmount());

                // WHEEL_UNIT_SCROLL representing scroll by unit such as the
                // arrow keys. WHEEL_BLOCK_SCROLL representing scroll by block
                // such as the page-up or page-down key.
                if (e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL) {
                    System.out.println("MouseWheelEvent.WHEEL_UNIT_SCROLL");
                }

                if (e.getScrollType() == MouseWheelEvent.WHEEL_BLOCK_SCROLL) {
                    System.out.println("MouseWheelEvent.WHEEL_BLOCK_SCROLL");
                }
            }
        });

        getContentPane().add(textArea);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MouseWheelListenerDemo().setVisible(true));
    }
}

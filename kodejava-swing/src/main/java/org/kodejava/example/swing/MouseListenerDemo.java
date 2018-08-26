package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListenerDemo extends JFrame {
    public MouseListenerDemo() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 400);
        JTextArea textArea = new JTextArea();
        textArea.setText("Press the mouse button...");

        MouseAdapter mouseAdapter = new MyMouseAdapter();
        textArea.addMouseListener(mouseAdapter);
        getContentPane().add(textArea);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MouseListenerDemo().setVisible(true));
    }

    private class MyMouseAdapter extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            System.out.println("MouseListenerDemo.mouseClicked");
        }

        public void mousePressed(MouseEvent e) {
            System.out.println("MouseListenerDemo.mousePressed");
        }

        public void mouseReleased(MouseEvent e) {
            System.out.println("MouseListenerDemo.mouseReleased");
        }

        public void mouseEntered(MouseEvent e) {
            System.out.println("MouseListenerDemo.mouseEntered");
        }

        public void mouseExited(MouseEvent e) {
            System.out.println("MouseListenerDemo.mouseExited");
        }
    }
}

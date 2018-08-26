package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowTaskbarFlash extends JFrame {
    private WindowTaskbarFlash() throws HeadlessException {
        initUI();
    }

    private void initUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setSize(200, 200);
        setState(Frame.ICONIFIED);

        // Demonstrate flashes the application window task bar
        // by calling the toFront method every 5 seconds.
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toFront();
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WindowTaskbarFlash().setVisible(true);
            }
        });
    }
}

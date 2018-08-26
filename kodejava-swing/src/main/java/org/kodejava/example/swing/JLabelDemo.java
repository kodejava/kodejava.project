package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;

public class JLabelDemo extends JFrame {
    public JLabelDemo() throws HeadlessException {
        initialize();
    }

    private void initialize() {
        setSize(150, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Create some JLabel with Texts and define the horizontal alignment
        JLabel label1 = new JLabel("Username :", JLabel.RIGHT);
        JLabel label2 = new JLabel("Password :", JLabel.RIGHT);
        JLabel label3 = new JLabel("Confirm Password :", JLabel.RIGHT);
        JLabel label4 = new JLabel("Remember Me!", JLabel.LEFT);
        JLabel label5 = new JLabel("Hello, Anybody There?", JLabel.CENTER);

        // Set the vertical alignment for label5 and also set a tool tip for it
        label5.setVerticalAlignment(JLabel.TOP);
        label5.setToolTipText("I have a tool tip with me!");

        getContentPane().add(label1);
        getContentPane().add(label2);
        getContentPane().add(label3);
        getContentPane().add(label4);
        getContentPane().add(label5);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JLabelDemo().setVisible(true);
            }
        });
    }
}

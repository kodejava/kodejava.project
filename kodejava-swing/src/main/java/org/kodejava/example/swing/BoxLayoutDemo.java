package org.kodejava.example.swing;

import javax.swing.*;

public class BoxLayoutDemo extends JFrame {
    public BoxLayoutDemo() {
        initialize();
    }

    private void initialize() {
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Set the layout of the Content Pane to BoxLayout using BoxLayout.X_AXIS
        // will arrange the component left to right. If we want to arrange the
        // component top to bottom we can use the BoxLayout.Y_AXIS;
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        JLabel label = new JLabel("Username : ");
        JTextField textField = new JTextField();

        JLabel password = new JLabel("Password :");
        JPasswordField passwordField = new JPasswordField();

        getContentPane().add(label);
        getContentPane().add(textField);

        getContentPane().add(password);
        getContentPane().add(passwordField);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BoxLayoutDemo().setVisible(true);
            }
        });
    }
}

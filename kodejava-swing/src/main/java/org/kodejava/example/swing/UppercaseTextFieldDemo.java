package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UppercaseTextFieldDemo extends JFrame {
    public UppercaseTextFieldDemo() throws HeadlessException {
        initComponents();
    }

    protected void initComponents() {
        // Set default form size, closing event and layout manager
        setSize(250, 250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));

        // Create a label and text field for our demo application and add the
        // component to the frame content pane object.
        JLabel usernameLabel = new JLabel("Username: ");
        JTextField usernameTextField = new JTextField();
        usernameTextField.setPreferredSize(new Dimension(150, 20));
        getContentPane().add(usernameLabel);
        getContentPane().add(usernameTextField);

        // Register a KeyListener for the text field. Using the KeyAdapter class
        // allow us implement the only key listener event that we want to listen,
        // in this example we use the keyReleased event.
        usernameTextField.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                JTextField textField = (JTextField) e.getSource();
                String text = textField.getText();
                textField.setText(text.toUpperCase());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UppercaseTextFieldDemo().setVisible(true));
    }
}

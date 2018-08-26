package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class JLabelSetForTextField extends JFrame {
    public JLabelSetForTextField() throws HeadlessException {
        initialize();
    }

    private void initialize() {
        setSize(400, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel usernameLabel = new JLabel("Username: ");
        JLabel passwordLabel = new JLabel("Password: ");
        JTextField usernameField = new JTextField(20);
        JPasswordField passwordField = new JPasswordField(20);

        // To make the association between the JLabel and JTextField or
        // JPasswordField we need to define the displayed mnemonic and then
        // call JLabel's setLabelFor method.
        usernameLabel.setDisplayedMnemonic(KeyEvent.VK_U);
        usernameLabel.setLabelFor(usernameField);
        passwordLabel.setDisplayedMnemonic(KeyEvent.VK_P);
        passwordLabel.setLabelFor(passwordField);

        getContentPane().add(usernameLabel);
        getContentPane().add(usernameField);
        getContentPane().add(passwordLabel);
        getContentPane().add(passwordField);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JLabelSetForTextField().setVisible(true);
            }
        });
    }
}

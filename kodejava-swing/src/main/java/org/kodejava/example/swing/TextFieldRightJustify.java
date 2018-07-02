package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;

public class TextFieldRightJustify extends JFrame {
    public TextFieldRightJustify() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(200, 200);

        Container container = getContentPane();
        container.setLayout(new FlowLayout(FlowLayout.LEFT));

        JTextField textField = new JTextField(15);
        textField.setPreferredSize(new Dimension(100, 20));

        // Right justify the JTextField contents
        textField.setHorizontalAlignment(JTextField.RIGHT);

        container.add(textField);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TextFieldRightJustify().setVisible(true);
            }
        });
    }
}

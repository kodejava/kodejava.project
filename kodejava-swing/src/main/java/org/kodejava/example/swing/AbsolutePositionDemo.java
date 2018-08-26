package org.kodejava.example.swing;

import javax.swing.*;

public class AbsolutePositionDemo extends JFrame {
    public AbsolutePositionDemo() {
        initializeUI();
    }

    private void initializeUI() {
        setSize(400, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null);

        JTextField textField = new JTextField(20);
        textField.setBounds(50, 50, 100, 20);

        JButton button = new JButton("Button");
        button.setBounds(200, 100, 100, 20);

        JCheckBox checkBox = new JCheckBox("Check Me!");
        checkBox.setBounds(300, 250, 100, 20);

        panel.add(textField);
        panel.add(button);
        panel.add(checkBox);

        setContentPane(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AbsolutePositionDemo().setVisible(true);
            }
        });
    }
}

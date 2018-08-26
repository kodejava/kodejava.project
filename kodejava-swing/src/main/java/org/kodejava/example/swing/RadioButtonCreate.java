package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;

public class RadioButtonCreate extends JFrame {
    public RadioButtonCreate() {
        initializeUI();
    }

    private void initializeUI() {
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));

        JPanel leftPanel = new JPanel();
        JLabel label = new JLabel("Employees: ");
        leftPanel.add(label);

        JPanel rightPanel = new JPanel(new GridLayout(4, 1));

        // Create a JRadioButton by calling the JRadioButton constructors and
        // passing a string for radio button text. We can also pass a boolean
        // value to select or unselect the radio button.
        JRadioButton radio1 = new JRadioButton("1 - 10");
        JRadioButton radio2 = new JRadioButton("11 - 50", true);
        JRadioButton radio3 = new JRadioButton("51 - 100");
        JRadioButton radio4 = new JRadioButton("101 - 1000", false);

        rightPanel.add(radio1);
        rightPanel.add(radio2);
        rightPanel.add(radio3);
        rightPanel.add(radio4);

        getContentPane().add(leftPanel);
        getContentPane().add(rightPanel);

        pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RadioButtonCreate().setVisible(true);
            }
        });
    }
}

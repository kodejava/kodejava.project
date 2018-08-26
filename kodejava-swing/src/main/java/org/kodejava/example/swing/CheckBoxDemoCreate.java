package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckBoxDemoCreate extends JFrame {
    public CheckBoxDemoCreate() throws HeadlessException {
        initialize();
    }

    private void initialize() {
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        // Creating checkbox with text label
        JCheckBox checkBoxA = new JCheckBox("Selection A");

        // Creating checkbox with text label a set the state into checked
        JCheckBox checkBoxB = new JCheckBox("Selection B", true);

        // Creating checkbox with text label and a default unselected image icon
        ImageIcon icon = new ImageIcon("ledred.png");
        JCheckBox checkBoxC = new JCheckBox("Selection C", icon);
        // Add action listener to listen for click and change the image icon
        // respectively
        checkBoxC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JCheckBox checkBox = (JCheckBox) e.getSource();
                if (checkBox.isSelected()) {
                    checkBox.setIcon(new ImageIcon("ledgreen.png"));
                    // Perform other actions here!
                } else {
                    checkBox.setIcon(new ImageIcon("ledred.png"));
                    // Perform other actions here!
                }
            }
        });

        getContentPane().add(checkBoxA);
        getContentPane().add(checkBoxB);
        getContentPane().add(checkBoxC);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CheckBoxDemoCreate().setVisible(true);
            }
        });
    }
}

package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;

public class CheckBoxState extends JFrame {
    public CheckBoxState() throws HeadlessException {
        initialize();
    }

    private void initialize() {
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        // Creating checkbox with text label
        JCheckBox checkBox = new JCheckBox("Check me!");
        checkBox.setSelected(true);

        // Get checkbox selection state
        boolean selected = checkBox.isSelected();
        if (selected) {
            System.out.println("Check box state is selected.");
        } else {
            System.out.println("Check box state is not selected.");
        }

        getContentPane().add(checkBox);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CheckBoxState().setVisible(true);
            }
        });
    }
}

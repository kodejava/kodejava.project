package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;

public class JCheckBoxCustomIcon extends JFrame {
    public JCheckBoxCustomIcon() throws HeadlessException {
        initialize();
    }

    private void initialize() {
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        // Creating checkbox with text label
        JCheckBox checkBox = new JCheckBox("Check me!");
        checkBox.setSelected(true);

        // Set default icon for checkbox
        checkBox.setIcon(new ImageIcon("icon.png"));
        // Set selected icon when checkbox state is selected
        checkBox.setSelectedIcon(new ImageIcon("selectedIcon.png"));
        // Set disabled icon for checkbox
        checkBox.setDisabledIcon(new ImageIcon("disabledIcon.png"));
        // Set disabled-selected icon for checkbox
        checkBox.setDisabledSelectedIcon(new ImageIcon("disabledSelectedIcon.png"));
        // Set checkbox icon when checkbox is pressed
        checkBox.setPressedIcon(new ImageIcon("pressedIcon.png"));
        // Set icon when a mouse is over the checkbox
        checkBox.setRolloverIcon(new ImageIcon("rolloverIcon.png"));
        // Set icon when a mouse is over a selected checkbox
        checkBox.setRolloverSelectedIcon(new ImageIcon("rolloverSelectedIcon.png"));

        getContentPane().add(checkBox);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JCheckBoxCustomIcon().setVisible(true);
            }
        });
    }
}

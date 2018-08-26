package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;

public class JButtonCustomIcon extends JFrame {
    public JButtonCustomIcon() throws HeadlessException {
        initialize();
    }

    private void initialize() {
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton button = new JButton("Press Me!");

        // Below is how we can set various icons for the JButton swing
        // component. There are the default icon, selected, disabled, presed
        // and rollover icons.
        button.setIcon(new ImageIcon("default.png"));
        button.setSelectedIcon(new ImageIcon("selected.png"));
        button.setDisabledIcon(new ImageIcon("disabled.png"));
        button.setDisabledSelectedIcon(new ImageIcon("disabledSelected.png"));
        button.setPressedIcon(new ImageIcon("pressed.png"));
        button.setRolloverIcon(new ImageIcon("rollover.png"));
        button.setRolloverSelectedIcon(new ImageIcon("rolloverSelected.png"));

        getContentPane().add(button);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JButtonCustomIcon().setVisible(true);
            }
        });
    }
}

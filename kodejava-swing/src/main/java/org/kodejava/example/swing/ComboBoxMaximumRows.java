package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;

public class ComboBoxMaximumRows extends JFrame {
    public ComboBoxMaximumRows() {
        initialize();
    }

    private void initialize() {
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        // Create some items for our JComboBox component. In this example we are
        // going to pass an array of string which are the name of the month.
        String[] months = {"January", "February", "March", "April", "Mei", "June",
            "July", "August", "September", "October", "November", "December"};

        // Create a month selection combo box.
        JComboBox comboBox = new JComboBox(months);

        // By default combo box will only shows eight items in the drop down. When
        // more that eight items are in the combo box a default scrollbar will be
        // shown. If we want to display more items we can change it by calling the
        // setMaximumRowCount() method.
        comboBox.setMaximumRowCount(12);

        getContentPane().add(comboBox);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ComboBoxMaximumRows().setVisible(true);
            }
        });
    }
}

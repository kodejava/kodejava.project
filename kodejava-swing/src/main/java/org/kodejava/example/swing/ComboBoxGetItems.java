package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ComboBoxGetItems extends JFrame {
    public ComboBoxGetItems() {
        initialize();
    }

    private void initialize() {
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        // Create JComboBox with grade as the values;
        String[] items = new String[] {"A", "B", "C", "D", "E", "F"};
        final JComboBox<String> gradeCombo = new JComboBox<>(items);
        getContentPane().add(gradeCombo);

        JButton button = new JButton("Get Items");
        final JLabel label = new JLabel("Items count: ");

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the number of items in the combo box drop down. Iterate
                // from zero to the number of combo box items and get each item
                // of the specified index.
                //
                // In this example we just place the items inside a StringBuilder
                // and print it later on.
                int count = gradeCombo.getItemCount();
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < count; i++) {
                    builder.append(gradeCombo.getItemAt(i));
                    if (i < count - 1) {
                        builder.append(", ");
                    }
                }
                label.setText("Item count: " + count + "; ["
                    + builder.toString() + "]");
            }
        });

        getContentPane().add(button);
        getContentPane().add(label);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ComboBoxGetItems().setVisible(true);
            }
        });
    }
}

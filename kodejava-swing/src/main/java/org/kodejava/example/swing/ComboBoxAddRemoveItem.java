package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ComboBoxAddRemoveItem extends JFrame {
    public ComboBoxAddRemoveItem() {
        initialize();
    }

    private void initialize() {
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        String[] items = new String[] {"Two", "Four", "Six", "Eight"};
        final JComboBox comboBox = new JComboBox(items);

        getContentPane().add(comboBox);

        JButton button1 = new JButton("Add One");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add item "One" at the beginning of the list.
                comboBox.insertItemAt("One", 0);
            }
        });
        JButton button2 = new JButton("Add Five and Nine");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add item Five on the third index and Nine at the end of the
                // list.
                comboBox.insertItemAt("Five", 3);
                comboBox.addItem("Nine");
            }
        });

        getContentPane().add(button1);
        getContentPane().add(button2);

        JButton remove1 = new JButton("Remove Eight and Last");
        remove1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Remove the Eight item and the last item from the list.
                comboBox.removeItemAt(5);
                comboBox.removeItemAt(comboBox.getItemCount() - 1);
            }
        });
        JButton remove2 = new JButton("Remove All");
        remove2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                comboBox.removeAllItems();
            }
        });

        getContentPane().add(remove1);
        getContentPane().add(remove2);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ComboBoxAddRemoveItem().setVisible(true);
            }
        });
    }
}

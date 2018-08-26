package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormatSymbols;

public class JListGetItems extends JFrame {
    public JListGetItems() {
        initialize();
    }

    private void initialize() {
        // Configure the frame default close operation, its size and the
        // layout.
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setLayout(new BorderLayout(5, 5));

        // Create a JList and set the items to the available weekdays
        // names.
        Object[] listItems = DateFormatSymbols.getInstance().getWeekdays();
        JList list = new JList(listItems);
        getContentPane().add(list, BorderLayout.CENTER);

        // Below we start to print the size of the list items and iterates
        // the entire list items or elements.
        System.out.println("JList item size: " + list.getModel().getSize());

        System.out.println("Reading all list items:");
        System.out.println("-----------------------");
        for (int i = 0; i < list.getModel().getSize(); i++) {
            Object item = list.getModel().getElementAt(i);
            System.out.println("Item = " + item);
        }
    }

    public static void main(String[] args) {
        // Run the program, create a new instance of JListGetItems and
        // set its visibility to true.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JListGetItems().setVisible(true);
            }
        });
    }
}

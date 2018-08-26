package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;

public class JListCellWidthAndHeight extends JFrame {
    public JListCellWidthAndHeight() {
        initialize();
    }

    private void initialize() {
        // Initialize windows default close operation, size and the layout
        // for laying the components.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLayout(new BorderLayout(5, 5));

        // Create a list of vector data to be used by the JList component.
        Vector<String> v = new Vector<>();
        v.add("A");
        v.add("B");
        v.add("C");
        v.add("D");

        JList<String> list = new JList<>(v);
        list.setFixedCellWidth(50);
        list.setFixedCellHeight(50);

        JScrollPane pane = new JScrollPane(list);

        // Add an action listener to the button to exit the application.
        JButton button = new JButton("CLOSE");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Add the scroll pane where the JList component is wrapped and
        // the button to the center and south of the panel
        getContentPane().add(pane, BorderLayout.CENTER);
        getContentPane().add(button, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JListCellWidthAndHeight().setVisible(true);
            }
        });
    }
}

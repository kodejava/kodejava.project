package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

public class CreateJListDemo extends JFrame {

    public CreateJListDemo() {
        initialize();
    }

    // Initialize the components and configuration of our CreateJListDemo.
    private void initialize() {
        // Define the window title, size and the default close operation.
        this.setTitle("Create JList Demo");
        this.setSize(300, 175);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Create an array of arbitrary objects for the JList to display.
        Object[] data = new Object[] {
            new Date(), "One", 1, Long.valueOf("12345"), "Four", "Five"
        };

        // Create an instance of JList and pass data variable as the
        // initial content of it. By default the JList does not have a
        // scrolling behaviour, so we create a JScrollPane as the container
        // for the JList.
        JList list = new JList(data);
        JScrollPane scrollPane = new JScrollPane(list);

        // Add a button to close the program.
        JButton button = new JButton("Close");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Set the panel layout to BorderLayout and place the list on the
        // center and the button on the south.
        this.setLayout(new BorderLayout(5, 5));
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(button, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CreateJListDemo().setVisible(true);
            }
        });
    }
}

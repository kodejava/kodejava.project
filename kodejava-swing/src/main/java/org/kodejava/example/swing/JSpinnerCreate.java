package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JSpinnerCreate extends JFrame {
    public JSpinnerCreate() {
        initialize();
    }

    private void initialize() {
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create an instance of JSpinner and put it at the top of the frame.
        final JSpinner spinner = new JSpinner();
        getContentPane().add(spinner, BorderLayout.NORTH);

        // Create a JButton and print out the value of the JSpinner when
        // the button is clicked.
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Integer value = (Integer) spinner.getValue();
                System.out.println("value = " + value);
            }
        });
        getContentPane().add(okButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JSpinnerCreate().setVisible(true);
            }
        });
    }
}

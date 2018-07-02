package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MessageDialogDemo extends JFrame {
    public MessageDialogDemo() throws HeadlessException {
        initialize();
    }

    private void initialize() {
        setSize(200, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton button1 = new JButton("Click Me!");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Show a message dialog with a text message
                JOptionPane.showMessageDialog((Component) e.getSource(),
                    "Thank you!");
            }
        });

        JButton button2 = new JButton("What is your name?");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Show an input dialog that will ask you to input some texts
                String text = JOptionPane.showInputDialog((Component) e.getSource(),
                    "What is your name?");
                if (text != null && !text.equals("")) {
                    JOptionPane.showMessageDialog((Component) e.getSource(),
                        "Hello " + text);
                }
            }
        });

        JButton button3 = new JButton("Close Application");
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Show a confirmation dialog which will ask to for a YES or NO
                // button.
                int result = JOptionPane.showConfirmDialog((Component) e.getSource(),
                    "Are you sure want to close this application?");
                if (result == JOptionPane.YES_OPTION) {
                    System.exit(0);
                } else if (result == JOptionPane.NO_OPTION) {
                    // Do nothing, continue to run the application
                }
            }
        });

        setLayout(new FlowLayout(FlowLayout.CENTER));
        getContentPane().add(button1);
        getContentPane().add(button2);
        getContentPane().add(button3);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MessageDialogDemo().setVisible(true);
            }
        });
    }
}

package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonGroupDemo extends JFrame {
    public ButtonGroupDemo() {
        initializeUI();
    }

    private void initializeUI() {
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        // Creating an action listener for our radio button.
        ActionListener action = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JRadioButton button = (JRadioButton) e.getSource();
                System.out.println("You select button: " + button.getText());
            }
        };

        // Creates four radio buttons and set the action listener.
        JRadioButton button1 = new JRadioButton("One");
        button1.addActionListener(action);
        JRadioButton button2 = new JRadioButton("Two");
        button2.addActionListener(action);
        JRadioButton button3 = new JRadioButton("Three");
        button3.addActionListener(action);
        JRadioButton button4 = new JRadioButton("Four");
        button4.addActionListener(action);

        // Create a ButtonGroup to group our radio buttons into one group. This
        // will make sure that only one item or one radio is selected on the
        // group.
        ButtonGroup group = new ButtonGroup();
        group.add(button1);
        group.add(button2);
        group.add(button3);
        group.add(button4);

        getContentPane().add(button1);
        getContentPane().add(button2);
        getContentPane().add(button3);
        getContentPane().add(button4);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ButtonGroupDemo().setVisible(true);
            }
        });
    }
}

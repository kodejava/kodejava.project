package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RadioButtonCreateAction extends JFrame {
    public RadioButtonCreateAction() {
        initializeUI();
    }

    private void initializeUI() {
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        Action action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                JRadioButton button = (JRadioButton) e.getSource();
                System.out.println("actionPerformed " + button.getText());
            }
        };

        // Create a radio button and pass an AbstractAction as it constructor.
        // The action will be call everytime the radio button is clicked or
        // pressed. But when it selected programmatically the action will not
        // called.
        JRadioButton button = new JRadioButton(action);
        button.setText("Click Me!");
        button.setSelected(true);

        getContentPane().add(button);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RadioButtonCreateAction().setVisible(true);
            }
        });
    }
}

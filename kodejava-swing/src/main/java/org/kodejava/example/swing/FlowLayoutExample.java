package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutExample extends JFrame {
    public FlowLayoutExample() {
        initialize();
    }

    private void initialize() {
        setSize(250, 150);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Create a new FlowLayout manager and set the component arrangement to
        // left justified. The other arrangement if FlowLayout.CENTER,
        // FlowLayout.RIGHT, FlowLayout.LEADING and FlowLayout.TRAILING.
        FlowLayout layoutManager = new FlowLayout(FlowLayout.RIGHT);

        // Set the horizontal and vertical gap between component laid in the
        // content pane to 10 pixels.
        layoutManager.setHgap(10);
        layoutManager.setVgap(10);
        setLayout(layoutManager);

        // Set the container's component orientation from the right to left.
        // This make the first component placed on the right top part of the
        // container.
        getContentPane().setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        // Adds some textfields the the frame panel.
        JTextField[][] textFields = new JTextField[3][3];
        for (int i = 0; i < textFields.length; i++) {
            for (int j = 0; j < textFields[i].length; j++) {
                textFields[i][j] = new JTextField(5);
                textFields[i][j].setText(String.valueOf(((i + 1) * (j + 1))));

                getContentPane().add(textFields[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FlowLayoutExample().setVisible(true);
            }
        });
    }
}

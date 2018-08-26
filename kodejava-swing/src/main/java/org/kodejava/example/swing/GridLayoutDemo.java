package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;

public class GridLayoutDemo extends JFrame {
    public GridLayoutDemo() {
        initializeUI();
    }

    private void initializeUI() {
        setSize(300,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Create a four by four GridLayout with 5 pixel horizontal and vertical
        // gap between each row or column.
        GridLayout grid = new GridLayout(4, 4, 5, 5);
        //grid.setColumns(4);
        //grid.setRows(4);
        //grid.setHgap(5);
        //grid.setVgap(5);

        setLayout(grid);

        JTextField[][] textFields = new JTextField[4][4];
        for (int i = 0; i < textFields.length; i++) {
            for (int j = 0; j < textFields[i].length; j++) {
                textFields[i][j] = new JTextField(String.valueOf((i + 1) * (j + 1)));
                // Put the text at the center of the JTextField component
                textFields[i][j].setHorizontalAlignment(SwingConstants.CENTER);

                getContentPane().add(textFields[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GridLayoutDemo().setVisible(true);
            }
        });
    }
}

package org.kodejava.example.swing;

import javax.swing.*;

public class CenteredJFrameSecond {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CenteredJFrame frame = new CenteredJFrame();
                frame.setTitle("Centered JFrame");
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setSize(250, 250);

                // Place the window in the center of the screen.
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}

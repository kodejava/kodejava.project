package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;

public class CenteredJFrame extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Get the size of the screen
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

                CenteredJFrame frame = new CenteredJFrame();
                frame.setTitle("Centered JFrame");
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setSize(250, 250);

                // Calculates the position where the CenteredJFrame
                // should be paced on the screen.
                int x = (screenSize.width - frame.getWidth()) / 2;
                int y = (screenSize.height - frame.getHeight()) / 2;
                frame.setLocation(x, y);
                frame.setVisible(true);
            }
        });
    }
}

package org.kodejava.example.swing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class FrameIconExample extends JFrame {
    public static void main(String[] args) {
        FrameIconExample frame = new FrameIconExample();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Set the window size and its title
        frame.setSize(new Dimension(250, 250));
        frame.setTitle("Frame Icon Example");

        // Read the image that will be used as the application icon.
        // Using "/" in front of the image file name will locate the
        // image at the root folder of our application. If you don't
        // use a "/" then the image file should be on the same folder
        // with your class file.
        try {
            URL resource = frame.getClass().getResource("/logo.png");
            BufferedImage image = ImageIO.read(resource);
            frame.setIconImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Display the form
        frame.setVisible(true);
    }
}

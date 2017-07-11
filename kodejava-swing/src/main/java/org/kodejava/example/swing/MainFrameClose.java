package org.kodejava.example.swing;

import javax.swing.*;

public class MainFrameClose extends JFrame {
    public static void main(String[] args) {
        MainFrameClose frame = new MainFrameClose();
        frame.setSize(250, 250);

        // Be defining the default close operation of a JFrame to
        // EXIT_ON_CLOSE the application will be exited by calling
        // System.exit() when user initiate a close event on the
        // frame.
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

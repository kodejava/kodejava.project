package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;

public class ChangeCursorDemo extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ChangeCursorDemo frame = new ChangeCursorDemo();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setSize(250, 250);

                // Here we create a hand shaped cursor!
                Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
                frame.setCursor(cursor);
                frame.setVisible(true);
            }
        });
    }
}

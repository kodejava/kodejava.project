package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;

public class ToolTipExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tool Tip Demo");
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hover on me!");
        // Setting tool tip for our Swing JLabel component
        label.setToolTipText("My JLabel Tool Tip");

        frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.getContentPane().add(label);
        frame.setVisible(true);
    }
}

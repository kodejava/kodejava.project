package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;

public class MultilineToolTip {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Tool Tip Demo");
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hover on me!");

        // Setting tool tip for our Swing JLabel component using an html
        // formatted string so that we can create a multi lines tool tip.
        label.setToolTipText(
            "<html>Lorem Ipsum is simply dummy text of the printing and<br/>" +
                "typesetting industry. Lorem Ipsum has been the industry's <br/>" +
                "standard dummy text ever since the 1500s, when an unknown<br/>" +
                "printer took a galley of type and scrambled it to make a<br/>" +
                "type specimen book.</html>");

        frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.getContentPane().add(label);
        frame.setVisible(true);
    }
}

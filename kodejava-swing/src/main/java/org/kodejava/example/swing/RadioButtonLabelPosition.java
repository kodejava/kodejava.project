package org.kodejava.example.swing;

import javax.swing.*;

public class RadioButtonLabelPosition {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        // Create JRadioButton with label on the right
        JRadioButton button1 = new JRadioButton("Button One");
        button1.setHorizontalTextPosition(SwingConstants.RIGHT);

        // Create JRadioButton with label on the left
        JRadioButton button2 = new JRadioButton("Button Two");
        button2.setHorizontalTextPosition(SwingConstants.LEFT);

        // Create JRadioButton with label at the bottom centered.
        JRadioButton button3 = new JRadioButton("Button Three");
        button3.setVerticalTextPosition(SwingConstants.BOTTOM);
        button3.setHorizontalTextPosition(SwingConstants.CENTER);

        // Create JRadioButton with label at the top centered.
        JRadioButton button4 = new JRadioButton("Button Four");
        button4.setVerticalTextPosition(SwingConstants.TOP);
        button4.setHorizontalTextPosition(SwingConstants.CENTER);

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);

        frame.add(panel);
        frame.setSize(300, 300);
        frame.pack();
        frame.setVisible(true);
    }
}

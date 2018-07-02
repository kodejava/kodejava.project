package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;

public class JLabelHTMLStyle extends JFrame {
    public JLabelHTMLStyle() {
        setTitle("JLabel with HTML Style");
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400, 200);
        Container container = getContentPane();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Create a JLabel object that display a string formatted using HTML.
        // 14 font size with red and italic.
        String text = "<html>" +
            "<font size='16' color='orange'><strong>Hello World</strong></font>" +
            "</html>";
        JLabel label = new JLabel(text);
        container.add(label);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JLabelHTMLStyle().setVisible(true));
    }
}

package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;

public class TextAreaFontDemo extends JPanel {
    public TextAreaFontDemo() {
        initializeUI();
    }

    private void initializeUI() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(593, 200));

        JTextArea textArea = new JTextArea(5, 40);
        textArea.setLineWrap(true);
        textArea.setText("The quick brown fox jumps over the lazy dog.");

        // Sets JTextArea font and color.
        Font font = new Font("Segoe Script", Font.BOLD, 20);
        textArea.setFont(font);
        textArea.setForeground(Color.BLUE);
        JScrollPane scrollPane = new JScrollPane(textArea);

        this.add(scrollPane, BorderLayout.CENTER);
    }

    private static void showFrame() {
        JPanel panel = new TextAreaFontDemo();
        panel.setOpaque(true);

        JFrame frame = new JFrame("JTextArea Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TextAreaFontDemo.showFrame();
            }
        });
    }
}

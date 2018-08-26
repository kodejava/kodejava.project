package org.kodejava.example.swing;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class TitledBorderExample extends JFrame {
    public TitledBorderExample() {
        initializeUI();
    }

    private void initializeUI() {
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        TitledBorder border = new TitledBorder(" Form Data ");
        border.setTitleJustification(TitledBorder.LEFT);
        border.setTitlePosition(TitledBorder.TOP);

        JPanel panel = new JPanel();
        panel.setBorder(border);
        panel.setLayout(new GridLayout(1, 2));

        JLabel usernameLabel = new JLabel("Username: ");
        JTextField usernameField = new JTextField();
        panel.add(usernameLabel);
        panel.add(usernameField);

        setContentPane(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TitledBorderExample().setVisible(true);
            }
        });
    }
}

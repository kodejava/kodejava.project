package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;

public class ButtonImageExample extends JFrame {
    public ButtonImageExample() {
        initComponents();
    }

    private void initComponents() {
        setTitle("My Buttons");
        setSize(200, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));

        // Creates two JButton object with an images to display. The image can be
        // a gif, jpeg, png and some other type supported. And we also set the
        // mnemonic character of the button for short-cut key.
        JButton okButton = new JButton("OK", new ImageIcon("ok.png"));
        okButton.setMnemonic('O');
        JButton cancelButton = new JButton("Cancel", new ImageIcon("cancel.png"));
        cancelButton.setMnemonic('C');

        getContentPane().add(okButton);
        getContentPane().add(cancelButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ButtonImageExample().setVisible(true);
            }
        });
    }
}

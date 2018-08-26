package org.kodejava.example.swing;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;

public class CompoundBorderExample extends JFrame {
    public CompoundBorderExample() {
        initializeUI();
    }

    private void initializeUI() {
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        BevelBorder raisedBevel = (BevelBorder) BorderFactory.createBevelBorder(BevelBorder.RAISED);
        BevelBorder loweredBevel = (BevelBorder) BorderFactory.createBevelBorder(BevelBorder.LOWERED);

        Border border = BorderFactory.createCompoundBorder(raisedBevel, loweredBevel);
        JPanel panel = new JPanel();
        panel.setBorder(border);

        setContentPane(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CompoundBorderExample().setVisible(true);
            }
        });
    }
}

package org.kodejava.example.geom;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class GradientPaintDemo extends JComponent {
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        GradientPaint blackToGray = new GradientPaint(50, 50, Color.BLACK,
            300, 100, Color.LIGHT_GRAY);
        g2.setPaint(blackToGray);
        g2.fill(new Rectangle2D.Double(50, 50, 300, 100));

        GradientPaint blueToBlack = new GradientPaint(0, 0, Color.BLUE,
            400, 400, Color.BLACK);
        g2.setPaint(blueToBlack);
        g2.fill(new Rectangle2D.Double(50, 160, 300, 100));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gradient Paint Demo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(new GradientPaintDemo());
        frame.pack();
        frame.setSize(new Dimension(420, 350));
        frame.setVisible(true);
    }
}

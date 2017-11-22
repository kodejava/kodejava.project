package org.kodejava.example.geom;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class DrawEllipse extends JComponent {
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setPaint(Color.RED);
        g2.setStroke(new BasicStroke(5.0f));
        g2.draw(new Ellipse2D.Double(50, 50, 250, 250));

        g2.setPaint(Color.BLUE);
        g2.fill(new Ellipse2D.Double(10, 10, 40, 40));

        g2.setPaint(Color.YELLOW);
        g2.fill(new Ellipse2D.Double(10, 300, 40, 40));

        g2.setPaint(Color.GREEN);
        g2.fill(new Ellipse2D.Double(300, 300, 40, 40));

        g2.setPaint(Color.ORANGE);
        g2.fill(new Ellipse2D.Double(300, 10, 40, 40));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw Ellipse Demo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(new DrawEllipse());
        frame.pack();
        frame.setSize(new Dimension(420, 400));
        frame.setVisible(true);
    }
}

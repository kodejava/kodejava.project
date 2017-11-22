package org.kodejava.example.geom;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class DrawGeneralPath extends JComponent {
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.setStroke(new BasicStroke(4.0f));
        g2.setPaint(Color.GREEN);

        int[] xPoints = {10, 50, 100, 150, 200, 250, 300, 350};
        int[] yPoints = {10, 50,  10,  50,  10,  50,  10,  50};
        GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD,
            xPoints.length);

        // Adds point to the path by moving to the specified
        // coordinates.
        path.moveTo(xPoints[0], yPoints[0]);
        for (int i = 1; i < xPoints.length; i++) {
            // Adds a point to the path by drawing a straight
            // line from the current position to the specified
            // coordinates.
            path.lineTo(xPoints[i], yPoints[i]);
        }
        path.curveTo(150, 150, 300, 300, 50, 250);
        path.closePath();
        g2.draw(path);

        // Draw another path, a start
        g2.setPaint(Color.RED);
        g2.setStroke(new BasicStroke(2.0f));
        path = new GeneralPath(GeneralPath.WIND_NON_ZERO);
        path.moveTo(200, 50);
        path.lineTo(270, 300);
        path.lineTo(100, 120);
        path.lineTo(300, 120);
        path.lineTo(130, 300);
        path.closePath();
        g2.draw(path);

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw GeneralPath Demo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(new DrawGeneralPath());
        frame.pack();
        frame.setSize(new Dimension(420, 400));
        frame.setVisible(true);
    }
}

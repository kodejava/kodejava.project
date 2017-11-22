package org.kodejava.example.geom;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class DrawStrokeDemo extends JComponent {
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        float[] strokes = {1, 2, 3, 4, 5, 6};
        for (float stroke : strokes) {
            g2.setStroke(new BasicStroke(stroke));
            g2.draw(new Line2D.Float(50, stroke * 20, 350, stroke * 20));
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Draw Stroke Demo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(new DrawStrokeDemo());
        frame.pack();
        frame.setSize(new Dimension(420, 200));
        frame.setVisible(true);
    }
}

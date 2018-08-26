package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GetFrameDemo extends JFrame {
    public GetFrameDemo() throws HeadlessException {
        initialize();
    }

    private void initialize() {
        this.setSize(400, 100);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        final JLabel rLabel = new JLabel("r: ");
        final JLabel gLabel = new JLabel("g: ");
        final JLabel bLabel = new JLabel("b: ");

        JButton button = new JButton("Change Frame Background Color");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Component component = (Component) e.getSource();

                // Returns the root component for the current component tree
                JFrame frame = (JFrame) SwingUtilities.getRoot(component);

                int r = (int) (Math.random() * 255);
                int g = (int) (Math.random() * 255);
                int b = (int) (Math.random() * 255);

                rLabel.setText("r: " + r);
                gLabel.setText("g: " + g);
                bLabel.setText("b: " + b);

                frame.getContentPane().setBackground(new Color(r, g, b));
            }
        });

        this.getContentPane().add(button);
        this.getContentPane().add(rLabel);
        this.getContentPane().add(gLabel);
        this.getContentPane().add(bLabel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new GetFrameDemo().setVisible(true);
            }
        });
    }
}

package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;

public class TabbedPaneWithIcon extends JPanel {
    private TabbedPaneWithIcon() {
        initializeUI();
    }

    private static void showFrame() {
        JPanel panel = new TabbedPaneWithIcon();
        panel.setOpaque(true);

        JFrame frame = new JFrame("Tabbed Pane With Icon Demo");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TabbedPaneWithIcon.showFrame();
            }
        });
    }

    private void initializeUI() {
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(400, 200));

        JTabbedPane pane = new JTabbedPane();

        ImageIcon tab1Icon = new ImageIcon(
            this.getClass().getResource("/images/test-pass-icon.png"));
        ImageIcon tab2Icon = new ImageIcon(
            this.getClass().getResource("/images/test-fail-icon.png"));
        ImageIcon tab3Icon = new ImageIcon(
            this.getClass().getResource("/images/test-error-icon.png"));

        JPanel content1 = new JPanel();
        JPanel content2 = new JPanel();
        JPanel content3 = new JPanel();

        pane.addTab("Pass", tab1Icon, content1);
        pane.addTab("Fail", tab2Icon, content2);
        pane.addTab("Error", tab3Icon, content3);

        this.add(pane, BorderLayout.CENTER);
    }
}

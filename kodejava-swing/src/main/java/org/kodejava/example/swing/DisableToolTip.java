package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisableToolTip extends JFrame {
    public DisableToolTip() throws HeadlessException {
        initComponent();
    }

    private void initComponent() {
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton disable = new JButton("DISABLE");
        disable.setToolTipText("Application tool tip will be disabled.");
        disable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Disable tool tip for the entire application
                ToolTipManager.sharedInstance().setEnabled(false);
            }
        });

        JButton enable = new JButton("ENABLE");
        enable.setToolTipText("Application tool tip will be enabled.");
        enable.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Enable tool tip for the entire application
                ToolTipManager.sharedInstance().setEnabled(true);
            }
        });

        getContentPane().add(enable);
        getContentPane().add(disable);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DisableToolTip().setVisible(true);
            }
        });
    }
}

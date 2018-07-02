package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingWorkerDemo extends JFrame {

    public SwingWorkerDemo() {
        initialize();
    }

    private void initialize() {
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton processButton = new JButton("Start");
        JButton helloButton = new JButton("Hello");

        processButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                LongRunProcess process = new LongRunProcess();
                try {
                    process.execute();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        helloButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Hello There");
            }
        });


        this.getContentPane().add(processButton);
        this.getContentPane().add(helloButton);

        this.pack();
        this.setSize(new Dimension(300, 80));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SwingWorkerDemo().setVisible(true);
            }
        });
    }

    class LongRunProcess extends SwingWorker {
        protected Object doInBackground() {
            Integer result = 0;
            for (int i = 0; i < 10; i++) {
                try {
                    result += i * 10;
                    System.out.println("Result = " + result);

                    // Sleep for a while to simulate a long process
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return result;
        }
    }
}

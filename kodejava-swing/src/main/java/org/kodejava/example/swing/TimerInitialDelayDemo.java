package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TimerInitialDelayDemo extends JFrame {
    private JLabel counterLabel = new JLabel();

    private Timer timer = null;

    public TimerInitialDelayDemo() throws HeadlessException {
        initUI();
    }

    private void initUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(200, 200);

        Container container = getContentPane();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        container.add(counterLabel);

        timer = new Timer(1000, new MyActionListener());

        // Set initial delay of the Timer object. Setting initial delay
        // to zero causes the timer fires the event immediately after
        // it is started.
        timer.setInitialDelay(0);
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TimerInitialDelayDemo().setVisible(true);
            }
        });
    }

    class MyActionListener implements ActionListener {
        private int counter = 10;

        public void actionPerformed(ActionEvent e) {
            counter = counter - 1;
            String text = "<html><font size=\"14\">" +
                String.valueOf(counter) +
                "</font></head>";
            counterLabel.setText(text);
            if (counter == 0) {
                timer.stop();
            }
        }
    }
}

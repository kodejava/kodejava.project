package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TimerDemo extends JFrame {
    public static final DateFormat df = new SimpleDateFormat("hh:mm:ss");

    public TimerDemo() throws HeadlessException {
        initUI();
    }

    private void initUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(200, 200);

        Container container = getContentPane();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        final JLabel label = new JLabel();
        container.add(label);

        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Calendar now = Calendar.getInstance();
                String timeText = "<html><font size=\"6\" color=\"blue\">" +
                    df.format(now.getTime()) +
                    "</font></html>";
                label.setText(timeText);
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TimerDemo().setVisible(true);
            }
        });
    }
}

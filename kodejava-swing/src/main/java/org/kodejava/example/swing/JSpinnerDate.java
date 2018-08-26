package org.kodejava.example.swing;

import javax.swing.*;
import java.awt.*;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class JSpinnerDate extends JFrame {
    public JSpinnerDate() {
        initializeUI();
    }

    private void initializeUI() {
        setSize(300, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create a SpinnerDateModel with current date as the initial value.
        SpinnerDateModel model = new SpinnerDateModel();

        // Set the spinner value to June 8, 2008.
        JSpinner spinner = new JSpinner(model);
        Calendar calendar = new GregorianCalendar(2008, Calendar.JUNE, 8);
        spinner.setValue(calendar.getTime());

        getContentPane().add(spinner, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JSpinnerDate().setVisible(true);
            }
        });
    }
}

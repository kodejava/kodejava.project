package org.kodejava.example.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerExample extends TimerTask {
    private DateFormat formatter = new SimpleDateFormat("hh:mm:ss a");

    public static void main(String[] args) {
        // Create an instance of TimerTask implementor.
        TimerTask task = new TimerExample();

        // Create a new timer to schedule the TimerExample instance at a
        // periodic time every 5000 milliseconds (5 seconds) and start it
        // immediately
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, new Date(), 5000);
    }

    /**
     * This method is the implementation of a contract defined in the 
     * TimerTask class. This in the entry point of the task execution.
     */
    public void run() {
        // To make the example simple we just print the current time.
        System.out.println(formatter.format(new Date()));
    }
}

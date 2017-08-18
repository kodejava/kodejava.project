package org.kodejava.example.lang;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeThread implements Runnable {
    private DateFormat df = new SimpleDateFormat("hh:mm:ss");

    // The run() method will be invoked when the thread of this runnable object
    // is started.
    @Override
    public void run() {
        while (true) {
            Calendar calendar = Calendar.getInstance();
            System.out.format("Now is: %s.%n", df.format(calendar.getTime()));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TimeThread time = new TimeThread();

        Thread thread = new Thread(time);
        thread.start();
    }
}

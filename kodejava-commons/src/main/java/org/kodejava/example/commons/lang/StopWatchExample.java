package org.kodejava.example.commons.lang;

import org.apache.commons.lang3.time.StopWatch;

public class StopWatchExample {
    public static void main(String[] args) {
        StopWatchExample demo = new StopWatchExample();
        demo.timingOne();
    }

    private void timingOne() {
        // Create an instance of StopWatch.
        StopWatch stopWatch = new StopWatch();

        // Start the watch, do some task and stop the watch.
        stopWatch.start();
        doSomeTask(5000);
        stopWatch.stop();

        // Print out the total time of the watch
        System.out.println("Time: " + stopWatch.getTime());
    }

    private void doSomeTask(long sleep) {
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

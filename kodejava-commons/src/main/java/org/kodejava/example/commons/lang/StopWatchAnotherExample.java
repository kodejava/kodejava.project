package org.kodejava.example.commons.lang;

import org.apache.commons.lang3.time.StopWatch;

public class StopWatchAnotherExample {
    public static void main(String[] args) {
        StopWatchAnotherExample demo = new StopWatchAnotherExample();
        demo.timingTwo();
    }

    private void timingTwo() {
        // Create an instance of StopWatch and start the stopwatch.
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // Do some task and split the stopwatch time.
        doSomeTask(3000);
        stopWatch.split();
        System.out.println("Split 1: " + stopWatch.toSplitString());

        // Suspend the stopwatch and resume the stopwatch.
        stopWatch.suspend();
        doSomeTask(4000);
        stopWatch.resume();

        // Do some task and split the stopwatch time.
        doSomeTask(2500);
        stopWatch.split();
        System.out.println("Split 2: " + stopWatch.toSplitString());

        // Do some task and split the stopwatch time.
        doSomeTask(1000);
        stopWatch.split();
        System.out.println("Split 3: " + stopWatch.toSplitString());

        // Stop the stopwatch and the the total execution time.
        stopWatch.stop();
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

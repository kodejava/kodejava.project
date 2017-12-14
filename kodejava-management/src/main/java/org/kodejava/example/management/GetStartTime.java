package org.kodejava.example.management;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Date;

public class GetStartTime {
    public static void main(String[] args) {
        RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();

        // Returns the start time of the Java virtual machine in 
        // milliseconds. This method returns the approximate time 
        // when the Java virtual machine started.
        long startTime = bean.getStartTime();
        Date startDate = new Date(startTime);
        System.out.println("Start Time = " + startTime);
        System.out.println("Start Date = " + startDate);
    }
}

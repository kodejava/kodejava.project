package org.kodejava.example.management;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class GetUpTime {
    public static void main(String[] args) {
        RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();

        // Returns the up time of the Java virtual machine in
        // milliseconds.
        long upTime = bean.getUptime();
        System.out.printf("Up Time = %d (ms)", upTime);
    }
}

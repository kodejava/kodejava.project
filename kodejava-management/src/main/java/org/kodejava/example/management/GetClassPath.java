package org.kodejava.example.management;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class GetClassPath {
    public static void main(String[] args) {
        RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
        String classPath = bean.getClassPath();
        System.out.println("ClassPath = " + classPath);
    }
}

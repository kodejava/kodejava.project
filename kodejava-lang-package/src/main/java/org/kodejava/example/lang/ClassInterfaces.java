package org.kodejava.example.lang;

import java.util.Date;
import java.util.Calendar;

public class ClassInterfaces {
    public static void main(String[] args) {
        // Get an instance of Date class
        Date date = Calendar.getInstance().getTime();

        // Get all interfaces implemented by the java.util.Date class and
        // print their names.
        Class[] interfaces = date.getClass().getInterfaces();
        for (Class iface : interfaces) {
            System.out.println("Interface Name = " + iface.getName());
        }

        // For the primitive type the interface will be an empty array.
        Class c = char.class;
        interfaces = c.getInterfaces();
        for (Class iface : interfaces) {
            System.out.println("Interface Name = " + iface.getName());
        }
    }
}

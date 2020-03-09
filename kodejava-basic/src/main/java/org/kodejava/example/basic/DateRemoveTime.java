package org.kodejava.example.basic;

import java.util.Calendar;
import java.util.Date;

public class DateRemoveTime {
    public static void main(String[] args) {
        System.out.println("Now = " + removeTime(new Date()));
    }

    private static Date removeTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
}

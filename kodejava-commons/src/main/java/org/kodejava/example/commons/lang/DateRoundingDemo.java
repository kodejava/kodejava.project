package org.kodejava.example.commons.lang;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang.time.FastDateFormat;

import java.util.Calendar;
import java.util.Date;

public class DateRoundingDemo {
    public static void main(String[] args) {
        FastDateFormat formatter = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT;

        Date now = new Date();
        System.out.println("now = " + formatter.format(now));

        // Get nearest second
        Date nearestSecond = DateUtils.round(now, Calendar.SECOND);
        System.out.println("nearestSecond = " + formatter.format(nearestSecond));

        // Get nearest minute
        Date nearestMinute = DateUtils.round(now, Calendar.MINUTE);
        System.out.println("nearestMinute = " + formatter.format(nearestMinute));

        // Get nearest hour
        Date nearestHour = DateUtils.round(now, Calendar.HOUR);
        System.out.println("nearestHour = " + formatter.format(nearestHour));
    }
}

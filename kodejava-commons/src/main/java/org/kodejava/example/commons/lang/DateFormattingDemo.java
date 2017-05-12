package org.kodejava.example.commons.lang;

import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;

public class DateFormattingDemo {
    public static void main(String[] args) {
        Date today = new Date();

        // ISO8601 formatter for date-time without time zone.
        // The format used is yyyy-MM-dd'T'HH:mm:ss.
        String timestamp = DateFormatUtils.ISO_DATETIME_FORMAT.format(today);
        System.out.println("timestamp = " + timestamp);

        // ISO8601 formatter for date-time with time zone.
        // The format used is yyyy-MM-dd'T'HH:mm:ssZZ.
        timestamp = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(today);
        System.out.println("timestamp = " + timestamp);

        // The format used is EEE, dd MMM yyyy HH:mm: ss Z in US locale.
        timestamp = DateFormatUtils.SMTP_DATETIME_FORMAT.format(today);
        System.out.println("timestamp = " + timestamp);
    }
}

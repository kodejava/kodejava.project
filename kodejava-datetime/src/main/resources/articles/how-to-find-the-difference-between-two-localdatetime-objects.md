# How to find the difference between two LocalDateTime objects?

In the previous post, [How do I find the difference between two times?](//kodejava.org/how-do-i-find-the-difference-between-two-times/), we get the difference between two `LocalTime` objects in seconds measurement. In this example we will get the difference between two `LocalDateTime` objects and get the difference between these objects in years, months, days, hours, minutes, seconds and milliseconds.

```java
package org.kodejava.example.datetime;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeDiff {
    public static void main(String[] args) {
        LocalDateTime from = LocalDateTime.of(2015, Month.JANUARY, 10, 10, 0, 30);
        LocalDateTime to = LocalDateTime.now();

        LocalDateTime fromTemp = LocalDateTime.from(from);
        long years = fromTemp.until(to, ChronoUnit.YEARS);
        fromTemp = fromTemp.plusYears(years);

        long months = fromTemp.until(to, ChronoUnit.MONTHS);
        fromTemp = fromTemp.plusMonths(months);

        long days = fromTemp.until(to, ChronoUnit.DAYS);
        fromTemp = fromTemp.plusDays(days);

        long hours = fromTemp.until(to, ChronoUnit.HOURS);
        fromTemp = fromTemp.plusHours(hours);

        long minutes = fromTemp.until(to, ChronoUnit.MINUTES);
        fromTemp = fromTemp.plusMinutes(minutes);

        long seconds = fromTemp.until(to, ChronoUnit.SECONDS);
        fromTemp = fromTemp.plusSeconds(seconds);

        long millis = fromTemp.until(to, ChronoUnit.MILLIS);

        System.out.println("From = " + from);
        System.out.println("To   = " + to);
        System.out.printf("The difference is %s years, %s months, %s days, " +
                        "%s hours, %s minutes, %s seconds, %s millis",
                years, months, days, hours, minutes, seconds, millis);
    }
}
```

The result of the code snippet above when executed is:

```text
From = 2015-01-10T10:00:30
To   = 2016-02-11T17:20:40.503
The difference is 1 years, 1 months, 1 days, 7 hours, 20 minutes, 10 seconds, 503 millis
```

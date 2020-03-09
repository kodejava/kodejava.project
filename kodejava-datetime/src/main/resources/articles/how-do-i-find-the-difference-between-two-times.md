# How do I find the difference between two times?

The following code snippet show you how to find the difference between two time objects represented by `LocalTime` class. To get the difference between two `LocalTime` objects we can use the `Duration.between()` method. This method returns a `Duration` object, to get the difference in seconds we call the `getSeconds()` method.

Here a code snippet to demonstrate it.

```java
package org.kodejava.example.datetime;

import java.time.*;

public class TimeDifference {
    public static void main(String[] args) {
        LocalTime start = LocalTime.now();
        LocalTime end = LocalTime.of(16, 59, 55);
        Duration duration = Duration.between(start, end);

        System.out.printf("Seconds between %s and %s is: %s seconds.%n",
                start, end, duration.getSeconds());

        diffLocalDateTime();
        diffInstant();
    }

    /**
     * Difference between two LocalDateTime objects.
     */
    public static void diffLocalDateTime() {
        LocalDateTime dt1 = LocalDateTime.now();
        LocalDateTime dt2 = LocalDateTime.now(ZoneId.of("GMT+0"));
        Duration duration = Duration.between(dt1, dt2);
        System.out.printf("Duration = %s seconds.%n", duration.getSeconds());
    }

    /**
     * Difference between two Instant objects.
     */
    public static void diffInstant() {
        Instant instant1 = Instant.now();
        Instant instant2 = Instant.EPOCH;
        Duration duration = Duration.between(instant1, instant2);
        System.out.printf("Duration = %s seconds.%n", duration.getSeconds());
    }
}
```

Using the `Duration.between()` we can also get the difference between two `LocalDateTime` objects and two `Instant` object as seen in the `diffLocalDateTime()` method and `diffInstant` method in the code snippet above.

The result of the code snippet:

```text
Seconds between 16:58:15.863 and 16:59:55 is: 99 seconds.
Duration = -28800 seconds.
Duration = -1455181096 seconds.
```

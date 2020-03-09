package org.kodejava.example.lang;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class StringAlignment {
    private static Object[][] people = {
        {"Alice", LocalDate.of(2000, Month.JANUARY, 1)},
        {"Bob", LocalDate.of(1989, Month.DECEMBER, 15)},
        {"Carol", LocalDate.of(1992, Month.JULY, 24)},
        {"Ted", LocalDate.of(2006, Month.MARCH, 13)},
    };

    public static void main(String[] args) {
        String nameFormat = "| %1$-20s | ";
        String dateFormat = " %2$tb %2$td, %2$tY  | ";
        String ageFormat = " %3$3s |%n";
        String format = nameFormat.concat(dateFormat).concat(ageFormat);
        String line = new String(new char[48]).replace("\u0000", "-");

        System.out.println(line);
        System.out.printf("|%s|%s|%s|%n",
            StringUtils.center("Name", 22),
            StringUtils.center("Birth Date", 16),
            StringUtils.center("Age", 6));
        System.out.println(line);

        for (Object[] data : people) {
            System.out.printf(format,
                data[0], data[1],
                ChronoUnit.YEARS.between((LocalDate) data[1], LocalDate.now()));
        }

        System.out.println(line);
    }
}

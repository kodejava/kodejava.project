package org.kodejava.example.jdbc;

import java.sql.*;

public class DriverPropertyInfoDemo {
    private static final String URL = "jdbc:mysql://localhost/kodejava";

    public static void main(String[] args) {
        try {
            // Gets information about the possible properties for this
            // driver.
            Driver driver = DriverManager.getDriver(URL);
            DriverPropertyInfo[] props = driver.getPropertyInfo(URL, null);

            for (DriverPropertyInfo info : props) {
                System.out.println("-----------------------------------");
                System.out.println("Name       : " + info.name);
                System.out.println("Description: " + info.description);
                System.out.println("Value      : " + info.value);

                String[] choices = info.choices;
                if (choices != null) {
                    StringBuilder sb = new StringBuilder("Choices    : ");
                    for (String choice : choices) {
                        sb.append(choice).append(",");
                    }

                    System.out.println(sb.toString());
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

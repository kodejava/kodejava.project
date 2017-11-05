package org.kodejava.example.util;

import java.util.Objects;

public class ObjectsNullCheckDemo {
    private String firstName;
    private String lastName;

    /**
     * Validate constructor arguments. The firstName and lastName
     * arguments can't be null. A NullPointerException with the
     * specified message will be thrown.
     */
    public ObjectsNullCheckDemo(String firstName, String lastName) {
        this.firstName = Objects.requireNonNull(firstName,
            "First name can't be null.");
        this.lastName = Objects.requireNonNull(lastName,
            "Last name can't be null.");
    }

    public void setFirstName(String firstName) {
        // First name can't be null.
        this.firstName = Objects.requireNonNull(firstName,
            "First name can't be null.");
    }

    public void setLastName(String lastName) {
        // Last name can't be null.
        this.lastName = Objects.requireNonNull(lastName,
            "Last name can't be null.");
    }

    public static void main(String[] args) {
        // This line is fine.
        ObjectsNullCheckDemo demo = new ObjectsNullCheckDemo("John", "Doe");
        System.out.println("demo = " + demo);

        try {
            // This line produce a NullPointerException
            ObjectsNullCheckDemo demo1 = new ObjectsNullCheckDemo("Alice", null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String name = null;
        try {
            // The line below will throw java.lang.NullPointerException.
            Objects.requireNonNull(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "ObjectsNullCheckDemo{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
    }
}

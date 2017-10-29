package org.kodejava.example.util;

import org.kodejava.example.util.support.Person;

import java.util.Arrays;

public class ObjectSortExample {
    public static void main(String[] args) {
        String names[] = {"Bob", "Mallory", "Alice", "Carol"};
        Arrays.sort(names);
        System.out.println("Names = " + Arrays.toString(names));

        Person persons[] = new Person[4];
        persons[0] = new Person("Bob");
        persons[1] = new Person("Mallory");
        persons[2] = new Person("Alice");
        persons[3] = new Person("Carol");
        Arrays.sort(persons);
        System.out.println("Persons = " + Arrays.toString(persons));
    }
}

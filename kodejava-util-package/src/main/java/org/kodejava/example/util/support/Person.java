package org.kodejava.example.util.support;

public class Person implements Comparable {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public int compareTo(Object o) {
        Person p = (Person) o;
        return this.name.compareTo(p.name);
    }

    public String toString() {
        return name;
    }
}

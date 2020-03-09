package org.kodejava.example.lombok;

import org.kodejava.example.lombok.domain.Person;

public class PersonDemo {
    public static void main(String[] args) {
        Person person = new Person();
        person.setLastName("Bar");
        person.setGender("M");
        person.setAge(20);

        System.out.println(person.getFirstName());
        System.out.println(person.getLastName());
        System.out.println(person.getGender());
    }
}

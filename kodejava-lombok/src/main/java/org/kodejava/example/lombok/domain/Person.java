package org.kodejava.example.lombok.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Person {
    @Setter(AccessLevel.PROTECTED)
    private String firstName;

    private String lastName;
    private String gender;

    @Getter(AccessLevel.PRIVATE)
    private int age;
}

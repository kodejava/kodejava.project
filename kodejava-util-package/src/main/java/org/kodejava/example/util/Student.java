package org.kodejava.example.util;

import java.time.LocalDate;
import java.util.Objects;

public class Student {
    private Long id;
    private String name;
    private LocalDate dateOfBirth;

    public Student() {
    }

    public Student(Long id, String name, LocalDate dateOfBirth) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student that = (Student) o;
        return Objects.equals(this.id, that.id)
            && Objects.equals(this.name, that.name)
            && Objects.equals(this.dateOfBirth, that.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dateOfBirth);
    }
}

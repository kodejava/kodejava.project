    package org.kodejava.example.stream;

interface PersonFactory<P extends Person> {
    P build(String firstName, String lastName);
}

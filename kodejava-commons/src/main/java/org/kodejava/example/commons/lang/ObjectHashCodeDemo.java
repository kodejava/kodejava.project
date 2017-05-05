package org.kodejava.example.commons.lang;

public class ObjectHashCodeDemo {

    public static void main(String[] args) {
        Book book1 = new Book(1L, "Spring Boot in Action", "Craig Walls");
        Book book2 = new Book(2L, "Docker in Action", "Jeff Nickoloff");
        Book book3 = book1;

        System.out.println("book1.hashCode() = " + book1.hashCode());
        System.out.println("book2.hashCode() = " + book2.hashCode());
        System.out.println("book3.hashCode() = " + book3.hashCode());
    }
}

package org.kodejava.example.commons.lang;

public class ObjectEqualsDemo {
    public static void main(String[] args) {
        Book book1 = new Book(1L, "Spring Boot in Action", "Craig Walls");
        Book book2 = new Book(2L, "Docker in Action", "Jeff Nickoloff");
        Book book3 = book1;

        System.out.println("book1.equals(book2) = " + book1.equals(book2));
        System.out.println("book3.equals(book1) = " + book3.equals(book1));
    }
}

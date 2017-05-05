package org.kodejava.example.commons.lang;

public class CompareToBuilderDemo {
    public static void main(String[] args) {
        Fruit fruit1 = new Fruit("Orange", "Orange");
        Fruit fruit2 = new Fruit("Watermelon", "Red");

        if (fruit1.compareTo(fruit2) == 0) {
            System.out.printf("%s == %s%n", fruit1.getName(), fruit2.getName());
        } else {
            System.out.printf("%s != %s%n", fruit1.getName(), fruit2.getName());
        }
    }
}

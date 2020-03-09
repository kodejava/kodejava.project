package org.kodejava.example.commons.text;

import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;

public class RandomStringDemo {
    public static void main(String[] args) {
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
            .withinRange('0', 'z')
            .filteredBy(CharacterPredicates.DIGITS, CharacterPredicates.LETTERS)
            .build();

        for (int i = 0; i < 10; i++) {
            System.out.println(generator.generate(10, 20));
        }
    }
}

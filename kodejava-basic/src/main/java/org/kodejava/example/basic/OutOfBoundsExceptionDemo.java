package org.kodejava.example.basic;

public class OutOfBoundsExceptionDemo {
    public static void main(String[] args) {
        String[] vowels = new String[]{"a", "i", "u", "e", "o"};
//        String vowel = vowels[10]; // throws the ArrayIndexOutOfBoundsException

        for (int i = 0; i <= vowels.length; i++) {
            String vowel = vowels[i];
            System.out.println("vowel = " + vowel);
        }

        for (String vowel : vowels) {
            System.out.println("vowel = " + vowel);
        }
    }
}

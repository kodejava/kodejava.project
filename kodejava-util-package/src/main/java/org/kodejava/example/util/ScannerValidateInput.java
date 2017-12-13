package org.kodejava.example.util;

import java.util.Scanner;

public class ScannerValidateInput {
    public static void main(String[] args) {
        ScannerValidateInput demo = new ScannerValidateInput();
        demo.validatePositiveNumber();
        demo.validateLetter();
    }

    private void validatePositiveNumber() {
        Scanner scanner = new Scanner(System.in);

        int number;
        do {
            System.out.print("Please enter a positive number: ");
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
            }
            number = scanner.nextInt();
        } while (number < 0);

        System.out.printf("You have entered a positive number %d.\n", number);
    }

    private void validateLetter() {
        String guestWord = "Hello";
        Scanner scanner = new Scanner(System.in);

        int length = 0;
        StringBuilder guess = new StringBuilder();
        do {
            System.out.print("Enter a letter to guess: ");
            char letter = scanner.next().charAt(0);
            if (Character.isLetter(letter)) {
                guess.append(letter);
                length++;
            }
        } while (length < guestWord.length());

        if (guestWord.equals(guess.toString())) {
            System.out.println("You are correct!");
        } else {
            System.out.println("Please try again!");
        }
    }
}

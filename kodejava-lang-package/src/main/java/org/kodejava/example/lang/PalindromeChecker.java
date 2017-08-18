package org.kodejava.example.lang;

public class PalindromeChecker {

    public static void main(String[] args) {
        String text = "Sator Arepo Tenet Opera Rotas";

        PalindromeChecker checker = new PalindromeChecker();
        System.out.println("Is palindrome = " + checker.isPalindrome(text));
    }

    /**
     * This method checks the string for palindrome. We use StringBuilder to
     * reverse the original string.
     *
     * @param text
     * @return
     */
    private boolean isPalindrome(String text) {
        System.out.println("Original text = " + text);

        String reverse = new StringBuilder(text).reverse().toString();
        System.out.println("Reverse text  = " + reverse);

        // Compare the original text with the reverse one and ignoring its case
        return text.equalsIgnoreCase(reverse);
    }
}

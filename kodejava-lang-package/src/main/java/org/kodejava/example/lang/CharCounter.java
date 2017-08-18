package org.kodejava.example.lang;

public class CharCounter {
    public static void main(String[] args) {
        String text = "a,b,c,c,e,f,g,g,g,g,h";

        // Use the CharCounter.countCharOccurrences() method to count.
        int numberOfLetterC = CharCounter.countCharOccurrences(text, 'c');
        System.out.println("Letter c = " + numberOfLetterC);

        // Other solution is to use the String.replaceAll() method. We'll
        // replace the chars other than the counted char with an empty string.
        // To get the char occurrences we count the length of the remaining
        // string.
        int numberOfComma = text.replaceAll("[^,]", "").length();
        System.out.println("Comma    = " + numberOfComma);

        int numberOfLetterG = text.replaceAll("[^g]", "").length();
        System.out.println("Letter g = " + numberOfLetterG);
    }

    /**
     * Count number of specified char occurrences in the specified string.
     */
    private static int countCharOccurrences(String source, char target) {
        int counter = 0;

        // Loop through the string and increment the counter if the
        // target character found in the string. 
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == target) {
                counter++;
            }
        }
        return counter;
    }
}

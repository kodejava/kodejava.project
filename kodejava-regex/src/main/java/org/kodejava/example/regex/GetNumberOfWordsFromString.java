package org.kodejava.example.regex;

public class GetNumberOfWordsFromString {
    public static void main(String[] args) {
        String text = "The quick brown fox jumps over the lazy dog.";

        String one = truncateAfterWords(1, text);
        System.out.println("1 = " + one);

        String two = truncateAfterWords(2, text);
        System.out.println("2 = " + two);

        String four = truncateAfterWords(4, text);
        System.out.println("4 = " + four);

        String six = truncateAfterWords(6, text);
        System.out.println("6 = " + six);
    }

    /**
     * Truncate a string after n number of words.
     *
     * @param words number of words to truncate after.
     * @param text  the text.
     * @return truncated text.
     */
    public static String truncateAfterWords(int words, String text) {
        String regex = String.format("^((?:\\W*\\w+){%s}).*$", words);
        return text.replaceAll(regex, "$1");
    }
}

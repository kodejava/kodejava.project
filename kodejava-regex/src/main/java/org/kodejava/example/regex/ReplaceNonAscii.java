package org.kodejava.example.regex;

public class ReplaceNonAscii {
    public static void main(String[] args) {
        String str = "ThÃ¨ quÃ¯ck brÃ¸wn fÃ¸x jumps over the lÃ£zy dÃ´g.";
        System.out.println("str = " + str);

        // Replace all non ascii chars in the string.
        str = str.replaceAll("[^\\x0A\\x0D\\x20-\\x7E]", "");
        System.out.println("str = " + str);
    }
}

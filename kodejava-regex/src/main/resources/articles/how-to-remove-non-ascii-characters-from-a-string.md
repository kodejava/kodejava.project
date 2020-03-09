# How to remove non ASCII characters from a string?

The code snippet below remove the characters from a string that is not inside the range of `x20` and `x7E` ASCII code. The regex below strips non-printable and control characters. But it also keeps the linefeed character `n` (`x0A`) and the carriage return `r` (`x0D`) characters.

```java
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
```

Snippet output:

```text
str = ThÃ¨ quÃ¯ck brÃ¸wn fÃ¸x jumps over the lÃ£zy dÃ´g.
str = Th quck brwn fx jumps over the lzy dg.
```

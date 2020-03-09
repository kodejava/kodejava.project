# How do I write character class subtraction regex?

You can use subtraction to negate one or more nested character classes. This example creates a single character class that matches everything from a to z, except the vowels ('a', 'i', 'u', 'e', 'o'). This can be written in a subtraction pattern as `[a-z&&[^aiueo]]`.

```java
package org.kodejava.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterClassSubtractionDemo {
    public static void main(String[] args) {
        // Define regex that will search characters from 'a' to 'z'
        // and excluding vowels.
        String regex = "[a-z&&[^aiueo]]";

        // Compiles the given regular expression into a pattern and
        // Creates a matcher that will match the given input against
        // this pattern.
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("The quick brown fox.");

        // Find every match and print it
        while (matcher.find()) {
            System.out.format("Text \"%s\" found at %d to %d.%n",
                matcher.group(), matcher.start(), matcher.end());
        }
    }
}
```

Here are the result of the program:

```text
Text "h" found at 1 to 2.
Text "q" found at 4 to 5.
Text "c" found at 7 to 8.
Text "k" found at 8 to 9.
Text "b" found at 10 to 11.
Text "r" found at 11 to 12.
Text "w" found at 13 to 14.
Text "n" found at 14 to 15.
Text "f" found at 16 to 17.
Text "x" found at 18 to 19.
```

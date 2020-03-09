# How do I write character class intersection regex?

You can use the `&&` operator to combine classes that define a sets of characters. It will only match characters common to  both classes (intersection).

```java
package org.kodejava.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterClassIntersectionDemo {
    public static void main(String[] args) {
        // Define regex that will search characters from 'a' to 'z'
        // and is a 'c' or 'a' or 't' character.
        String regex = "[a-z&&[cat]]";

        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(
            "The quick brown fox jumps over the lazy dog");

        // Find every match and print it
        while (matcher.find()) {
            System.out.format("Text \"%s\" found at %d to %d.%n",
                matcher.group(), matcher.start(), matcher.end());
        }
    }
}
```

The program print the following result:

```text
Text "c" found at 7 to 8.
Text "t" found at 31 to 32.
Text "a" found at 36 to 37.
```

# How do I write simple character class regex?

A character class in the context of regular expression is a set of characters enclosed within a square brackets `"[]"`. It specifies the characters that will successfully match a single character from the given input.

A simple class, the most basic form of character class, is formed simply by placing a set of characters side-by-side within square brackets. For example the regular expression `b[ai]t` will match the words `"bit"` or `"bat"` because the pattern defines a character class accepting either `"i"` or `"a"` as the middle character.

```java
package org.kodejava.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterClassesSimpleClassDemo {
    public static void main(String[] args) {
        // Creating a simple class type of character classes.
        // The regular expression below will search all sequences
        // of string that begins with 'b', ends with 't' and have
        // a middle letter of 'a' or 'i'.
        String regex = "b[ai]t";

        // Compiles the pattern and obtains the matcher object.
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher =
            pattern.matcher("I'm a little bit afraid of bats " +
                "but not cats.");

        // Find every matches and prints it.
        while (matcher.find()) {
            System.out.format("Text \"%s\" found at %d to %d.%n",
                matcher.group(), matcher.start(), matcher.end());
        }
    }
}
```

The program will print the following output:

```text
Text "bit" found at 13 to 16.
Text "bat" found at 27 to 30.
```

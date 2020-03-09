# How do I write range character class regex?

To define a character class that includes a range of values, put `-` metacharacter between the first and last character to be matched. For example `[a-e]`. You can also specify multiple ranges like this `[a-zA-Z]`. This will match any letter of the alphabet from `a` to `z` (lowercase) or `A` to `Z` (uppercase).

In the example below we are matching the word that begins with `bat` and ends with a single number that have a value range from `3` to `7`.

```java
package org.kodejava.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterClassesRangeClassDemo {
    public static void main(String[] args) {
        // Defines regex that will search all sequences of string
        // that begin with bat and number which range [3-7]
        String regex = "bat[3-7]";
        String input =
            "bat1, bat2, bat3, bat4, bat5, bat6, bat7, bat8";

        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(regex);

        // Creates a matcher that will match the given input
        // against this pattern.
        Matcher matcher = pattern.matcher(input);

        // Find every matches and prints it.
        while (matcher.find()) {
            System.out.format("Text \"%s\" found at %d to %d.%n",
                matcher.group(), matcher.start(),
                matcher.end());
        }
    }
}
```

The program will match the following string from the input:`

```text
Text "bat3" found at 12 to 16.
Text "bat4" found at 18 to 22.
Text "bat5" found at 24 to 28.
Text "bat6" found at 30 to 34.
Text "bat7" found at 36 to 40.
```

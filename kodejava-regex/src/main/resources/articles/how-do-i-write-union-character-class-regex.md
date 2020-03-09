# How do I write union character class regex?

To create a single character class comprised of two or more separate character classes use unions. To create a union, simply nest one class inside the other, such as `[1-3[5-7]]`.

```java
package org.kodejava.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharacterClassUnionDemo {
    public static void main(String[] args) {
        // Defines regex that matches the number 1, 2, 3, 5, 6, 7
        String regex = "[1-3[5-7]]";
        String input = "1234567890";

        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        // Find matches and print it
        while (matcher.find()) {
            System.out.format("Text \"%s\" found at %d to %d.%n",
                matcher.group(), matcher.start(),
                matcher.end());
        }
    }
}
```

Here is the result of the program:

```text
Text "1" found at 0 to 1.
Text "2" found at 1 to 2.
Text "3" found at 2 to 3.
Text "5" found at 4 to 5.
Text "6" found at 5 to 6.
Text "7" found at 6 to 7.
```

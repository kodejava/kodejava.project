# How do I use logical OR operator in regex?

You can use the `|` operator (logical OR) to match characters or expression of either the left or right of the `|` operator. For example the `(t|T)` will match either `t` or `T` from the input string.

```java
package org.kodejava.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogicalOrRegexDemo {
    public static void main(String[] args) {
        // Define regex that will search characters 't' or 'T'
        String regex = "(t|T)";

        // Compiles the pattern and obtains the matcher object.
        Pattern pattern = Pattern.compile(regex);
        String input = "The quick brown fox jumps over the lazy dog";
        Matcher matcher = pattern.matcher(input);

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
Text "T" found at 0 to 1.
Text "t" found at 31 to 32.
```

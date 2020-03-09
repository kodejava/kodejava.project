# How do I use capturing groups in regex?

Capturing groups are a way to treat multiple characters as a single unit. They are created by placing the characters to be grouped inside a set of parentheses. For example, the regular expression `(dog)` creates a single group containing the letters `d`,  `o` and `g`.

Regular expressions can also define other capturing groups that correspond to parts of the pattern. Each pair of parentheses in a regular expression defines a separate capturing group in addition to the group that the whole expression defines.

```java
package org.kodejava.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapturingGroupDemo {
    public static void main(String[] args) {
        // Define regex to find the word 'the' or 'quick'
        String regex = "(the)|(quick)";
        String text = "the quick brown fox jumps over the lazy dog";

        // Compiles the given regular expression into a pattern and
        // Creates a matcher that will match the given input against
        // this pattern.
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // Find every match and print it
        while (matcher.find()) {
            System.out.format("Text \"%s\" found at %d to %d.%n",
                matcher.group(), matcher.start(), matcher.end());
        }
    }
}
```

The results of the program are:

```text
Text "the" found at 0 to 3.
Text "quick" found at 4 to 9.
Text "the" found at 31 to 34.
```

# How do I count the number of capturing groups?

Capturing groups are numbered by counting the opening parentheses from left to right. To find out how many groups are present in the expression, call the `groupCount()` method on a `matcher` object. The `groupCount()` method returns an `int` showing the number of capturing groups present in the matcher's pattern.

```java
package org.kodejava.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountingGroupDemo {
    public static void main(String[] args) {
        // Define regex to find the word 'quick' or 'lazy' or 'dog'
        String regex = "(quick)|(lazy)|(dog)";
        String text = "the quick brown fox jumps over the lazy dog";

        // Obtain the required matcher
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        int groupCount = matcher.groupCount();
        System.out.println("Number of group = " + groupCount);

        // Find every match and print it
        while (matcher.find()) {
            for (int i = 0; i <= groupCount; i++) {
                // Group i substring
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
    }
}
```

The result of the program:

```text
Number of group = 3
Group 0: quick
Group 1: quick
Group 2: null
Group 3: null
Group 0: lazy
Group 1: null
Group 2: lazy
Group 3: null
Group 0: dog
Group 1: null
Group 2: null
Group 3: dog
```

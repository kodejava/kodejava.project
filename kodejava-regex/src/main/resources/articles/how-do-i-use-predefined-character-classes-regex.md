# How do I use predefined character classes regex?

In regex, you also have a number of predefined character classes that provide you with a shorthand notation for commonly used sets of characters.

Here are the list:

* `.` : represent any character.
* `d` : represent any digit, shorthand for `[0-9]`
* `D` : represent a non digit, `[^0-9]`
* `s` : represent a whitespace character `[^s]`
* `S` : represent any non whitespace character
* `w` : represent word character `[a-zA-Z_0-9]`
* `W` : represent a non word character

```java
package org.kodejava.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PredefinedCharacterClassDemo {
    public static void main(String[] args) {
        // Define regex that will search a whitespace followed by f
        // and two any characters.
        String regex = "\\sf..";

        // Compiles the pattern and obtains the matcher object.
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(
            "The quick brown fox jumps over the lazy dog");

        // find every match and print it
        while (matcher.find()) {
            System.out.format("Text \"%s\" found at %d to %d.%n",
                matcher.group(), matcher.start(), matcher.end());
        }
    }
}
```

This program output the following result:

```text
Text " fox" found at 15 to 19.
```

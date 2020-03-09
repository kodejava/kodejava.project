# How do I use possessive quantifier regex?

The possessive quantifiers always eat the entire input string, trying once (and only once) for a match. Unlike the greedy quantifiers, possessive quantifiers never back off, even if doing so would allow the overall match to succeed.

```java
package org.kodejava.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PossessiveQuantifierDemo {
    public static void main(String[] args) {
        String[] regexs = {
            "x?+",
            "x*+",
            "x++",
            "x{2}+",
            "x{2,}+",
            "x{2,5}+"
        };
        String input = "xxxxxxx";

        for (String r : regexs) {
            Pattern pattern = Pattern.compile(r);
            Matcher matcher = pattern.matcher(input);

            // Find every match and print it
            System.out.format("Regex:  %s%n", r);
            while (matcher.find()) {
                System.out.format("Text \"%s\" found at %d to %d.%n",
                    matcher.group(), matcher.start(),
                    matcher.end());
            }
            System.out.println("------------------------------");
        }
    }
}
```

The output of the code snippet above are:

```text
Regex:  x?+
Text "x" found at 0 to 1.
Text "x" found at 1 to 2.
Text "x" found at 2 to 3.
Text "x" found at 3 to 4.
Text "x" found at 4 to 5.
Text "x" found at 5 to 6.
Text "x" found at 6 to 7.
Text "" found at 7 to 7.
------------------------------
Regex:  x*+
Text "xxxxxxx" found at 0 to 7.
Text "" found at 7 to 7.
------------------------------
Regex:  x++
Text "xxxxxxx" found at 0 to 7.
------------------------------
Regex:  x{2}+
Text "xx" found at 0 to 2.
Text "xx" found at 2 to 4.
Text "xx" found at 4 to 6.
------------------------------
Regex:  x{2,}+
Text "xxxxxxx" found at 0 to 7.
------------------------------
Regex:  x{2,5}+
Text "xxxxx" found at 0 to 5.
Text "xx" found at 5 to 7.
------------------------------
```

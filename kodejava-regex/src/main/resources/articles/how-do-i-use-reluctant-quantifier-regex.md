# How do I use reluctant quantifier regex?

The reluctant quantifiers start the matcher at the beginning of the input string, then reluctantly eat one character at a time looking for a match. The last thing they try is the entire input string.

```java
package org.kodejava.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReluctantQuantifierDemo {
    public static void main(String[] args) {
        String[] expressions =
            {"x??", "x*?", "x+?", "x{2}?", "x{2,}?", "x{2,5}?"};
        String input = "xxxxxxx";

        for (String expression : expressions) {
            Pattern pattern = Pattern.compile(expression);
            Matcher matcher = pattern.matcher(input);

            // Find every match and print it
            System.out.println("------------------------------");
            System.out.format("regex:  %s %n", expression);
            while (matcher.find()) {
                System.out.format("Text \"%s\" found at %d to %d%n",
                    matcher.group(), matcher.start(),
                    matcher.end());
            }
        }
    }
}
```

The results of the snippet shown below:

```text
regex:  x?? 
Text "" found at 0 to 0
Text "" found at 1 to 1
Text "" found at 2 to 2
Text "" found at 3 to 3
Text "" found at 4 to 4
Text "" found at 5 to 5
Text "" found at 6 to 6
Text "" found at 7 to 7
------------------------------
regex:  x*? 
Text "" found at 0 to 0
Text "" found at 1 to 1
Text "" found at 2 to 2
Text "" found at 3 to 3
Text "" found at 4 to 4
Text "" found at 5 to 5
Text "" found at 6 to 6
Text "" found at 7 to 7
------------------------------
regex:  x+? 
Text "x" found at 0 to 1
Text "x" found at 1 to 2
Text "x" found at 2 to 3
Text "x" found at 3 to 4
Text "x" found at 4 to 5
Text "x" found at 5 to 6
Text "x" found at 6 to 7
------------------------------
regex:  x{2}? 
Text "xx" found at 0 to 2
Text "xx" found at 2 to 4
Text "xx" found at 4 to 6
------------------------------
regex:  x{2,}? 
Text "xx" found at 0 to 2
Text "xx" found at 2 to 4
Text "xx" found at 4 to 6
------------------------------
regex:  x{2,5}? 
Text "xx" found at 0 to 2
Text "xx" found at 2 to 4
Text "xx" found at 4 to 6
```

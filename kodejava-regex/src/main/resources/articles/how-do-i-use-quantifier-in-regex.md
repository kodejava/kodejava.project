# How do I use quantifier in regex?

A quantifier following a subsequence of a pattern determines the possibilities for how that subsequence of a pattern can repeat. Quantifiers allow you to specify the number of occurrences to match against.

**Quantifiers**

* `X?` : `X`, once or not at all
* `X*` : `X`, zero or more times
* `X+` : `X`, one or more times
* `X{n}` : `X`, exactly n times
* `X{n,}` : `X`, at least n times
* `X{n,m}` : `X`, at least n but not more than m times

```java
package org.kodejava.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexQuantifierDemo {
    public static void main(String[] args) {
        String[] expressions =
            {"x?", "x*", "x+", "x{2}", "x{2,}", "x{2,5}"};

        String input = "xxxxxx yyyxxxxxx zzzxxxxxx";

        for (String expression : expressions) {
            // Compiles the given regular expression into a
            // pattern and creates a matcher that will match
            // the given input against this pattern.
            Pattern pattern = Pattern.compile(expression);
            Matcher matcher = pattern.matcher(input);

            // Find every match and print it
            System.out.format("regex:  %s %n", expression);
            while (matcher.find()) {
                System.out.format("Text \"%s\" found at %d to %d%n",
                    matcher.group(), matcher.start(),
                    matcher.end());
            }
            System.out.println("------------------------------");
        }
    }
}
```

Here are the result of the program:

````text
regex:  x? 
Text "x" found at 0 to 1
Text "x" found at 1 to 2
Text "x" found at 2 to 3
Text "x" found at 3 to 4
Text "x" found at 4 to 5
Text "x" found at 5 to 6
Text "" found at 6 to 6
Text "" found at 7 to 7
Text "" found at 8 to 8
Text "" found at 9 to 9
Text "x" found at 10 to 11
Text "x" found at 11 to 12
Text "x" found at 12 to 13
Text "x" found at 13 to 14
Text "x" found at 14 to 15
Text "x" found at 15 to 16
Text "" found at 16 to 16
Text "" found at 17 to 17
Text "" found at 18 to 18
Text "" found at 19 to 19
Text "x" found at 20 to 21
Text "x" found at 21 to 22
Text "x" found at 22 to 23
Text "x" found at 23 to 24
Text "x" found at 24 to 25
Text "x" found at 25 to 26
Text "" found at 26 to 26
------------------------------
regex:  x* 
Text "xxxxxx" found at 0 to 6
Text "" found at 6 to 6
Text "" found at 7 to 7
Text "" found at 8 to 8
Text "" found at 9 to 9
Text "xxxxxx" found at 10 to 16
Text "" found at 16 to 16
Text "" found at 17 to 17
Text "" found at 18 to 18
Text "" found at 19 to 19
Text "xxxxxx" found at 20 to 26
Text "" found at 26 to 26
------------------------------
regex:  x+ 
Text "xxxxxx" found at 0 to 6
Text "xxxxxx" found at 10 to 16
Text "xxxxxx" found at 20 to 26
------------------------------
regex:  x{2} 
Text "xx" found at 0 to 2
Text "xx" found at 2 to 4
Text "xx" found at 4 to 6
Text "xx" found at 10 to 12
Text "xx" found at 12 to 14
Text "xx" found at 14 to 16
Text "xx" found at 20 to 22
Text "xx" found at 22 to 24
Text "xx" found at 24 to 26
------------------------------
regex:  x{2,} 
Text "xxxxxx" found at 0 to 6
Text "xxxxxx" found at 10 to 16
Text "xxxxxx" found at 20 to 26
------------------------------
regex:  x{2,5} 
Text "xxxxx" found at 0 to 5
Text "xxxxx" found at 10 to 15
Text "xxxxx" found at 20 to 25
------------------------------
````

# How do I write embedded flag expression?

It's also possible to enable various flags using embedded flag expressions. Embedded flag expressions are an alternative to the two-argument version of compile, and are specified in the regular expression itself. The example below is use `(?i)` flag expression to enable case-insensitive matching.

Another flag expressions are listed below:

* `(?x)`, equivalent with `Pattern.COMMENTS`
* `(?m)`, equivalent with `Pattern.MULTILINE`
* `(?s)`, equivalent with `Pattern.DOTTAL`
* `(?u)`, equivalent with `Pattern.UNICODE_CASE`
* `(?d)`, equivalent with `Pattern.UNIX_LINES`

```java
package org.kodejava.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmbeddedFlagDemo {
    public static void main(String[] args) {
        // Define regex which starting with (?i) to enable
        // case-insensitive matching
        String regex = "(?i)the";
        String text = "The quick brown fox jumps over the lazy dog";

        // Obtain the required matcher
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        // Find every match and print it
        while (matcher.find()) {
            System.out.format("Text \"%s\" found at %d to %d.%n",
                matcher.group(), matcher.start(),
                matcher.end());
        }
    }
}
```

The result of the program is:

```text
Text "The" found at 0 to 3.
Text "the" found at 31 to 34.
```

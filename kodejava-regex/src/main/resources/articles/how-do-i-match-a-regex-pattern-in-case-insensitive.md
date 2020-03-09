# How do I match a regex pattern in case insensitive?

Finding the next subsequence of the input sequence that matches the pattern while ignoring the case of the string in regular expression can simply applied by create a pattern using `compile(String regex, int flags)` method and specifies a second argument with `PATTERN.CASE_INSENSITIVE` constant.

```java
package org.kodejava.example.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexIgnoreCaseDemo {
    public static void main(String[] args) {
        String sentence =
            "The quick brown fox and BROWN tiger jumps over the lazy dog";

        Pattern pattern = Pattern.compile("brown", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(sentence);

        while (matcher.find()) {
            System.out.format("Text \"%s\" found at %d to %d.%n",
                matcher.group(), matcher.start(), matcher.end());
        }
    }
}
```

Here is the result of the program:

```text
Text "brown" found at 10 to 15.
Text "BROWN" found at 24 to 29.
```

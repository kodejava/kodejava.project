# How do I do boundary matching in regex?

If you want to find the occurrence of a pattern in more precise position, for example at the beginning or the end of line, you can use boundary matcher. Boundary matcher are special sequences in a regular expression when you want to match a particular boundary.

Here are the list:

* `^` : the beginning of line
* `$` : the end of line
* `b` : a word boundary
* `B` : a non word boundary
* `A` : the beginning of the input
* `G` : the end of previous match
* `Z` : the end of the input but for the final terminator, if any
* `z` : The end of the input

Some examples:

* `^Java` will find the word Java at the beginning of any line
* `Java$` will find the word Java at the end of any line
* `\bJ..a\b` will find the word beginning with `'J'` and ending with `'a'`

```java
package org.kodejava.example.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BoundaryMatcherDemo {
    public static void main(String[] args) {
        // Define regex to find the word "dog" at the end of the line.
        String regex = "dog$";

        // Compiles the pattern and obtains the matcher object.
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(
            "The quick brown fox jumps over the lazy dog");

        // Find every match and print it
        while (matcher.find()) {
            System.out.format("Text \"%s\" found at %d to %d.%n",
                matcher.group(), matcher.start(), matcher.end());
        }
    }
}
```

This program output the following result:

```text
Text "dog" found at 40 to 43.
```

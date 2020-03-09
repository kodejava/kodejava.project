# How do I generate random alphanumeric strings?

The following code snippet demonstrate how to use `RandomStringGenerator` class from the _Apache Commons Text_ library to generate a random string. To create an instance of the generator we can call the `RandomStringGenerator.Builder()` method. The builder helps us to configure how the generator behave. Some configuration we set includes:
 
 * `withinRange` to specifies the minimum and maximum code points allowed in the generated string.
 * `filteredBy` to limits the characters in the generated string to those that match at least one of the predicates supplied. For example we use `CharacterPredicates.DIGITS` and `CharacterPredicates.LETTERS` to limit the characters to digits and letters.
 * `selectFrom` Limits the characters in the generated string to those who match at supplied list of Character.

| Classes | Methods |
| --- | --- |
| `RandomStringGenerator` | `generate​(int length)` - Generates a random string, containing the specified number of code points. |
| | `generate​(int minLengthInclusive, int maxLengthInclusive)` - Generates a random string, containing between the minimum (inclusive) and the maximum (inclusive) number of code points. |
| `RandomStringGenerator.Builder` | `build()` - Builds the RandomStringGenerator using the properties specified. |

```java
package org.kodejava.example.commons.text;

import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;

public class RandomStringDemo {
    public static void main(String[] args) {
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
            .withinRange('0', 'z')
            .filteredBy(CharacterPredicates.DIGITS, CharacterPredicates.LETTERS)
            .build();

        for (int i = 0; i < 10; i++) {
            System.out.println(generator.generate(10, 20));
        }
    }
}
```

Below are examples of generated random alphanumeric strings:

```text
iDp323cGhbnvHBq
fuOHpaM0x8B9eFBR2tr
T8JmM8jeRN
SSP1ZsFsIyP
GPr7rDbwr33zO
s7HkOlcT6gLQoWOfV6
WMgmVfhxp0
OTj9UUBdnT51TgACK
VmRzheeRyVZJKGo7
xzyD31Vk7Fx
```

**Maven Dependencies**

```xml
<!-- https://search.maven.org/remotecontent?filepath=org/apache/commons/commons-text/1.6/commons-text-1.6.jar -->
<dependency>
  <groupId>org.apache.commons</groupId>
  <artifactId>commons-text</artifactId>
  <version>1.6</version>
</dependency>
```
[![Maven Central](https://img.shields.io/maven-central/v/org.apache.commons/commons-text.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22org.apache.commons%22%20AND%20a:%22commons-text%22)

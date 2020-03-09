# How do I inject collections properties in Spring?

Beside injecting a simple value (using the `value` attribute) and a reference to other bean (using the `ref` attribute). We can also inject collections properties into a bean.

Spring provides four ways to inject collections. There are `<list>` and `<set>` that can be used to inject arrays or any implementation of `java.util.Collection`. The `<map>` that can be used to inject property of type `java.util.Map`. And the `<props>` can be used to inject property of type `java.util.Properties`.

Here is a table that summarize the collection configuration support in Spring.

| Collection Element | Description |
|:---|:---|
| `<list>` | Wiring a list of values, where the values might have duplicates. |
| `<set>` | Wiring a set of values, where the values can not have duplicates. |
| `<map>` | Wiring a key-value pairs collection, where the key and value can be any type |
| `<props>` | Wiring a key-value pairs property, where the key and value are both type of String |

You can see the following example on how to use each type of this collection configuration:

* [How do I inject collections with list element in Spring?](//kodejava.org/how-do-i-inject-collections-using-list-element-in-spring/).
* [How do I inject collections with set element in Spring?](//kodejava.org/how-do-i-inject-collections-using-set-element-in-spring/).
* [How do I inject collections with map element in Spring?](//kodejava.org/how-do-i-inject-collections-using-map-element-in-spring/).
* [How do I inject collections with props element in Spring?](//kodejava.org/how-do-i-inject-collections-using-props-element-in-spring/).

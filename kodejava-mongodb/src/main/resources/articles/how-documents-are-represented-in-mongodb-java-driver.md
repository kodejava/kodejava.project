# How documents are represented in MongoDB Java Driver?

MongoDB documents are stored inside a collections as a JSON (JavaScript Object Notation) document. It's a string of key-value pairs data. JSON is a lightweight data-interchange format. It is easy for humans to read and write. It is easy for machines to parse and generate.

When we are working in the MongoDB shell we can type in this document as a string that follow JSON data format. But how do we create this JSON document when working within a Java programming. This blog post will show you how to represent a document using Java Driver for MongoDB.

If you recall a key-value pairs data type you will remember that Java have a `java.util.Map` that can represent data structure in this format. So you might think that you can use a generic type of `Map&lt;String, Object&gt;` to store this data. But, because in MongoDB's document the order of keys in a document is quite important to make sure the operations such as find, insert, update and remove work correctly, using a Map to represent a document can be quite dangerous.

MongoDB has a special interface called as `com.mongodb.DBObject` and its implementation class in `com.mongodb.BasicDBObject` that can be use to create or represent a document in MongoDB database. The `DBObject` is actually a map like structure with a key-value pairs. If you look up to the class hierarchy you can actually see that a `BasicDBObject` is inherited from the `java.util.LinkedHashMap` class.

The code snippet below will show you how to create a `BasicDBObject` to represent a MongoDB document.

```java
package org.kodejava.example.mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.util.Arrays;

public class MongoDBDocument {
    public static void main(String[] args) {

        // Creates an empty document.
        DBObject emptyDoc = new BasicDBObject();
        System.out.println("emptyDoc = " + emptyDoc);

        // Creates a simple document with a given key and value.
        DBObject simpleDoc = new BasicDBObject("name", "John Doe");
        System.out.println("simpleDoc = " + simpleDoc);

        // Creates a document with embedded document and arrays.
        DBObject document = new BasicDBObject("firstName", "Foo")
            .append("lastName", "Bar")
            .append("age", 25)
            .append("email", "foo@bar.com")
            .append("address",
                new BasicDBObject("street", "Sunset Boulevard 123")
                    .append("city", "New York")
                    .append("country", "USA"))
            .append("hobbies", Arrays.asList("Swimming", "Cycling", "Running"));
        System.out.println("document = " + document);
    }
}
```

In the code above we have create three documents as an example. The first one is an empty document which created by instantiating a `BasicDBObject` class with no arguments specified. The second one we create a document with a single key and value. This key and value is passed as an argument when we create the `BasicDBObject`.

The last example show you how to create a document with multiple keys, embedded document and an arrays. To add more fields to the `BasicDBObject` we can call a chain of the `append()` method with a specified key and value. The key will be a string and the value is a type of `java.lang.Object`.

An embedded document is created simply by instantiating another `BasicDBObject` and assign it as a value of a document key. In the example above the `address` field is an embedded document inside the `document`. Which contains another fields such as street, city and country.

If you want to see how the JSON string of this document is look like you can run the code above. You will see something like the output below as the result.

```json
emptyDoc = { }

simpleDoc = { "name" : "John Doe" }

document = { 
    "firstName" : "Foo" , 
    "lastName" : "Bar" , 
    "age" : 25 , 
    "email" : "foo@bar.com" , 
    "address" : { 
        "street" : "Sunset Boulevard 123" , 
        "city" : "New York"
    } , 
    "hobbies" : [ "Swimming" , "Cycling" , "Running"]
}
```

That's the basic that you need to know on how to create a document using MongoDB Java Driver. You will use this document when doing some database operation in MongoDB such as finding a document, inserting, updating and removing document from collection in the database.

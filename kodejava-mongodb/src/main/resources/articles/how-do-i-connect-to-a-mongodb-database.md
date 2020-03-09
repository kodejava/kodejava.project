# How do I connect to a MongoDB Database?

In the previous post you have seen how we [installed the MongoDB database server](//kodejava.org/installing-and-running-mongodb-in-windows-7/) and try to use the MongoDB shell to manipulate collections in the database. You also have been introduced how to [obtain and setup the MongoDB Java Driver](//kodejava.org/introduction-to-mongodb-java-driver/) that we can use to manipulate the MongoDB database from a Java program.

Starting from this post we will begin to explore more on how to use the power of MongoDB Java Driver to work with MongoDB. You will see how we are connect to the database, how to do a CRUD operation (Create, Read, Update and Delete) with Java Driver. But first let see how we create a connection to a database in MongoDB.

Here is our first code snippet, it shows you how to bootstrap the MongoDB to open a connection to a database.

```java
package org.kodejava.example.mongodb;

import com.mongodb.*;

import java.net.UnknownHostException;
import java.util.Random;

public class MongoDBConnect {
    public static void main(String[] args) {
        try {
            MongoClient client =
                new MongoClient(new ServerAddress("localhost", 27017));

            DB database = client.getDB("school");
            DBCollection students = database.getCollection("students");
            students.remove(new BasicDBObject());

            String[] types = {"Homework", "Quiz", "Essay"};
            for (int i = 1; i <= 10; i++) {
                for (int j = 0; j < 3; j++) {
                    students.insert(new BasicDBObject("student_id", i)
                        .append("type", types[j])
                        .append("score", new Random().nextInt(100)));
                }
            }

            try (DBCursor cursor = students.find()) {
                while (cursor.hasNext()) {
                    System.out.println(cursor.next());
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
```

What you can see from the code above is. First we bootstrap the MongoDB by create an instance of `MongoClient`. Here we pass a `ServerAddress` to define the address of our MongoDB database with information about the host name and the port number. If you just create an instance of `MongoClient` without any arguments it will use the default address such as `localhost` for the host and `27017` as the default port number. Creating an instance of `MongoClient` can produce an `UnknownHostException`, so we need to place it inside a try-catch statement.

```java
try {
    MongoClient client =
        new MongoClient(new ServerAddress("localhost", 27017));
} catch (UnknownHostException e) {
    e.printStackTrace();
}
```

After initialize the `MongoClient` we can connect to a database by calling the `getDB()` method and passing the database name as argument. In the example above we connect to the `school` database, the database in MongoDB is represented by the `DB` class in the `com.mongodb` package. In the next line after connected to the database you can see that we are getting the `students` collection from this database. Just for the purpose of this example we then empty the `students` collection using the `remove()` method of the `DBCollection` class.

```java
DB database = client.getDB("school");
DBCollection students = database.getCollection("students");
students.remove(new BasicDBObject());
```

In the next lines until the end of a code snippet you can see that we populate some random data into the `students` collections. We call the `DBCollection.insert()` method to insert documents into the `students` collection. And finally we read the inserted documents from the `students` collection using the `find()` method and iterate the returned cursor one by one until all documents printed on the console. You can also see that we are using the try-with-resource syntax in this code as the `DBCursor` is already implementing the Java 7 `AutoCloseable` interface.

```java
String[] types = {"Homework", "Quiz", "Essay"};
for (int i = 1; i <= 10; i++) {
    for (int j = 0; j < 3; j++) {
        students.insert(new BasicDBObject("student_id", i)
            .append("type", types[j])
            .append("score", new Random().nextInt(100)));
    }
}

try (DBCursor cursor = students.find()) {
    while (cursor.hasNext()) {
        System.out.println(cursor.next());
    }
}
```

And here are the sample of the result produced by our code above.

```json
{ "_id" : { "$oid" : "53f47814f524c5037606f2b4"} , "student_id" : 1 , "type" : "Homework" , "score" : 86}
{ "_id" : { "$oid" : "53f47814f524c5037606f2b5"} , "student_id" : 1 , "type" : "Quiz" , "score" : 14}
{ "_id" : { "$oid" : "53f47814f524c5037606f2b6"} , "student_id" : 1 , "type" : "Essay" , "score" : 35}
{ "_id" : { "$oid" : "53f47814f524c5037606f2b7"} , "student_id" : 2 , "type" : "Homework" , "score" : 12}
{ "_id" : { "$oid" : "53f47814f524c5037606f2b8"} , "student_id" : 2 , "type" : "Quiz" , "score" : 96}
{ "_id" : { "$oid" : "53f47814f524c5037606f2b9"} , "student_id" : 2 , "type" : "Essay" , "score" : 51}
{ "_id" : { "$oid" : "53f47814f524c5037606f2ba"} , "student_id" : 3 , "type" : "Homework" , "score" : 54}
{ "_id" : { "$oid" : "53f47814f524c5037606f2bb"} , "student_id" : 3 , "type" : "Quiz" , "score" : 50}
{ "_id" : { "$oid" : "53f47814f524c5037606f2bc"} , "student_id" : 3 , "type" : "Essay" , "score" : 38}
{ "_id" : { "$oid" : "53f47814f524c5037606f2bd"} , "student_id" : 4 , "type" : "Homework" , "score" : 69}
```

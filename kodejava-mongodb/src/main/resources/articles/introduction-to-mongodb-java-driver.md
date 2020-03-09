# Introduction to MongoDB Java Driver

In the past post [Installing and Running MongoDB in Windows 7](//kodejava.org/installing-and-running-mongodb-in-windows-7/), you've seen how to install and running MongoDB database server. Now we are going to learn how to use the MongoDB Java Driver to access collections from the MongoDB database. To demonstrate this I am going to use Maven and and IntelliJ IDEA. You can use other IDE of your choice of course, such as Eclipse or NetBeans which also support Maven.

Let's begin by creating our project in IntelliJ IDEA. I am going to use the community edition of IntelliJ IDEA which is free to download. Here are the steps for creating a Maven project in IntelliJ IDEA.

### Creating Maven Project

* Start IntelliJ IDEA. From the Welcome Screen select **Create New Project**.
* A **New Project** wizard will be shown. Select **Maven** on the Sidebar, check the **Create from archetype** check box and select **maven-archetype-quickstart**.

[caption id="attachment_4110" align="alignnone" width="750"]<a href="http://kodejava.org/wp-content/uploads/2014/08/New-Project-Step-1.png"><img class="wp-image-4110 size-full" src="http://kodejava.org/wp-content/uploads/2014/08/New-Project-Step-1.png" alt="Maven Project From Archetype" width="750" height="660" /></a> Maven Project From Archetype[/caption]

* Press the **Next** button to continue.
* In the next screen you can enter the Maven project information details including the **GroupId**, **ArtifactId**, and **Version**.

[caption id="attachment_4115" align="alignnone" width="691"]<a href="http://kodejava.org/wp-content/uploads/2014/08/New-Project-Step-2.png"><img class="wp-image-4115 size-full" src="http://kodejava.org/wp-content/uploads/2014/08/New-Project-Step-2.png" alt="Maven Project Information" width="691" height="219" /></a> Maven Project Information[/caption]

* Press the **Next** button to continue.
* In this screen you can override any Maven configuration setting if you want. And you also see the summary of Maven project to be created. We do not modify the setting in this screen.

[caption id="attachment_4117" align="alignnone" width="691"]<a href="http://kodejava.org/wp-content/uploads/2014/08/New-Project-Step-3.png"><img class="wp-image-4117 size-full" src="http://kodejava.org/wp-content/uploads/2014/08/New-Project-Step-3.png" alt="Maven Project Summary" width="691" height="365" /></a> Maven Project Summary[/caption]

* Press the **Next** button to continue.
* In the final screen we input the **Project name** and **Project location** directory.
* After you input these two information click the **Finish** button to generate the Maven project in IntelliJ IDEA.

[caption id="attachment_4119" align="alignnone" width="691"]<a href="http://kodejava.org/wp-content/uploads/2014/08/New-Project-Step-4.png"><img class="size-full wp-image-4119" src="http://kodejava.org/wp-content/uploads/2014/08/New-Project-Step-4.png" alt="Maven Project Name and Location" width="691" height="309" /></a> Maven Project Name and Location[/caption]

* Finally you have the Maven project created in IntelliJ IDEA.
* This is the Maven project structure generated in IntelliJ IDEA.

[caption id="attachment_4121" align="alignnone" width="352"]<a href="http://kodejava.org/wp-content/uploads/2014/08/New-Project-Step-5.png"><img class="size-full wp-image-4121" src="http://kodejava.org/wp-content/uploads/2014/08/New-Project-Step-5.png" alt="Maven Project Structure" width="352" height="481" /></a> Maven Project Structure[/caption]

### Editing the pom.xml File

* To use the MongoDB Java Driver in our Java application, the first thing we need to is to add the dependency to MongoDB Java Driver in our `pom.xml` file.
* Add the following dependency configuration to the `pom.xml`.

```xml
<dependency>
    <groupId>org.mongodb</groupId>
    <artifactId>mongo-java-driver</artifactId>
    <version>2.12.3</version>
</dependency>
```

*  And you'll have the complete pom.xml file like this configuration below.

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>org.kodejava.example.mongodb</groupId>
    <artifactId>mongodb-examples</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>jar</packaging>

    <name>mongodb-examples</name>
    <url>http://maven.apache.org</url>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>3.8.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.mongodb</groupId>
            <artifactId>mongo-java-driver</artifactId>
            <version>2.12.3</version>
        </dependency>
    </dependencies>
</project>
```

IntelliJ IDEA will download all the required dependency files from the Maven Central repository if they are not available in you local Maven repository. After configuring the Maven, we are now ready to create a simple program to find a single collection from the MongoDB database.

If you are following the last post about installing and running MongoDB that I have mention in the beginning of this article you know that we have a `peopledb` and `persons` collections in our MongoDB database. Now we are going to read it using the MongoDB Java Driver in our Java application. So lets now create the application.

### Create Java A Simple MongoDB Client

* We create our class under the `org.kodejava.example.mongodb` package. Right click on this package and choose **New**, **Java Class** to create a new class.
* Type in the class name `MongoDBHelloWorld`, and press **OK** button.
* And this is the full code snippet for the `MongoDBHelloWorld` class.

```java
package org.kodejava.example.mongodb;

import com.mongodb.*;

import java.net.UnknownHostException;

public class MongoDBHelloWorld {
    public static void main(String[] args) {
        try {
            // Creates a new instance of MongoDBClient and connect to localhost
            // port 27017.
            MongoClient client = new MongoClient(
                    new ServerAddress("localhost", 27017));

            // Gets the peopledb from the MongoDB instance.
            DB database = client.getDB("peopledb");

            // Gets the persons collections from the database.
            DBCollection collection = database.getCollection("persons");

            // Gets a single document / object from this collection.
            DBObject document = collection.findOne();

            // Prints out the document.
            System.out.println(document);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
```

*  If you run this code you will get the following output printed on the screen.

```json
{ "_id" : { "$oid" : "53e317ae420156bce730d1ff"} , "firstName" : "John" , "lastName" : "Doe" , "cityOfBirth" : "New York"}
```

*  This is the JSON document that we've store in our `peopledb` in the MongoDB database.

The Java class above is our first example of how to use the MongoDB Java Driver to access and read a document from the MongoDB database. I hope this example can be a good start for us to learn more about MongoDB. If you have any question just submit it in the comment section below this article. See you on the next post. Thank you!

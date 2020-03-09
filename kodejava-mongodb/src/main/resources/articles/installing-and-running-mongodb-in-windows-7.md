# Installing and Running MongoDB in Windows 7

### What is MongoDB

In this post you will see how to install and running MongoDB database server on Windows 7. What is MongoDB? MongoDB is a NoSQL database. MongoDB is a non-relational JSON document store, a document oriented database. Non-relational means that it does not support the relational algebra that most often expressed in SQL like what RDBMS such as Oracle or MySQL does. The document here is not a Microsoft Word documents or such, but it is a JSON (JavaScript Object Notation) documents.

And if you don't know what it is look like, here are some examples of JSON documents:

```json
[
  {"firstName" : "John", "lastName" : "Doe", "cityOfBirth" : "New York"},
  {"firstName" : "Julia", "lastName" : "Roberts", "movieTitles" : ["Pretty Woman", "Nothing Hill", "Runaway Bride"]}
]
```

Other characteristics of MongoDB are: it has a dynamic schema, it does not support SQL language, it does not support Joins, and it doesn't support transactional across multiple collections.

### MongoDB Installation

After you know a bit of MongoDB lets get started with the installation process. Here are the step by step of the MongoDB installation.

* Downloads Windows 64-bit MongoDB installer at [https://www.mongodb.com/download-center](https://www.mongodb.com/download-center). When this post is written the binary file name for Windows 64-bit is _mongodb-win32-x86_64-2008plus-2.6.3-signed.msi_.

* After you have finish the download the installer double click the file to start the installation wizard.

[caption id="attachment_4125" align="alignnone" width="509"]<a href="http://kodejava.org/wp-content/uploads/2014/08/MongoDB-Step-1.png"><img src="http://kodejava.org/wp-content/uploads/2014/08/MongoDB-Step-1.png" alt="Welcome to MongoDB Setup" width="509" height="398" class="size-full wp-image-4125" /></a> Welcome to MongoDB Setup[/caption]

* Press the **Next** button for the next screen and check _I accept the terms in the License Agreement_ check box and press the **Next** button to continue.

[caption id="attachment_4127" align="alignnone" width="509"]<a href="http://kodejava.org/wp-content/uploads/2014/08/MongoDB-Step-2.png"><img src="http://kodejava.org/wp-content/uploads/2014/08/MongoDB-Step-2.png" alt="End-User License Agreement" width="509" height="398" class="size-full wp-image-4127" /></a> End-User License Agreement[/caption]

* The next step is to choose the setup type. There are three types of setup available, Typical, Custom and Complete. For now we will choose **Complete**. So click the **Complete** button to continued the installation process.

[caption id="attachment_4129" align="alignnone" width="509"]<a href="http://kodejava.org/wp-content/uploads/2014/08/MongoDB-Step-3.png"><img src="http://kodejava.org/wp-content/uploads/2014/08/MongoDB-Step-3.png" alt="Choose Setup Type" width="509" height="398" class="size-full wp-image-4129" /></a> Choose Setup Type[/caption]

* Press the **Install** button to begin installation process.

[caption id="attachment_4130" align="alignnone" width="509"]<a href="http://kodejava.org/wp-content/uploads/2014/08/MongoDB-Step-4.png"><img src="http://kodejava.org/wp-content/uploads/2014/08/MongoDB-Step-4.png" alt="Ready To Install MongoDB" width="509" height="398" class="size-full wp-image-4130" /></a> Ready To Install MongoDB[/caption]

* After pressing the Install button you can see the screen of MongoDB installation process. Wait until the installation is done.

[caption id="attachment_4131" align="alignnone" width="509"]<a href="http://kodejava.org/wp-content/uploads/2014/08/MongoDB-Step-5.png"><img src="http://kodejava.org/wp-content/uploads/2014/08/MongoDB-Step-5.png" alt="Installing MongoDB" width="509" height="398" class="size-full wp-image-4131" /></a> Installing MongoDB[/caption]

* And finally you have the MongoDB database installed. Click the Finish button to end the installation process.

[caption id="attachment_4132" align="alignnone" width="509"]<a href="http://kodejava.org/wp-content/uploads/2014/08/MongoDB-Step-6.png"><img src="http://kodejava.org/wp-content/uploads/2014/08/MongoDB-Step-6.png" alt="Completed MongoDB Installation" width="509" height="398" class="size-full wp-image-4132" /></a> Completed MongoDB Installation[/caption]

The steps above have finalize your MongoDB installation. If you check in your `C:\Program Files` directory you will see the MongoDB installation directory in there. There will be a `bin` directory under `C:\Program Files\MongoDB 2.6 Standard` where all the MongoDB application files. Now you have install the database server lets run and check the database server.

### Running MongoDB

For this step we will focus on two files from the `bin` directory of the MongoDB installation. The `mongod.exe` and `mongo.exe`. The first executable is the MongoDB database engine daemon while the second executable is the shell program to access the MongoDB.

To run the database do the following steps:

* Create data directory. By default MongoDB look for `\data\db` directory in the root Drive from where you run the `mongod`. For example you can create `C:\data\db`. Or you can use the `--dbpath` argument to tell MongoDB where to store the data.
* Open Command Prompt and cd to `C:\Program Files\MongoDB 2.6 Standard\bin` and type `mongod` to start the daemon.

[caption id="attachment_4135" align="alignnone" width="667"]<a href="http://kodejava.org/wp-content/uploads/2014/08/MongoDB-mongod.png"><img src="http://kodejava.org/wp-content/uploads/2014/08/MongoDB-mongod.png" alt="MongoDB mongod" width="667" height="630" class="size-full wp-image-4135" /></a> MongoDB mongod[/caption]

The screen above shows you that the MongoDB is successfully started, using the `dbpath` `\data\db` and it ready and listening for connections on the default port 27017.

### Running The Shell

* Open Command Prompt and cd to `C:\Program Files\MongoDB 2.6 Standard\bin`.
* Run mongo.exe to start the shell. You'll see a welcome message to the MongoDB shell.

[caption id="attachment_4137" align="alignnone" width="667"]<a href="http://kodejava.org/wp-content/uploads/2014/08/MongoDB-mongo-shell.png"><img src="http://kodejava.org/wp-content/uploads/2014/08/MongoDB-mongo-shell.png" alt="MongoDB mongo shell" width="667" height="322" class="size-full wp-image-4137" /></a> MongoDB mongo shell[/caption]

* In the shell above we run a couple of commands:
* `use peopledb` command ask the MongoDB to change to the persons collections, if it doesn't exist Mongo will create one.
* To add document to the collections we can call `db.persons.insert();` and passing the JSON document as the arguments.
* To query the collection we can use `db.persons.find()`.
* If you want for instance to find Julia in the collection you can do `db.persons.find({"firstName" : "Julia"})`
* To close the shell we can call `quit()` command.

That's all for now, I hope this post is useful for you. In the next post I will show you how to create a simple Java application that use Mongo Java Driver to store data using Java programming into the MongoDB database. So, see you in the next post. Thank you.

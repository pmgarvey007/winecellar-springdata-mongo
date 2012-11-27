# Wine Cellar Application #

Thanks to Christophe Coenraets for giving us a Restful service that use JAX-RS, Jersey and MySQL.
I basically took the same code and replace the persistence layer to use SpringData with MongoDB instead of MySQL.

The original Wine Cellar application is documented [here](http://coenraets.org).

This application provides an example of 
Building a complete RESTful API in Java using JAX-RS and Jersey.
Consuming these services using jQuery

Set Up:

1. Download and Install MongoDB on a local machine from http://www.mongodb.org/
2. Follow the quickstart guide to get Mongo started:
     Mac OS X:   http://docs.mongodb.org/manual/tutorial/install-mongodb-on-os-x/
     Windows: http://docs.mongodb.org/manual/tutorial/install-mongodb-on-windows/

3a. Go to the [MONGO_INSTALL]/bin folder and type: './mongo' to start a mongo shell.
    For windows users type: 'mongo.exe' (without the apostrophies)

3b. Create a  database name "cellar" by typing  'use cellar' as shown below and add a user
    name 'test' with a password 'test'. More infomation on how to add authentication can be
    found here (http://docs.mongodb.org/manual/tutorial/control-access-to-mongodb-with-authentication/).
    NOTE: if you choose to user different username and password please update the mongo.properties file
    located in the project at /src/main/resources/spring

        > use cellar
        switched to db cellar
        > show users
        > db.addUser("test","test")
        {
            "user" : "test",
            "readOnly" : false,
            "pwd" : "a6de521abefc2fed4f5876855a3484f5",
            "_id" : ObjectId("50b4032bb889628954b32b31")
        }
        >

4. Import the Dynamic Web Project in Eclipse or IntelliJ

5. Locate mongo.properties and make sure the connection info matches your database configuration

6. Run the project. (mvn clean package jetty:run)
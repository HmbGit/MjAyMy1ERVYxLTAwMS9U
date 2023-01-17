# Board Game

to test our project you need to install Java https://www.oracle.com/java/technologies/downloads/

# Build a jar and run it
To be able to run your Spring Boot app, you will need to first build it.

- mvn install

# Run Spring Boot app with java -jar command
To run your Spring Boot app from a command line in a Terminal window, you can you the java -jar command.
This is provided your Spring Boot app was packaged as an executable jar file.

- java -jar target/game-0.0.1-SNAPSHOT.jar
# Run Spring Boot app using Maven
You can also use the Maven plugin to run your Spring Boot app.
Use the below example to run your Spring Boot app with the Maven plugin
- mvn spring-boot:run

# Use Postman to request our app and create square

we are going to une postman :

- fill the URL with : localhost:8080/square/create

- make the Method  POST

- and fill the body with
  {
  "xoValue":"X",
  "index":"6"
  }

So imagine that we have a board Game with 9 square: 

 - 0 à 8 for index
 - xoValue filled with "X" or "O"

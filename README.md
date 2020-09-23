# Random Phrase Web Application

The SpringBoot application which loads a list of phrases from the txt file,
saves them in memory database, and creates an endpoint to get a page that contains a random phrase

### Requirements
* Java 8 or higher
* Maven 3 or higher 

### Installation
This is a maven project which builds spring boot application

Specify the phrases list if required in `resources/phrases.txt`
```
phrase1
phrase2
..
```

After that build (using maven)
```sh
mvn clean package
```
and run web application (using java)
```sh
java -jar target\random.phrases-1.0.0.jar
```



Another way to start the application is to create a run configuration of `Application.java` with the desired parameters in the IDE

### Usage

Home page is available at http://localhost:8080
![](https://raw.githubusercontent.com/sergey-khol/random-phrase-web-server/master/readme_result.png)

Every time you reload the page, a random phrase will be displayed

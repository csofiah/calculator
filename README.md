# calculator-rest-api
This is an example of a basic Calculator exposed as Rest Api using SpringBoot and Maven

##STEPS FOR COMPILE THE PROJECT 

1.First you must register the external jar called tracer.jar. 
Please open the terminal inside the folder "libs" of the project and then execute this command:

*mvn org.apache.maven.plugins:maven-install-plugin:2.5.2:install-file -Dfile=tracer-1.0.0.jar*

2.Then update the dependences of maven

3. Clean the project with maven with this command:
*mvn clean*

4. Compile the project
*mvn compile*
   
5. Documentacion about the project you can get when running this command:
*mvn javadoc:javadoc* and when finished you can see the path for that.

## Run
As with every Spring Boot application, it can be runned in the terminal using the following command 
*./mvnw spring-boot:run* or *mvnw spring-boot:run* if you run in the main root of the project

After that the application can be acceded by this url: *http://localhost:8080/api/calculator/*

Example for run the add method with a postman tool:
*http://localhost:8080/api/calculator/add*
method: POST
Select the tap Body, raw as JSON an put this data:
{
"number1": 3.0,
"number2": 4.0
}
Result:
{
"number1": 3.0,
"number2": 4.0,
"result": 7.0
}

Example for run the add method with a postman tool:
*http://localhost:8080/api/calculator/subtract*
method: POST
Select the tap Body, raw as JSON an put this data:
{
"number1": 15,
"number2": 0.5
}
Result:
{
"number1": 15,
"number2": 0.5
"result": 14.5
}




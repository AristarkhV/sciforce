# sciforce test task

Main goal: 
Implement `join` of two JSON data sources. #1 hosted on the Internet and #2 hosted locally in some file.
Your program should accept URL/path as an argument using any of the following approaches: command line / config / interactive.

The single datasource is a products enumeration for a particular stock. Both datasources are of the following format:
[{productUuid: "123e4567-e89b-12d3-a456-426655440000", productName: "Kattle", amount: 3},{productUuid: "123e4567-e89b-12d3-a456-426655440002", productName: "Teapot", amount: 1}]

You must read both and calculate the total amount for each referenced product and output JSON data in the same format. You can just use System.out.println to output data.

You should use Gradle or Maven and push your code to GitHub. 

Optionally:
-	implement it as a web-application (Servlet or REST API)
-	automate application launch process (Gradle/Maven task or Spring Boot)
-	make use of some OOP design patterns
-	support for more than 2 datasources
-	add an additional output field availability, Map datasetNumber -> amount availability: {"#1": 3, "#2": 2}}
to have information how many items either stock has
-	exception handling if datasource contains the same productUuid twice

Sample test input data:
https://sciforce.solutions/downloads/sciforce-java-test1.json
https://sciforce.solutions/downloads/sciforce-java-test2.json

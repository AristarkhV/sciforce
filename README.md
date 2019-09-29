# sciforce test task

The app implement `join` of two JSON data sources (model - ProductAmountDTO). 
#1 hosted on the Internet and #2 hosted locally in some file (path=/resources/public/test2.json).

Both datasources are of the following format:
[{productUuid: "123e4567-e89b-12d3-a456-426655440000", productName: "Kattle", amount: 3},{productUuid: "123e4567-e89b-12d3-a456-426655440002", productName: "Teapot", amount: 1}]

App read both (model - Stock) and calculate the total amount for each referenced product and output JSON data in the same format.

Sample test input data:
https://sciforce.solutions/downloads/sciforce-java-test1.json
https://sciforce.solutions/downloads/sciforce-java-test2.json

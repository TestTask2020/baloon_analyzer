# baloon_analyzer

How to run:
1. run the command "docker-compose up" to run the rabbitmq image
2. go to baloon-consumer folder and run "mvn clean install" and after "mvn spring-boot:run"
3. go to baloon-producer folder and run "mvn clean install" and after "mvn spring-boot:run"

Baloon consumer outputs the statistics to the log.

Run curl --location --request GET 'localhost:8080/weather-history?dateFrom=2020-11-27T11:52&dateTo=2020-11-27T12:52'
ot the same request from your browser to view the history.
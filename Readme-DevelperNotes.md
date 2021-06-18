# Developer Notes #


Development/Execution requisites: Java 1.8+, Maven, Tomcat v9.0, Eclipse 


Sample Run (using Curl)

## GET Request via CURL ##

curl http://localhost:8080/EqPancreditDeveloperTest/ApiServlet | json_pp


## ADD - PUT Request ##
curl --request PUT http://localhost:8080/EqPancreditDeveloperTest/ApiServlet --header 'Content-Type: application/json' -d '{"Id": "999-0f6eb0a1-3e48-49b6-8990-705a962fb048ff", "ApplicationId": 456299, "Type": "Debit","Summary": "Payment","Amount": 52.92,"PostingDate":"2017-01-01T00:00:00","IsCleared": true, "ClearedDate": "2017-01-02T00:00:00"}'


## UPDATE - POST Request ##
curl --request POST http://localhost:8080/EqPancreditDeveloperTest/ApiServlet --header 'Content-Type: application/json' -d '{"Id": "999-0f6eb0a1-3e48-49b6-8990-705a962fb048ff", "ApplicationId": 456299, "Type": "Debit","Summary": "Payment","Amount": 52.92,"PostingDate":"2017-01-01T00:00:00","IsCleared": false, "ClearedDate": "2017-01-02T00:00:00"}'

## DELETE Request ##

curl --request DELETE http://localhost:8080/EqPancreditDeveloperTest/ApiServlet?id=999-0f6eb0a1-3e48-49b6-8990-705a962fb048ff

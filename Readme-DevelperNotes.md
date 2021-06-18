## Developer Notes ##

# GET Request via CURL #

curl http://localhost:8080/EqPancreditDeveloperTest/ApiServlet | json_pp


# ADD - PUT Request via CURL #
curl --request PUT http://localhost:8080/EqPancreditDeveloperTest/ApiServlet --header 'Content-Type: application/json' -d '{"Id": "999-0f6eb0a1-3e48-49b6-8990-705a962fb048ff", "ApplicationId": 456299, "Type": "Debit","Summary": "Payment","Amount": 52.92,"PostingDate":"2017-01-01T00:00:00","IsCleared": true, "ClearedDate": "2017-01-02T00:00:00"}'


# UPDATE - POST Request via CURL #
curl --request POST http://localhost:8080/EqPancreditDeveloperTest/ApiServlet --header 'Content-Type: application/json' -d '{"Id": "999-0f6eb0a1-3e48-49b6-8990-705a962fb048ff", "ApplicationId": 456299, "Type": "Debit","Summary": "Payment","Amount": 52.92,"PostingDate":"2017-01-01T00:00:00","IsCleared": false, "ClearedDate": "2017-01-02T00:00:00"}'

# DELETE Request via CURL #

curl --request DELETE http://localhost:8080/EqPancreditDeveloperTest/ApiServlet?id=999-0f6eb0a1-3e48-49b6-8990-705a962fb048ff

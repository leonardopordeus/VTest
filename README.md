# VTest
# Sample application for a customer registration with spring boot framework

To Build the application:

 `.\mvnw.cmd clean package`
 
 To run the application:
 
 `java -jar .\target\VTest-0.0.1-SNAPSHOT.jar`
 
 
 #Rest API:
 
 - To Create a new Costumer:
 
  POST: `http://{appUrl}:{appPort}/api/customer/`
 
 `{
        "documentId": "{documentId-unique}",
        "name": "{name}",
        "age": "{age}",
        "addresses": [
            {
                "id": {id},
                "zipCode": "99999-999",
                "number": "{number}"
            },
           ...
        ]
    }`
    
- To Update a Costumer:
 
  PUT: `http://{appUrl}:{appPort}/api/customer/{id}`
 
 `{
        "documentId": "{documentId-unique}",
        "name": "{name}",
        "age": "{age}",
        "addresses": [
            {
                "id": {id},
                "zipCode": "99999-999",
                "number": "{number}"
            },
           ...
        ]
    }`

- To Get a Costumer:
 
  GET: `http://{appUrl}:{appPort}/api/customer/{id}`
  
- To Delete a Costumer:
 
  DELETE: `http://{appUrl}:{appPort}/api/customer/{id}`
  
- To Filter a Costumer:
 
  POST: `http://{appUrl}:{appPort}/api/customer/list`
  
  `{
    "name": "{name}",
    "documentId": "{documentId}",
    "zipCode": "{zipCode}"
    }`

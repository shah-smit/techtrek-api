## API Document

Customer Microservice is a Spring Boot Application designed to provide simple APIs operations for CustomerProfile and their Transactions

### API Definition

- [Customer Profile API](#Customer-Profile-API)
- [Transaction API](#Transaction-API)



#### Customer Profile API

GET `/customer`

Description: Returns List of Customers available in the DB.

Response Status: 200
Response Body:
```json5
[
  {
    "customerId": "string",
    "fullName": "string",
    "firstName": "string",
    "lastName": "string",
    "address": "string",
    "joinedDate": "string",
    "dateOfBirth": "string"
  }
]
```

POST `/customer`

Description: It provides ability to add Customer to a DB.

Request Body:
```json5
{
  "customerId": "string",
  "fullName": "string",
  "firstName": "string",
  "lastName": "string",
  "address": "string",
  "joinedDate": "string",
  "dateOfBirth": "string"
}
```

Response Status: 201
Response Body: NA

GET `/customer/{customerId}`

Description: It returns a customer based on customerId provided in the path variable. Example, `/customer/abc` where `abc` is the customer id.

Response Status: 200
Response Body:
```json5
{
  "customerId": "string",
  "fullName": "string",
  "firstName": "string",
  "lastName": "string",
  "address": "string",
  "joinedDate": "string",
  "dateOfBirth": "string"
}
```

PUT `/customer/{customerId}`

Description: It will update the details of the customer for the given `customerId` in the path variable. Example, `/customer/abc` where `abc` is the customer id.

Response Status: 200
Response Body: NA

#### Transaction API

GET `/transaction/customer/{customerId}`

Description: It returns transactions based on the `customerId` provided in the path variable. Example, `/transaction/customer/abc` where `abc` is the customer id.

Response Status: 200
Response:
```json5
[
  {
    "transactionId": "string",
    "customerId": "string",
    "toAccountId": "string",
    "fromAccountId": "string",
    "amount": 0,
    "localDateTime": "2020-08-22T07:08:51.877Z"
  }
]
```

POST `/transaction`

Description: It add transaction into the DB

Request Body:
```json5
{
  "customerId": "string",
  "toAccountId": "string",
  "fromAccountId": "string",
  "amount": 0
}
```

Response Status: 201
Response Body: NA

#### Notes

##### HEADER

In order to consume the API, you will need to pass the `Authorization` header in the request. The header is generated via the below logic.

The `Authorization` header consists of `username` and `password` which will be provided by the admins or maintainer of this site. However in order not to pass the username and password in the plain text, you will have to encode the value using Base64 library.


###### Base64 Transformation in different lang

For Java, you may use the below line:
```
String encoded = new String(Base64.getEncoder().encode((username+":"+password).getBytes()));
String header = "Authorization: Basic "+encoded;
```

For Angular, you may use the below line:
```javascript
encoded = btoa(username + ':' + password)
header = "Authorization: Basic "+encoded
```

###### Step by Step guide

Here is an example:
Step 1: Retrieve `username` and `password`
`username` : `testuser`
`password` : `dummypassword`

Step 2: Encode the string in the following format `username:password` 
```
String encoded = new String(Base64.getEncoder().encode((username+":"+password).getBytes()));
```
The value of the encoded will be `dGVzdHVzZXI6ZHVtbXlwYXNzd29yZA==` 

Step 3: Now you may use the encoded value in Authorization header
```
Authorization:Basic dGVzdHVzZXI6ZHVtbXlwYXNzd29yZA==
```

CURL request will look like:
```
curl -XGET 
-H 'Authorization: Basic VGVhbUE6dGVhbWFwYXNzd29yZA==' 
-H "Content-type: application/json" 
'http://localhost:5000/customer'
```

In Angular request will look like:
```
const headers = new HttpHeaders({
            authorization : 'Basic ' + btoa(username + ':' + password)
        });
```


#### Useful Links

- [Angular Documentation](https://spring.io/guides/tutorials/spring-security-and-angular-js/)

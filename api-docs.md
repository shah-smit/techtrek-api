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
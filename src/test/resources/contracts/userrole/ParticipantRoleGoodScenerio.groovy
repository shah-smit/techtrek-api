package contracts.userrole

import org.springframework.cloud.contract.spec.Contract

[
        Contract.make {
            name("requestWithValidUsernameShouldReturnBodyOk")
            request {
                method GET()
                url('/customer/mockuser')
                headers {
                    contentType(applicationJson())
                    header('Authorization', "Basic YWRtaW46cGFzc3dvcmQ=")
                }
            }
            response {
                status OK()
                body([
                        "customerId": anyNonBlankString(),
                        "fullName": anyNonBlankString(),
                        "firstName"  : anyNonBlankString(),
                        "lastName": anyNonBlankString(),
                        "address": anyNonBlankString(),
                        "joinedDate"  : anyNonBlankString(),
                        "dateOfBirth"  : anyNonBlankString()
                ])
            }
        },
        Contract.make {
            name("requestWithValidArgsShouldAddCustomer")
            request {
                method POST()
                url('/customer')
                headers {
                    contentType(applicationJson())
                    header('Authorization', "Basic YWRtaW46cGFzc3dvcmQ=")
                    body(
                            "customerId": anyNonBlankString(),
                            "fullName": anyNonBlankString(),
                            "firstName"  : anyNonBlankString(),
                            "lastName": anyNonBlankString(),
                            "address": anyNonBlankString(),
                            "joinedDate"  : anyNonBlankString(),
                            "dateOfBirth"  : anyNonBlankString()
                    )
                }
            }
            response {
                status CREATED()
            }
        },
        Contract.make {
            name("requestWithValidCustomerIdShouldReturnBodyOk")
            request {
                method GET()
                url('/transaction/customer/mockcustomer')
                headers {
                    contentType(applicationJson())
                    header('Authorization', "Basic YWRtaW46cGFzc3dvcmQ=")
                }
            }
            response {
                status OK()
                body([
                        [
                                "transactionId": anyNonBlankString(),
                                "customerId": anyNonBlankString(),
                                "fromAccountId": anyNonBlankString(),
                                "localDateTime": anyNonBlankString(),
                                "toAccountId"  : anyNonBlankString(),
                                "amount" : anyNumber()
                        ]
                ])
            }
        },
        Contract.make {
            name("requestWithValidArgsShouldAddTransaction")
            request {
                method POST()
                url('/transaction')
                headers {
                    contentType(applicationJson())
                    header('Authorization', "Basic YWRtaW46cGFzc3dvcmQ=")
                    body(
                            "customerId": anyNonBlankString(),
                            "toAccountId": anyNonBlankString(),
                            "fromAccountId": anyNonBlankString(),
                            "amount": anyNumber()
                    )
                }
            }
            response {
                status CREATED()
            }
        }
]
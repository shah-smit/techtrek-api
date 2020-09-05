package contracts.adminrole

import org.springframework.cloud.contract.spec.Contract

[
        Contract.make {
            name("requestWithValidUsernameShouldReturnBodyCustomerResponseWithOkStatus")
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
            name("requestWithValidUsernameShouldReturnParticipantBodyStatusOk")
            request {
                method GET()
                url('/participant/mockuser')
                headers {
                    contentType(applicationJson())
                    header('Authorization', "Basic YWRtaW46cGFzc3dvcmQ=")
                }
            }
            response {
                status OK()
                body([
                        "username": anyNonBlankString(),
                        "password": anyNonBlankString(),
                        "active"  : anyBoolean()
                ])
            }
        },
        Contract.make {
            name("requestWithValidArgsShouldAddParticipant")
            request {
                method POST()
                url('/participant')
                headers {
                    contentType(applicationJson())
                    header('Authorization', "Basic YWRtaW46cGFzc3dvcmQ=")
                    body(
                            "username": anyNonBlankString(),
                            "password": anyNonBlankString()
                    )
                }
            }
            response {
                status CREATED()
            }
        }
]
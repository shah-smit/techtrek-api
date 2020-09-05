package contracts.transaction

import org.springframework.cloud.contract.spec.Contract

[
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
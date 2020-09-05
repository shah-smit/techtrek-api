package contracts.customer

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
        }
]
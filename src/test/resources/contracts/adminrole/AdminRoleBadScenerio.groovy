package contracts.adminrole

import org.springframework.cloud.contract.spec.Contract

[
        Contract.make {
            name("requestWithValidCustomerBodyShouldThrowForbiddenError")
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
                status FORBIDDEN()
            }
        },
        Contract.make {
            name("requestWithValidTransactionBodyShouldThrowForbiddenError")
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
                status FORBIDDEN()
            }
        }
]
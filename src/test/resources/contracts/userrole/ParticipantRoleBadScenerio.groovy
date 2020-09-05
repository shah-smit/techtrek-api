package contracts.userrole

import org.springframework.cloud.contract.spec.Contract

[
        Contract.make {
            name("requestWithValidUsernameShouldReturnForbidden")
            request {
                method GET()
                url('/participant/mockuser')
                headers {
                    contentType(applicationJson())
                    header('Authorization', "Basic YWRtaW46cGFzc3dvcmQ=")
                }
            }
            response {
                status FORBIDDEN()
            }
        },
        Contract.make {
            name("requestWithValidArgsShouldThrowForbiddenError")
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
                status FORBIDDEN()
            }
        }
]
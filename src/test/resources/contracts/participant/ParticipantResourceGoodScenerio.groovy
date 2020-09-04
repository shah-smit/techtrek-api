package contracts.participant

import org.springframework.cloud.contract.spec.Contract

[
        Contract.make {
            name("requestWithValidUsernameShouldReturnBodyOk")
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
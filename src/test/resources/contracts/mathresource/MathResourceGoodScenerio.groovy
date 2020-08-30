package contracts.mathresource

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name("requestWithValidPathVariablesShouldReturnBodyOk")
    request {
        method GET()
        url('/area/rectangle/10/11')
        headers {
            contentType(applicationJson())
            header 'Authorization': 'Basic ZHVtbXlfdXNlcm5hbWU6ZHVtbXlfcGFzc3dvcmQ='
        }
    }
    response {
        status OK()
        body([
                shape: $("rectangle"),
                area : $(110)
        ])
    }
}
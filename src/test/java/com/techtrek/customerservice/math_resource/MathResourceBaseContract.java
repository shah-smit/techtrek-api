package com.techtrek.customerservice.math_resource;

import com.techtrek.customerservice.resource.BaseTestClass;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AreaCalculationController.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MathResourceBaseContract {

    private static final String HTTP_LOCALHOST = "http://localhost:";

    @LocalServerPort
    private Integer port;

    @BeforeAll
    public void setup() {
        RestAssured.baseURI = HTTP_LOCALHOST + port;
    }
}

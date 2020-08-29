package com.techtrek.customerservice.resource;

import io.restassured.RestAssured;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BaseTestClass {

    private static final String HTTP_LOCALHOST = "http://localhost:";

    @LocalServerPort
    private Integer port;

    @BeforeAll
    public void setup() {
        RestAssured.baseURI = HTTP_LOCALHOST + port;
    }
}
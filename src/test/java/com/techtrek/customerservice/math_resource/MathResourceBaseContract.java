package com.techtrek.customerservice.math_resource;

import com.techtrek.customerservice.CustomerServiceApplication;
import com.techtrek.customerservice.config.user_security.ApplicationUserPermission;
import com.techtrek.customerservice.config.user_security.ApplicationUserRole;
import com.techtrek.customerservice.config.user_security.ApplicationUserServiceAdapter;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.techtrek.customerservice.test_data_provider.ParticipantTestDataProvider.getAdminAuthorities;

@Slf4j
@ExtendWith(SpringExtension.class)
@WithMockUser(username = "admin", password = "password", authorities = {"participant:read", "customer:read", "ROLE_ADMIN", "transaction:read", "participant:write"})
@SpringBootTest(classes = CustomerServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MathResourceBaseContract {

    private static final String HTTP_LOCALHOST = "http://localhost:";

    @LocalServerPort
    private Integer port;

    @BeforeEach
    public void setup() {
        log.info("Test {}", getAdminAuthorities());
        RestAssured.baseURI = HTTP_LOCALHOST + port;
    }
}

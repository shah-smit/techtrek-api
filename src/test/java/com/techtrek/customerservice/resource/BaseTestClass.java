package com.techtrek.customerservice.resource;

import com.techtrek.customerservice.CustomerServiceApplication;
import com.techtrek.customerservice.config.user_security.ApplicationUserServiceAdapter;
import com.techtrek.customerservice.customer.CustomerProfileService;
import com.techtrek.customerservice.participant.ParticipantService;
import com.techtrek.customerservice.transaction.TransactionService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CustomerServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseTestClass {

    public static final String HTTP_LOCALHOST = "http://localhost:";

    @LocalServerPort
    protected Integer port;

    @Autowired
    protected PasswordEncoder passwordEncoder;

    @MockBean
    protected ParticipantService participantService;

    @MockBean
    protected ApplicationUserServiceAdapter applicationUserServiceAdapter;

    @MockBean
    protected CustomerProfileService customerProfileService;

    @MockBean
    protected TransactionService transactionService;
}
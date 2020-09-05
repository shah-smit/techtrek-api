package com.techtrek.customerservice.role_admin_resource;

import com.techtrek.customerservice.CustomerServiceApplication;
import com.techtrek.customerservice.config.user_security.ApplicationUser;
import com.techtrek.customerservice.config.user_security.ApplicationUserRole;
import com.techtrek.customerservice.config.user_security.ApplicationUserServiceAdapter;
import com.techtrek.customerservice.customer.CustomerProfileService;
import com.techtrek.customerservice.participant.ParticipantService;
import com.techtrek.customerservice.transaction.TransactionService;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static com.techtrek.customerservice.test_data_provider.CustomerTestDataProvider.buildCustomer;
import static com.techtrek.customerservice.test_data_provider.ParticipantTestDataProvider.buildParticipant;
import static com.techtrek.customerservice.test_data_provider.TransactionDataProvider.buildTransactionList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CustomerServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AdminRoleBaseContract {

    private static final String HTTP_LOCALHOST = "http://localhost:";

    @LocalServerPort
    private Integer port;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @MockBean
    private CustomerProfileService customerProfileService;

    @MockBean
    private TransactionService transactionService;

    @MockBean
    private ParticipantService participantService;

    @MockBean
    private ApplicationUserServiceAdapter applicationUserServiceAdapter;

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = HTTP_LOCALHOST + port;
        when(customerProfileService.getCustomer(anyString())).thenReturn(buildCustomer());
        when(transactionService.getTransaction(anyString())).thenReturn(buildTransactionList());
        when(participantService.getParticipant(anyString())).thenReturn(Optional.of(buildParticipant()));
        when(applicationUserServiceAdapter.loadUserByUsername(anyString())).thenReturn(new ApplicationUser(
                ApplicationUserRole.ADMIN.getGrantedAuthorities(),
                passwordEncoder.encode("password"),
                "admin",
                true,
                true,
                true,
                true
        ));
    }
}
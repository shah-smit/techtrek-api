package com.techtrek.customerservice.role_participant_resource;

import com.techtrek.customerservice.config.user_security.ApplicationUser;
import com.techtrek.customerservice.config.user_security.ApplicationUserRole;
import com.techtrek.customerservice.resource.BaseTestClass;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;

import static com.techtrek.customerservice.test_data_provider.CustomerTestDataProvider.buildCustomer;
import static com.techtrek.customerservice.test_data_provider.TransactionDataProvider.buildTransactionList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@Slf4j
public class ParticipantRoleBaseContract extends BaseTestClass {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = HTTP_LOCALHOST + port;
        when(customerProfileService.getCustomer(anyString())).thenReturn(buildCustomer());
        when(transactionService.getTransaction(anyString())).thenReturn(buildTransactionList());
        when(applicationUserServiceAdapter.loadUserByUsername(anyString())).thenReturn(new ApplicationUser(
                ApplicationUserRole.PARTICIPANT.getGrantedAuthorities(),
                passwordEncoder.encode("password"),
                "admin",
                true,
                true,
                true,
                true
        ));
    }
}
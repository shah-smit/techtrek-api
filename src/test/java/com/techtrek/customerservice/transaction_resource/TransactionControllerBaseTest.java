package com.techtrek.customerservice.transaction_resource;

import com.techtrek.customerservice.config.user_security.ApplicationUser;
import com.techtrek.customerservice.config.user_security.ApplicationUserRole;
import com.techtrek.customerservice.resource.BaseTestClass;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

import static com.techtrek.customerservice.test_data_provider.TransactionDataProvider.buildTransactionList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class TransactionControllerBaseTest extends BaseTestClass {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = HTTP_LOCALHOST + port;
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

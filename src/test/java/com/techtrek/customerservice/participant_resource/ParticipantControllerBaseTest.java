package com.techtrek.customerservice.participant_resource;

import com.techtrek.customerservice.config.user_security.ApplicationUser;
import com.techtrek.customerservice.config.user_security.ApplicationUserRole;
import com.techtrek.customerservice.resource.BaseTestClass;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

import java.util.Optional;

import static com.techtrek.customerservice.test_data_provider.ParticipantTestDataProvider.buildParticipant;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class ParticipantControllerBaseTest extends BaseTestClass {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = HTTP_LOCALHOST + port;
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
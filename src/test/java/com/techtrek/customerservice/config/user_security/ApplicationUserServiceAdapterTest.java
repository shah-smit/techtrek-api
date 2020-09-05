package com.techtrek.customerservice.config.user_security;

import com.techtrek.customerservice.participant.ParticipantService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Optional;

import static com.techtrek.customerservice.test_data_provider.ParticipantTestDataProvider.buildParticipant;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ApplicationUserServiceAdapterTest {

    @InjectMocks
    private ApplicationUserServiceAdapter applicationUserServiceAdapter;

    @Mock
    private ParticipantService participantService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    public void setup(){
        ReflectionTestUtils.setField(applicationUserServiceAdapter, "username", "admin");
        ReflectionTestUtils.setField(applicationUserServiceAdapter, "password", "password");
    }

    @Test
    public void testShouldReturnAdminApplicationUser(){
        UserDetails applicationUser = applicationUserServiceAdapter.loadUserByUsername("admin");

        assertNotNull(applicationUser);
        assertEquals("admin", applicationUser.getUsername());
        Mockito.verify(participantService, Mockito.never()).getParticipant(eq("admin"));
        Mockito.verify(passwordEncoder, times(1)).encode(eq("password"));
    }

    @Test
    public void testShouldThrowUsernameNotFoundException(){
        UsernameNotFoundException usernameNotFoundException = assertThrows(UsernameNotFoundException.class, () -> applicationUserServiceAdapter.loadUserByUsername("mockuser"));

        assertNotNull(usernameNotFoundException);
        assertEquals( "mockuserNot Found", usernameNotFoundException.getMessage());
        Mockito.verify(participantService, times(1)).getParticipant(eq("mockuser"));
    }

    @Test
    public void testShouldReturnApplicationUserFromParticipantService(){
        when(participantService.getParticipant(eq("Smit Shah"))).thenReturn(Optional.of(buildParticipant()));

        UserDetails userDetails = applicationUserServiceAdapter.loadUserByUsername("Smit Shah");

        assertNotNull(userDetails);
        Mockito.verify(participantService, times(1)).getParticipant(eq("Smit Shah"));
        Mockito.verify(passwordEncoder, never()).encode(eq("Smit"));
    }

}

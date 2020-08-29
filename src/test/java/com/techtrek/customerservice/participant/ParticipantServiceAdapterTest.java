package com.techtrek.customerservice.participant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.techtrek.customerservice.test_data_provider.ParticipantTestDataProvider.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ParticipantServiceAdapterTest {

    @InjectMocks
    private ParticipantServiceAdapter participantServiceAdapter;
    @Mock
    private PasswordService passwordService;
    @Mock
    private ParticipantCommandRepo participantCommandRepo;
    @Mock
    private ParticipantQueryRepo participantQueryRepo;

    @Test
    public void testShouldAddParticipant(){
        when(passwordService.encode(any())).thenReturn("encodedpassword");

        participantServiceAdapter.addParticipant(buildParticipant());

        Participant encodedPasswordParticipant = buildParticipant();
        encodedPasswordParticipant.setPassword("encodedpassword");
        verify(participantCommandRepo, times(1)).addParticipant(encodedPasswordParticipant);
    }

    @Test
    public void testShouldGetParticipantWhenValidParticipantIdProvided(){
        Participant participant = buildParticipant();
        when(participantQueryRepo.getParticipant(eq(participant.getUsername()))).thenReturn(participant);

        Optional<Participant> participant1 = participantServiceAdapter.getParticipant(participant.getUsername());

        assertTrue(participant1.isPresent());
        assertEquals(participant1.get(), participant);
    }


}

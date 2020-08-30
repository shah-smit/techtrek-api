package com.techtrek.customerservice.participant_adapter;

import com.techtrek.customerservice.participant.Participant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static com.techtrek.customerservice.test_data_provider.CustomerTestDataProvider.*;
import static com.techtrek.customerservice.test_data_provider.ParticipantTestDataProvider.buildParticipant;
import static com.techtrek.customerservice.test_data_provider.ParticipantTestDataProvider.buildParticipantEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class ParticipantAdapterTest {

    @InjectMocks
    private ParticipantRepoAdapter participantRepoAdapter;

    @Mock
    private ParticipantRepository participantRepository;

    @Test
    @WithMockUser(username = USERNAME)
    public void testShouldAddParticipant(){
        Participant participant = buildParticipant();

        when(participantRepository.save(any(ParticipantEntity.class))).thenReturn(buildParticipantEntity());

        participantRepoAdapter.addParticipant(participant);

        verify(participantRepository, times(1)).save(eq(buildParticipantEntity()));
    }

    @Test
    public void testShouldReturnParticipantForValidUsername(){
        Participant participant = buildParticipant();


        when(participantRepository.findById(eq(participant.getUsername()))).thenReturn(Optional.of(buildParticipantEntity()));

        Participant participant1 = participantRepoAdapter.getParticipant(participant.getUsername());


        verify(participantRepository, times(1)).findById(participant.getUsername());
        assertEquals(participant, participant1);
    }
}

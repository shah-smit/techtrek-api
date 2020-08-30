package com.techtrek.customerservice.test_data_provider;

import com.techtrek.customerservice.participant.Participant;
import com.techtrek.customerservice.participant_adapter.ParticipantEntity;

public class ParticipantTestDataProvider {
    public static Participant buildParticipant(){
        return Participant.builder()
                .password("Smit")
                .username("Smit Shah")
                .isActive(true)
                .build();
    }

    public static ParticipantEntity buildParticipantEntity(){
        ParticipantEntity participantEntity = new ParticipantEntity();
        participantEntity.setUsername("Smit Shah");
        participantEntity.setPassword("Smit");
        participantEntity.setActive(true);
        participantEntity.setAuthenticationId("Smit");

        return participantEntity;
    }
}

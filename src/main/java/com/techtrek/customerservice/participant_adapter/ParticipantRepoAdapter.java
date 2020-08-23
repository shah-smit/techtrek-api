package com.techtrek.customerservice.participant_adapter;

import com.techtrek.customerservice.participant.Participant;
import com.techtrek.customerservice.participant.ParticipantCommandRepo;
import com.techtrek.customerservice.participant.ParticipantQueryRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ParticipantRepoAdapter implements ParticipantCommandRepo, ParticipantQueryRepo {

    private ParticipantRepository participantRepository;

    @Override
    public void addParticipant(Participant participant) {
        participantRepository.save(mapToParticipantEntity(participant));
    }

    @Override
    public Participant getParticipant(String username) {
        return mapToParticipant(participantRepository.findById(username).orElseThrow());
    }

    private ParticipantEntity mapToParticipantEntity(Participant participant){
        ParticipantEntity participantEntity = new ParticipantEntity();
        participantEntity.setUsername(participant.getUsername());
        participantEntity.setPassword(participant.getPassword());
        participantEntity.setActive(participant.isActive());
        return participantEntity;
    }

    private Participant mapToParticipant(ParticipantEntity participantEntity){
        return Participant.builder()
                .username(participantEntity.getUsername())
                .password(participantEntity.getPassword())
                .isActive(participantEntity.isActive())
                .build();
    }
}

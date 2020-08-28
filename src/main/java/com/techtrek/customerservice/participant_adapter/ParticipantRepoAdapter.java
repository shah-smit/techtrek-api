package com.techtrek.customerservice.participant_adapter;

import com.techtrek.customerservice.participant.Participant;
import com.techtrek.customerservice.participant.ParticipantCommandRepo;
import com.techtrek.customerservice.participant.ParticipantQueryRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

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

        Optional<ParticipantEntity> participantEntity = participantRepository.findById(username);

        if(participantEntity.isPresent()){
            return mapToParticipant(participantEntity.get());
        }

        return participantEntity.map(this::mapToParticipant)
                .orElseThrow(() -> new RuntimeException("Participant Not Found"));
    }

    private ParticipantEntity mapToParticipantEntity(Participant participant){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        ParticipantEntity participantEntity = new ParticipantEntity();
        participantEntity.setUsername(participant.getUsername());
        participantEntity.setPassword(participant.getPassword());
        participantEntity.setActive(participant.isActive());
        participantEntity.setAuthenticationId(authentication.getName());
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

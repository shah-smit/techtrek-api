package com.techtrek.customerservice.participant;

import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class ParticipantServiceAdapter implements ParticipantService {

    private final PasswordService passwordService;
    private final ParticipantCommandRepo participantCommandRepo;
    private final ParticipantQueryRepo participantQueryRepo;

    @Override
    public void addParticipant(Participant participant) {
        participant.setPassword(passwordService.encode(participant.getPassword()));
        participant.setActive(true);
        participantCommandRepo.addParticipant(participant);
    }

    @Override
    public Optional<Participant> getParticipant(String username) {
        return Optional.of(participantQueryRepo.getParticipant(username));
    }
}

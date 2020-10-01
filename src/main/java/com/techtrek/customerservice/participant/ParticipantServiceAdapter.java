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
        if(participant.getPassword() == null) throw new RuntimeException("Password cannot be empty");
        if(participant.getUsername() == null) throw new RuntimeException("Username cannot be empty");
        participant.setPassword(passwordService.encode(participant.getPassword()));
        participant.setActive(true);
        participantCommandRepo.addParticipant(participant);
    }

    @Override
    public Optional<Participant> getParticipant(String username) {
        return Optional.of(participantQueryRepo.getParticipant(username));
    }
}

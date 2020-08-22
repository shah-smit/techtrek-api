package com.techtrek.customerservice.participant;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ParticipantServiceAdapter implements ParticipantService {

    private List<Participant> participantList = new ArrayList<>();
    private final PasswordService passwordService;

    @Override
    public void addParticipant(Participant participant) {
        participant.setPassword(passwordService.encode(participant.getPassword()));
        participant.setActive(true);
        participantList.add(participant);
    }

    @Override
    public Optional<Participant> getParticipant(String username) {
        return participantList.stream().filter(participant -> participant.getUsername().equals(username)).findAny();
    }
}

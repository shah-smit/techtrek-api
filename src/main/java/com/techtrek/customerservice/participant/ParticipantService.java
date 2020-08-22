package com.techtrek.customerservice.participant;

import java.util.Optional;

public interface ParticipantService {
    void addParticipant(Participant participant);
    Optional<Participant> getParticipant(String username);
}

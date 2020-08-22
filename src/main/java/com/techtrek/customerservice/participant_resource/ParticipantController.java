package com.techtrek.customerservice.participant_resource;

import com.techtrek.customerservice.participant.Participant;
import com.techtrek.customerservice.participant.ParticipantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/participant")
public class ParticipantController {

    private ParticipantService participantService;

    @GetMapping("/{username}")
    public Participant getParticipant(@PathVariable String username){
        return participantService.getParticipant(username).orElseThrow();
    }

    @PostMapping
    public void addParticipant(@RequestBody Participant participant){
        participantService.addParticipant(participant);
    }
}

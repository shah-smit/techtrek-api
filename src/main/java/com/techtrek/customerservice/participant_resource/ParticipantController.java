package com.techtrek.customerservice.participant_resource;

import com.techtrek.customerservice.participant.Participant;
import com.techtrek.customerservice.participant.ParticipantService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/participant")
public class ParticipantController {

    private final ParticipantService participantService;

    @GetMapping("/{username}")
    public Participant getParticipant(@PathVariable String username){
        return participantService.getParticipant(username).orElseThrow();
    }

    @PostMapping
    public String addParticipant(@RequestBody Participant participant){
        String newS = new String(java.util.Base64.getEncoder().encode((participant.getUsername()+":"+participant.getPassword()).getBytes()));
        participantService.addParticipant(participant);

        return "Please add the following header: \nAuthorization:Basic "+ newS;
    }
}

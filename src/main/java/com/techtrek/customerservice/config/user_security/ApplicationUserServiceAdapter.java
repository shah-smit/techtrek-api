package com.techtrek.customerservice.config.user_security;

import com.techtrek.customerservice.participant.Participant;
import com.techtrek.customerservice.participant.ParticipantService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApplicationUserServiceAdapter implements UserDetailsService {

    private final ParticipantService participantService;
    private final PasswordEncoder passwordEncoder;

    @Value("${admin.username}")
    private String username;

    @Value("${admin.password}")
    private String password;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if(s.equals(username)){
            return new ApplicationUser(
                    ApplicationUserRole.ADMIN.getGrantedAuthorities(),
                    passwordEncoder.encode(password),
                    username,
                    true,
                    true,
                    true,
                    true
            );
        }

        Optional<Participant> participant = participantService.getParticipant(s);
        return participant
                .map(this::mapToApplicationUser)
                .orElseThrow(() -> new UsernameNotFoundException(s+ "Not Found"));
    }

    private ApplicationUser mapToApplicationUser(Participant participant){
        return new ApplicationUser(
                ApplicationUserRole.PARTICIPANT.getGrantedAuthorities(),
                participant.getPassword(),
                participant.getUsername(),
                true,
                true,
                true,
                participant.isActive()
        );
    }
}

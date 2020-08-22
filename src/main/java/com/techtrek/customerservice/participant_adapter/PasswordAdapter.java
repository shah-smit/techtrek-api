package com.techtrek.customerservice.participant_adapter;

import com.techtrek.customerservice.participant.PasswordService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@AllArgsConstructor
public class PasswordAdapter implements PasswordService {

    private final PasswordEncoder passwordEncoder;

    @Override
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }
}

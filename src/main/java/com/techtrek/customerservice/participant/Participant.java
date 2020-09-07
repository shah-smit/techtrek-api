package com.techtrek.customerservice.participant;

import lombok.*;

@Getter
@Builder
public class Participant {
    private String username;
    @Setter
    private String password;
    @Setter
    private boolean isActive;
}

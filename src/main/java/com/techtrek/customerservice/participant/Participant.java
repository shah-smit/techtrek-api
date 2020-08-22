package com.techtrek.customerservice.participant;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Participant {
    private String username;
    @Setter
    private String password;
    @Setter
    private boolean isActive;
}

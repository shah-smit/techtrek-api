package com.techtrek.customerservice.participant;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Participant {
    private String username;
    @Setter
    private String password;
    @Setter
    private boolean isActive;
}

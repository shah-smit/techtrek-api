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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Participant that = (Participant) o;

        if (isActive != that.isActive) return false;
        if (!username.equals(that.username)) return false;
        return password.equals(that.password);
    }
}

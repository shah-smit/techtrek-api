package com.techtrek.customerservice.participant_adapter;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table
public class ParticipantEntity {
    @Id
    private String username;
    private String password;
    private boolean isActive;
    //Who added the participant
    private String authenticationId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ParticipantEntity that = (ParticipantEntity) o;

        if (isActive != that.isActive) return false;
        if (!username.equals(that.username)) return false;
        if (!password.equals(that.password)) return false;
        return authenticationId.equals(that.authenticationId);
    }
}

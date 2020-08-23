package com.techtrek.customerservice.participant_adapter;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class ParticipantEntity {
    @Id
    private String username;
    private String password;
    private boolean isActive;
}

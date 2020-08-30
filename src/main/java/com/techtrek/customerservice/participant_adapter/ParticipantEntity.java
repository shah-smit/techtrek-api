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
@ToString
@EqualsAndHashCode
public class ParticipantEntity {
    @Id
    private String username;
    private String password;
    private boolean isActive;
    //Who added the participant
    private String authenticationId;
}

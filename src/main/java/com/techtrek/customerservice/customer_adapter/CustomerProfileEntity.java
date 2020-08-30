package com.techtrek.customerservice.customer_adapter;

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
public class CustomerProfileEntity {
    @Id
    private String customerId;
    private String fullName;
    private String firstName;
    private String lastName;
    private String address;
    private String joinedDate;
    private String dateOfBirth;
    //Who added the customer
    private String authenticationId;
}

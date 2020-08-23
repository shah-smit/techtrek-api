package com.techtrek.customerservice.customer_adapter;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class CustomerProfileEntity {
    @Id
    private String customerId;
    private String fullName;
    private String firstName;
    private String lastName;
    private String address;
    private String joinedDate;
    private String dateOfBirth;
    //The person who added the Customer.
    private String adminId;
}

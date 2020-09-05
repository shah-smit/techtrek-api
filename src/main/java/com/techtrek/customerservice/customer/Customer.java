package com.techtrek.customerservice.customer;

import lombok.*;

@Getter
@Builder
public class Customer {
    private String customerId;
    private String fullName;
    private String firstName;
    private String lastName;
    private String address;
    private String joinedDate;
    private String dateOfBirth;
}

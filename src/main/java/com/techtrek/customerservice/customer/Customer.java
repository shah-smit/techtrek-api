package com.techtrek.customerservice.customer;

import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private String customerId;
    private String fullName;
    private String firstName;
    private String lastName;
    private String address;
    private String joinedDate;
    private String dateOfBirth;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (!customerId.equals(customer.customerId)) return false;
        if (!fullName.equals(customer.fullName)) return false;
        if (!firstName.equals(customer.firstName)) return false;
        if (!lastName.equals(customer.lastName)) return false;
        if (!address.equals(customer.address)) return false;
        if (!joinedDate.equals(customer.joinedDate)) return false;
        return dateOfBirth.equals(customer.dateOfBirth);
    }
}

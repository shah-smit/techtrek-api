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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerProfileEntity that = (CustomerProfileEntity) o;

        if (!customerId.equals(that.customerId)) return false;
        if (!fullName.equals(that.fullName)) return false;
        if (!firstName.equals(that.firstName)) return false;
        if (!lastName.equals(that.lastName)) return false;
        if (!address.equals(that.address)) return false;
        if (!joinedDate.equals(that.joinedDate)) return false;
        if (!dateOfBirth.equals(that.dateOfBirth)) return false;
        return authenticationId.equals(that.authenticationId);
    }
}

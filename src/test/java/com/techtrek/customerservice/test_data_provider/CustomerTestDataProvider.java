package com.techtrek.customerservice.test_data_provider;

import com.techtrek.customerservice.customer.Customer;
import com.techtrek.customerservice.customer_adapter.CustomerProfileEntity;

public class CustomerTestDataProvider {

    public static final String USERNAME = "Smit";

    public static Customer buildCustomer(){
        return Customer.builder()
                .firstName("Smit")
                .lastName("Shah")
                .fullName("Smit Shah")
                .joinedDate("29/08/2020")
                .dateOfBirth("12/12/2001")
                .address("Singapore")
                .customerId("RandomId")
                .build();
    }

    public static CustomerProfileEntity buildCustomerProfileEntity(){
        CustomerProfileEntity customerProfileEntity = new CustomerProfileEntity();
        customerProfileEntity.setAuthenticationId("Smit");
        customerProfileEntity.setFirstName("Smit");
        customerProfileEntity.setFullName("Smit Shah");
        customerProfileEntity.setLastName("Shah");
        customerProfileEntity.setJoinedDate("29/08/2020");
        customerProfileEntity.setDateOfBirth("12/12/2001");
        customerProfileEntity.setAddress("Singapore");
        customerProfileEntity.setCustomerId("RandomId");

        return customerProfileEntity;
    }
}

package com.techtrek.customerservice.customer_adapter;

import com.techtrek.customerservice.customer.Customer;
import com.techtrek.customerservice.customer.CustomerQueryRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomerQueryAdapter implements CustomerQueryRepo {

    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomer(String customerId) {
        return mapToCustomer(customerRepository.findById(customerId).orElseThrow());
    }

    private Customer mapToCustomer(CustomerProfileEntity customerProfileEntity) {
        return Customer.builder()
                .customerId(customerProfileEntity.getCustomerId())
                .address(customerProfileEntity.getAddress())
                .dateOfBirth(customerProfileEntity.getDateOfBirth())
                .joinedDate(customerProfileEntity.getJoinedDate())
                .fullName(customerProfileEntity.getFullName())
                .firstName(customerProfileEntity.getFirstName())
                .lastName(customerProfileEntity.getLastName())
                .build();
    }
}

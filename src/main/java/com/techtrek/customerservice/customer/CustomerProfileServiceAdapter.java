package com.techtrek.customerservice.customer;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class CustomerProfileServiceAdapter implements CustomerProfileService {

    private CustomerCommandRepo customerCommandRepo;
    private CustomerQueryRepo customerQueryRepo;

    @Override
    public Customer getCustomer(String id) {
        return customerQueryRepo.getCustomer(id);
    }

    @Override
    public List<Customer> getCustomer() {
        return new ArrayList<>();
    }

    @Override
    public void addCustomer(Customer customer) {
        if(customer.getCustomerId() == null) throw new RuntimeException("CustomerId cannot be empty");
        if(customer.getAddress() == null) throw new RuntimeException("Address cannot be empty");
        if(customer.getDateOfBirth() == null) throw new RuntimeException("Date of Birth cannot be empty");
        if(customer.getFirstName() == null) throw new RuntimeException("FirstName cannot be empty");
        if(customer.getLastName() == null) throw new RuntimeException("LastName cannot be empty");
        customerCommandRepo.addCustomer(customer);
    }

    @Override
    public void updateCustomer(String customerId, Customer customer) {
        customerCommandRepo.updateCustomer(customerId, customer);
    }
}

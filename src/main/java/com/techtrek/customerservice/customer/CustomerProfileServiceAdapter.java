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
        customerCommandRepo.addCustomer(customer);
    }

    @Override
    public void updateCustomer(String customerId, Customer customer) {
        customerCommandRepo.updateCustomer(customerId, customer);
    }
}

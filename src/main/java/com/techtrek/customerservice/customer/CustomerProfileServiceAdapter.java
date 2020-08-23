package com.techtrek.customerservice.customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerProfileServiceAdapter implements CustomerProfileService {

    List<Customer> customers = new ArrayList<>();

    @Override
    public Customer getCustomer(String id) {
        return customers.stream().filter(customer -> customer.getCustomerId().equals(id)).findAny().orElseThrow();
    }

    @Override
    public List<Customer> getCustomer() {
        return customers;
    }

    @Override
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public void updateCustomer(String customerId, Customer customer) {

    }
}

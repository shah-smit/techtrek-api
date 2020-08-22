package com.techtrek.customerservice.customer;

import java.util.List;

public interface CustomerProfileService {
    public Customer getCustomer(String id);
    public List<Customer> getCustomer();
    public void addCustomer(Customer customer);
    public void updateCustomer(String customerId, Customer customer);
}

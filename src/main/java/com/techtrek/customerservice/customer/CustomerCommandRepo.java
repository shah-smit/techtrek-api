package com.techtrek.customerservice.customer;

public interface CustomerCommandRepo {
    void addCustomer(Customer customer);
    void updateCustomer(String customerId, Customer customer);
}

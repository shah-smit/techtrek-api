package com.techtrek.customerservice.customer_adapter;

import com.techtrek.customerservice.customer.Customer;
import com.techtrek.customerservice.customer.CustomerCommandRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomerCommandAdapter implements CustomerCommandRepo {

    private CustomerRepository customerRepository;

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.save(mapToCustomerProfileEntity(customer));
    }

    @Override
    public void updateCustomer(String customerId, Customer customer) {
        customerRepository.save(mapToCustomerProfileEntity(customer));
    }

    private CustomerProfileEntity mapToCustomerProfileEntity(Customer customer) {
        CustomerProfileEntity customerProfileEntity = new CustomerProfileEntity();
        customerProfileEntity.setCustomerId(customer.getCustomerId());
        customerProfileEntity.setAddress(customer.getAddress());
        customerProfileEntity.setDateOfBirth(customer.getDateOfBirth());
        customerProfileEntity.setJoinedDate(customer.getJoinedDate());
        customerProfileEntity.setFullName(customer.getFullName());
        customerProfileEntity.setFirstName(customer.getFirstName());
        customerProfileEntity.setLastName(customer.getLastName());
        return customerProfileEntity;
    }

}

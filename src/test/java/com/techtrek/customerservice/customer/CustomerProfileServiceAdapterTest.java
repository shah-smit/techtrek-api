package com.techtrek.customerservice.customer;

import com.techtrek.customerservice.test_data_provider.CustomerTestDataProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerProfileServiceAdapterTest {
    @InjectMocks
    private CustomerProfileServiceAdapter customerProfileServiceAdapter;

    @Mock
    private CustomerCommandRepo customerCommandRepo;
    @Mock
    private CustomerQueryRepo customerQueryRepo;

    @Test
    public void testShouldSaveCustomer(){
        Customer customer = CustomerTestDataProvider.buildCustomer();

        customerProfileServiceAdapter.addCustomer(customer);

        Mockito.verify(customerCommandRepo, times(1)).addCustomer(eq(customer));
    }

    @Test
    public void testShouldUpdateCustomer(){
        Customer customer = CustomerTestDataProvider.buildCustomer();

        customerProfileServiceAdapter.updateCustomer(customer.getCustomerId(), customer);

        Mockito.verify(customerCommandRepo, times(1)).updateCustomer(eq(customer.getCustomerId()), eq(customer));
    }
}

package com.techtrek.customerservice.customer;

import com.techtrek.customerservice.test_data_provider.CustomerTestDataProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.techtrek.customerservice.test_data_provider.CustomerTestDataProvider.buildCustomer;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
        Customer customer = buildCustomer();

        customerProfileServiceAdapter.addCustomer(customer);

        Mockito.verify(customerCommandRepo, times(1)).addCustomer(eq(customer));
    }

    @Test
    public void testShouldUpdateCustomer(){
        Customer customer = buildCustomer();

        customerProfileServiceAdapter.updateCustomer(customer.getCustomerId(), customer);

        Mockito.verify(customerCommandRepo, times(1)).updateCustomer(eq(customer.getCustomerId()), eq(customer));
    }

    @Test
    public void testShouldGetCustomersWithEmptyList(){
        List<Customer> customerList = customerProfileServiceAdapter.getCustomer();

        assertEquals(0, customerList.size());
    }

    @Test
    public void testShouldGetCustomer(){
        when(customerQueryRepo.getCustomer(anyString())).thenReturn(buildCustomer());

        Customer customer = customerProfileServiceAdapter.getCustomer("mockuser");

        assertNotNull(customer);
    }
}

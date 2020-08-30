package com.techtrek.customerservice.customer_adapter;

import com.techtrek.customerservice.customer.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static com.techtrek.customerservice.test_data_provider.CustomerTestDataProvider.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class CustomerQueryAdapterTest {
    @InjectMocks
    private CustomerQueryAdapter customerQueryAdapter;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void testShouldReturnCustomerWhenCorrectCustomerIdPassed(){
        when(customerRepository.findById(eq("Smit")))
                .thenReturn(Optional.of(buildCustomerProfileEntity()));

        Customer customer = customerQueryAdapter.getCustomer("Smit");

        assertNotNull(customer);
        assertEquals(buildCustomer(), customer);
    }
}

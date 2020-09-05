package com.techtrek.customerservice.customer_adapter;

import com.techtrek.customerservice.customer.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static com.techtrek.customerservice.test_data_provider.CustomerTestDataProvider.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerQueryAdapterTest {
    @InjectMocks
    private CustomerQueryAdapter customerQueryAdapter;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    public void testShouldReturnCustomerWhenCorrectCustomerIdPassed(){
        Customer customer = buildCustomer();
        when(customerRepository.findById(eq("Smit")))
                .thenReturn(Optional.of(buildCustomerProfileEntity()));

        Customer customer1 = customerQueryAdapter.getCustomer("Smit");

        assertNotNull(customer1);

        assertEquals(customer.getAddress(), customer1.getAddress());
        assertEquals(customer.getCustomerId(), customer1.getCustomerId());
        assertEquals(customer.getDateOfBirth(), customer1.getDateOfBirth());
        assertEquals(customer.getFirstName(), customer1.getFirstName());
        assertEquals(customer.getLastName(), customer1.getLastName());
        assertEquals(customer.getJoinedDate(), customer1.getJoinedDate());
        assertEquals(customer.getFullName(), customer1.getFullName());
    }
}

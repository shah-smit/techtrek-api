package com.techtrek.customerservice.customer;

import com.techtrek.customerservice.test_data_provider.CustomerTestDataProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
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

    @Captor
    ArgumentCaptor<Customer> customerArgumentCaptor;

    @Test
    public void testShouldSaveCustomer(){
        Customer customer = buildCustomer();

        customerProfileServiceAdapter.addCustomer(customer);

        Mockito.verify(customerCommandRepo, times(1)).addCustomer(customerArgumentCaptor.capture());

        Customer customer1 = customerArgumentCaptor.getValue();
        assertEquals(customer.getAddress(), customer1.getAddress());
        assertEquals(customer.getCustomerId(), customer1.getCustomerId());
        assertEquals(customer.getDateOfBirth(), customer1.getDateOfBirth());
        assertEquals(customer.getFirstName(), customer1.getFirstName());
        assertEquals(customer.getLastName(), customer1.getLastName());
        assertEquals(customer.getJoinedDate(), customer1.getJoinedDate());
        assertEquals(customer.getFullName(), customer1.getFullName());
    }

    @Test
    public void testShouldUpdateCustomer(){
        Customer customer = buildCustomer();

        customerProfileServiceAdapter.updateCustomer(customer.getCustomerId(), customer);

        Mockito.verify(customerCommandRepo, times(1)).updateCustomer(eq(customer.getCustomerId()),customerArgumentCaptor.capture());

        Customer customer1 = customerArgumentCaptor.getValue();
        assertEquals(customer.getAddress(), customer1.getAddress());
        assertEquals(customer.getCustomerId(), customer1.getCustomerId());
        assertEquals(customer.getDateOfBirth(), customer1.getDateOfBirth());
        assertEquals(customer.getFirstName(), customer1.getFirstName());
        assertEquals(customer.getLastName(), customer1.getLastName());
        assertEquals(customer.getJoinedDate(), customer1.getJoinedDate());
        assertEquals(customer.getFullName(), customer1.getFullName());
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

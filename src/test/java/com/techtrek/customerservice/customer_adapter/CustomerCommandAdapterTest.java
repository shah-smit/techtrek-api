package com.techtrek.customerservice.customer_adapter;

import com.techtrek.customerservice.customer.Customer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.techtrek.customerservice.test_data_provider.CustomerTestDataProvider.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class CustomerCommandAdapterTest {

    @InjectMocks
    private CustomerCommandAdapter customerCommandAdapter;

    @Mock
    private CustomerRepository customerRepository;

    @Captor
    private ArgumentCaptor<CustomerProfileEntity> customerProfileEntityArgumentCaptor;

    @Test
    @WithMockUser(username = USERNAME)
    public void testShouldAddCustomerAfterSuccessfullyMapping(){
        Customer customer = buildCustomer();

        when(customerRepository.save(any(CustomerProfileEntity.class))).thenReturn(buildCustomerProfileEntity());

        customerCommandAdapter.addCustomer(customer);

        verify(customerRepository, times(1)).save(customerProfileEntityArgumentCaptor.capture());

        CustomerProfileEntity customerProfileEntity = customerProfileEntityArgumentCaptor.getValue();
        assertEquals(customer.getAddress(), customerProfileEntity.getAddress());
        assertEquals(customer.getCustomerId(), customerProfileEntity.getCustomerId());
        assertEquals(customer.getDateOfBirth(), customerProfileEntity.getDateOfBirth());
        assertEquals(customer.getFirstName(), customerProfileEntity.getFirstName());
        assertEquals(customer.getLastName(), customerProfileEntity.getLastName());
        assertEquals(customer.getJoinedDate(), customerProfileEntity.getJoinedDate());
        assertEquals(customer.getFullName(), customerProfileEntity.getFullName());
    }

    @Test
    public void testShouldThrowRuntimeExceptionWhenUpdateCustomer(){
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> customerCommandAdapter.updateCustomer("", buildCustomer()));

        assertNotNull(runtimeException);
        assertEquals(runtimeException.getMessage(), "Method Not Implemented");
    }
}

package com.techtrek.customerservice.transaction_adapter;

import com.techtrek.customerservice.transaction.Transaction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static com.techtrek.customerservice.test_data_provider.TransactionDataProvider.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class TransactionAdapterTest {
    @InjectMocks
    private TransactionAdapter transactionAdapter;

    @Mock
    private TransactionRepository transactionRepository;

    @Test
    @WithMockUser(username = "Smit")
    public void testShouldAddTransaction(){
        transactionAdapter.addTransaction(buildTransaction());

        verify(transactionRepository, times(1)).save(eq(buildTransactionEntity()));
    }

    @Test
    public void testShouldReturnTransactionsBasedOnCustomerId(){
        when(transactionRepository.findAll()).thenReturn(buildTransactionEntityList());

        List<Transaction> transactions = transactionAdapter.getCustomerTransaction(CUSTOMER_ID);

        assertNotNull(transactions);
        assertEquals(2, transactions.size());
    }
}

package com.techtrek.customerservice.transaction;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.techtrek.customerservice.test_data_provider.TransactionDataProvider.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentCaptor.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceAdapterTest {

    @InjectMocks
    private TransactionServiceAdapter transactionServiceAdapter;

    @Mock
    private TransactionCommandRepo commandRepo;
    @Mock
    private TransactionQueryRepo queryRepo;

    @Captor
    ArgumentCaptor<Transaction> transactionArgumentCaptor;

    @Test
    public void testShouldAddTransaction(){
        transactionServiceAdapter.addTransaction(buildTransaction());

        Mockito.verify(commandRepo, times(1)).addTransaction(transactionArgumentCaptor.capture());

        Transaction transaction = transactionArgumentCaptor.getValue();

        assertNotEquals(buildTransaction().getTransactionId(), transaction.getTransactionId());
        assertNotEquals(buildTransaction().getLocalDateTime(), transaction.getLocalDateTime());
        assertEquals(buildTransaction().getCustomerId(), transaction.getCustomerId());
        assertEquals(buildTransaction().getAmount(), transaction.getAmount());
        assertEquals(buildTransaction().getFromAccountId(), transaction.getFromAccountId());
        assertEquals(buildTransaction().getToAccountId(), transaction.getToAccountId());
    }

    @Test
    public void testShouldReturnCustomerTransactionsById(){
        when(transactionServiceAdapter.getTransaction(any())).thenReturn(buildTransactionList());

        List<Transaction> transactions = transactionServiceAdapter.getTransaction(CUSTOMER_ID);

        assertEquals(buildTransactionList().size(), transactions.size());
    }
}

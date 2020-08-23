package com.techtrek.customerservice.transaction;

import com.techtrek.customerservice.transaction.Transaction;

import java.util.List;

public interface TransactionQueryRepo {
    List<Transaction> getCustomerTransaction(String customerId);
}

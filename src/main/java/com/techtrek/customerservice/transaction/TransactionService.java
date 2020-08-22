package com.techtrek.customerservice.transaction;

import java.util.List;

public interface TransactionService {
    void addTransaction(Transaction transaction);
    List<Transaction> getTransaction(String customerId);
}

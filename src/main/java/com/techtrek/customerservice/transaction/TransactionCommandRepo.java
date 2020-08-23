package com.techtrek.customerservice.transaction;

import com.techtrek.customerservice.transaction.Transaction;

public interface TransactionCommandRepo {
    void addTransaction(Transaction transaction);
}

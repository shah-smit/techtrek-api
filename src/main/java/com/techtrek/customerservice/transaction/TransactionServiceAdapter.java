package com.techtrek.customerservice.transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionServiceAdapter implements TransactionService{

    List<Transaction> transactions = new ArrayList<>();

    @Override
    public void addTransaction(Transaction transaction) {
        transaction.setLocalDateTime();
        transaction.setTransactionId();

        transactions.add(transaction);
    }

    @Override
    public List<Transaction> getTransaction(String customerId) {
        return transactions.stream().filter(transaction -> transaction.getCustomerId().equals(customerId)).collect(Collectors.toList());
    }
}

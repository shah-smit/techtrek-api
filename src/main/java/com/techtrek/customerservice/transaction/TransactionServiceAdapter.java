package com.techtrek.customerservice.transaction;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TransactionServiceAdapter implements TransactionService{

    private final TransactionCommandRepo commandRepo;
    private final TransactionQueryRepo queryRepo;

    @Override
    public void addTransaction(Transaction transaction) {
        if(transaction.getCustomerId() == null) throw new RuntimeException("CustomerId cannot be empty");
        if(transaction.getAmount() <= 0) throw new RuntimeException("Amount cannot be empty or zero");
        if(transaction.getFromAccountId() == null) throw new RuntimeException("Account ID cannot be empty");
        transaction.setLocalDateTime();
        transaction.setTransactionId();

        commandRepo.addTransaction(transaction);
    }

    @Override
    public List<Transaction> getTransaction(String customerId) {
        return queryRepo.getCustomerTransaction(customerId);
    }
}

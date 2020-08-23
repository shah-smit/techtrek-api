package com.techtrek.customerservice.transaction;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TransactionServiceAdapter implements TransactionService{

    private final TransactionCommandRepo commandRepo;
    private final TransactionQueryRepo queryRepo;

    @Override
    public void addTransaction(Transaction transaction) {
        transaction.setLocalDateTime();
        transaction.setTransactionId();

        commandRepo.addTransaction(transaction);
    }

    @Override
    public List<Transaction> getTransaction(String customerId) {
        return queryRepo.getCustomerTransaction(customerId);
    }
}

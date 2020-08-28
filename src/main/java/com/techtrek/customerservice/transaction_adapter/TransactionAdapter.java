package com.techtrek.customerservice.transaction_adapter;

import com.techtrek.customerservice.transaction.Transaction;
import com.techtrek.customerservice.transaction.TransactionCommandRepo;
import com.techtrek.customerservice.transaction.TransactionQueryRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class TransactionAdapter implements TransactionCommandRepo, TransactionQueryRepo {

    private TransactionRepository transactionRepository;

    @Override
    public void addTransaction(Transaction transaction) {
        transactionRepository.save(mapToTransactionEntity(transaction));
    }

    @Override
    public List<Transaction> getCustomerTransaction(String customerId) {
        List<TransactionEntity> transactionEntities = transactionRepository.findAll();

        return transactionEntities.stream()
                .filter(transactionEntity ->
                        transactionEntity.getCustomerId().equals(customerId))
                .map(this::mapToTransaction)
                .collect(Collectors.toList());
    }

    private Transaction mapToTransaction(TransactionEntity transactionEntity){
        return Transaction.builder()
                .amount(transactionEntity.getAmount())
                .fromAccountId(transactionEntity.getFromAccountId())
                .toAccountId(transactionEntity.getToAccountId())
                .transactionId(transactionEntity.getTransactionId())
                .customerId(transactionEntity.getCustomerId())
                .localDateTime(transactionEntity.getLocalDateTime())
                .build();
    }

    private TransactionEntity mapToTransactionEntity(Transaction transaction){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAmount(transaction.getAmount());
        transactionEntity.setFromAccountId(transaction.getFromAccountId());
        transactionEntity.setToAccountId(transaction.getToAccountId());
        transactionEntity.setTransactionId(transaction.getTransactionId());
        transactionEntity.setCustomerId(transaction.getCustomerId());
        transactionEntity.setLocalDateTime(transaction.getLocalDateTime());
        transactionEntity.setAuthenticationId(authentication.getName());
        return transactionEntity;
    }
}

package com.techtrek.customerservice.test_data_provider;

import com.techtrek.customerservice.transaction.Transaction;
import com.techtrek.customerservice.transaction_adapter.TransactionEntity;

import java.time.LocalDateTime;
import java.util.List;

public class TransactionDataProvider {

    public static final String CUSTOMER_ID = "customerId";
    private static final LocalDateTime LOCAL_DATE_TIME = LocalDateTime.now();

    public static Transaction buildTransaction(){
        return buildTransaction(CUSTOMER_ID);
    }

    public static TransactionEntity buildTransactionEntity(){
        return buildTransactionEntity(CUSTOMER_ID);
    }

    public static List<TransactionEntity> buildTransactionEntityList(){
        return List.of(
                buildTransactionEntity(CUSTOMER_ID),
                buildTransactionEntity("customerId2"),
                buildTransactionEntity(CUSTOMER_ID),
                buildTransactionEntity("customerId2"),
                buildTransactionEntity("customerId2")
        );
    }

    public static List<Transaction> buildTransactionList(){
        return List.of(
                buildTransaction(CUSTOMER_ID),
                buildTransaction("customerId2"),
                buildTransaction(CUSTOMER_ID),
                buildTransaction("customerId2"),
                buildTransaction("customerId2")
        );
    }

    private static TransactionEntity buildTransactionEntity(String customerId){
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setAuthenticationId("Smit");
        transactionEntity.setCustomerId(customerId);
        transactionEntity.setLocalDateTime(LOCAL_DATE_TIME);
        transactionEntity.setAmount(100.0);
        transactionEntity.setFromAccountId("fromaccountId");
        transactionEntity.setToAccountId("accountId");
        transactionEntity.setTransactionId("transactionId");

        return transactionEntity;
    }

    private static Transaction buildTransaction(String customerId){
        return Transaction.builder()
                .customerId(customerId)
                .localDateTime(LOCAL_DATE_TIME)
                .transactionId("transactionId")
                .toAccountId("accountId")
                .fromAccountId("fromaccountId")
                .amount(100.0)
                .build();
    }
}

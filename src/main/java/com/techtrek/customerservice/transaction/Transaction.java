package com.techtrek.customerservice.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private String transactionId;
    private String customerId;
    private String toAccountId;
    private String fromAccountId;
    private double amount;
    private LocalDateTime localDateTime;

    public void setLocalDateTime(){
        this.localDateTime = LocalDateTime.now();
    }

    public void setTransactionId(){
        this.transactionId = UUID.randomUUID().toString();
    }
}

package com.techtrek.customerservice.transaction_adapter;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table
public class TransactionEntity {
    @Id
    private String transactionId;
    private String customerId;
    private String toAccountId;
    private String fromAccountId;
    private double amount;
    private LocalDateTime localDateTime;
    //Who added the Transaction
    private String authenticationId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionEntity that = (TransactionEntity) o;

        if (Double.compare(that.amount, amount) != 0) return false;
        if (!transactionId.equals(that.transactionId)) return false;
        if (!customerId.equals(that.customerId)) return false;
        if (!toAccountId.equals(that.toAccountId)) return false;
        if (!fromAccountId.equals(that.fromAccountId)) return false;
        if (!localDateTime.equals(that.localDateTime)) return false;
        return authenticationId.equals(that.authenticationId);
    }
}

package com.techtrek.customerservice.transaction_resource;

import com.techtrek.customerservice.transaction.Transaction;
import com.techtrek.customerservice.transaction.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("transaction")
public class TransactionController {
    private TransactionService transactionService;

    @GetMapping("/customer/{customerId}")
    @PreAuthorize("hasAuthority('transaction:read')")
    public List<Transaction> getCustomerTransactions(@PathVariable String customerId){
        return transactionService.getTransaction(customerId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('transaction:write')")
    public void addTransaction(@RequestBody Transaction transaction) {
        transactionService.addTransaction(transaction);
    }
}

package com.techtrek.customerservice.config;

import com.techtrek.customerservice.customer.CustomerProfileService;
import com.techtrek.customerservice.customer.CustomerProfileServiceAdapter;
import com.techtrek.customerservice.transaction.TransactionService;
import com.techtrek.customerservice.transaction.TransactionServiceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutoBeanConfig {

    @Bean
    public TransactionService getTransactionService(){
        return new TransactionServiceAdapter();
    }

    @Bean
    public CustomerProfileService getCustomerProfileService(){
        return new CustomerProfileServiceAdapter();
    }
}

package com.techtrek.customerservice.config;

import com.techtrek.customerservice.customer.CustomerCommandRepo;
import com.techtrek.customerservice.customer.CustomerProfileService;
import com.techtrek.customerservice.customer.CustomerProfileServiceAdapter;
import com.techtrek.customerservice.customer.CustomerQueryRepo;
import com.techtrek.customerservice.participant.*;
import com.techtrek.customerservice.participant_adapter.PasswordAdapter;
import com.techtrek.customerservice.transaction.TransactionCommandRepo;
import com.techtrek.customerservice.transaction.TransactionQueryRepo;
import com.techtrek.customerservice.transaction.TransactionService;
import com.techtrek.customerservice.transaction.TransactionServiceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AutoBeanConfig {

    @Bean
    public TransactionService getTransactionService(TransactionQueryRepo queryRepo, TransactionCommandRepo transactionCommandRepo){
        return new TransactionServiceAdapter(transactionCommandRepo, queryRepo);
    }

    @Bean
    public CustomerProfileService getCustomerProfileService(CustomerQueryRepo customerQueryRepo, CustomerCommandRepo customerCommandRepo){
        return new CustomerProfileServiceAdapter(customerCommandRepo,customerQueryRepo);
    }

    @Bean
    public PasswordService getPasswordService(PasswordEncoder passwordEncoder){
        return new PasswordAdapter(passwordEncoder);
    }

    @Bean
    public ParticipantService getParticipantService(PasswordService passwordService, ParticipantCommandRepo participantCommandRepo, ParticipantQueryRepo participantQueryRepo){
        return new ParticipantServiceAdapter(passwordService, participantCommandRepo, participantQueryRepo);
    }
}

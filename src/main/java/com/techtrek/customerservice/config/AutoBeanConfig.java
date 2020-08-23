package com.techtrek.customerservice.config;

import com.techtrek.customerservice.customer.CustomerProfileService;
import com.techtrek.customerservice.customer.CustomerProfileServiceAdapter;
import com.techtrek.customerservice.participant.ParticipantService;
import com.techtrek.customerservice.participant.ParticipantServiceAdapter;
import com.techtrek.customerservice.participant.PasswordService;
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
    public CustomerProfileService getCustomerProfileService(){
        return new CustomerProfileServiceAdapter();
    }

    @Bean
    public PasswordService getPasswordService(PasswordEncoder passwordEncoder){
        return new PasswordAdapter(passwordEncoder);
    }

    @Bean
    public ParticipantService getParticipantService(PasswordService passwordService){
        return new ParticipantServiceAdapter(passwordService);
    }
}

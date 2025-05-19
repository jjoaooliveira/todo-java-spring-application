package com.jjoaooliveira.todoapplication.account.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jjoaooliveira.todoapplication.account.usecase.IAccountDataGateway;
import com.jjoaooliveira.todoapplication.account.usecase.IPasswordEncoderAdapter;
import com.jjoaooliveira.todoapplication.account.usecase.user.AccountUsecaseFactory;
import com.jjoaooliveira.todoapplication.account.usecase.user.IChangePassword;
import com.jjoaooliveira.todoapplication.account.usecase.user.ICreateAccount;
import com.jjoaooliveira.todoapplication.account.usecase.user.IReadAccount;

@Configuration
public class AccountUsecaseConfiguration {
    
    @Bean
    AccountUsecaseFactory accountUsecaseFactory(
        IPasswordEncoderAdapter passwordEncoderAdapter, 
        IAccountDataGateway accountDataGateway
    ) {
        return new AccountUsecaseFactory(passwordEncoderAdapter, accountDataGateway);
    }

    @Bean
    ICreateAccount createAccountUsecase(
        AccountUsecaseFactory factory
    ) {
        return factory.getCreateAccountUsecase();
    }

    @Bean
    IChangePassword changePasswordUsecase(
        AccountUsecaseFactory factory
    ) {
        return factory.getChangePasswordUsecase();
    }

    @Bean
    IReadAccount readAccountUsecase(
        AccountUsecaseFactory factory
    ) {
        return factory.getReadAccountUsecase();
    }

}

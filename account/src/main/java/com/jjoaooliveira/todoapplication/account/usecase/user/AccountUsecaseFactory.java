package com.jjoaooliveira.todoapplication.account.usecase.user;

import com.jjoaooliveira.todoapplication.account.usecase.IAccountDataGateway;
import com.jjoaooliveira.todoapplication.account.usecase.IPasswordEncoderAdapter;

public class AccountUsecaseFactory {

    private final IPasswordEncoderAdapter passwordEncoderAdapter;
    private final IAccountDataGateway accountDataGateway;

    public AccountUsecaseFactory(
            IPasswordEncoderAdapter passwordEncoderAdapter, 
            IAccountDataGateway accountDataGateway
    ) {
        this.passwordEncoderAdapter = passwordEncoderAdapter;
        this.accountDataGateway = accountDataGateway;
    }

    public ICreateAccount getCreateAccountUsecase() {
        return new CreateAccountImpl(accountDataGateway, passwordEncoderAdapter);
    }

    public IChangePassword getChangePasswordUsecase() {
        return new ChangePasswordImpl(accountDataGateway, passwordEncoderAdapter);
    }

    public IReadAccount getReadAccountUsecase() {
        return new ReadAccountImpl(accountDataGateway);
    }
}

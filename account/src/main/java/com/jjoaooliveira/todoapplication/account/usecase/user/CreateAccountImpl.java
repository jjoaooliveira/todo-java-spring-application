package com.jjoaooliveira.todoapplication.account.usecase.user;

import com.jjoaooliveira.todoapplication.account.entity.Account;
import com.jjoaooliveira.todoapplication.account.usecase.AccountInputData;
import com.jjoaooliveira.todoapplication.account.usecase.IAccountDataGateway;
import com.jjoaooliveira.todoapplication.account.usecase.IPasswordEncoderAdapter;

class CreateAccountImpl implements ICreateAccount {
    private final IAccountDataGateway userDataGateway;
    private final IPasswordEncoderAdapter passwordEncoder;

    public CreateAccountImpl(IAccountDataGateway userDataGateway, IPasswordEncoderAdapter passwordEncoder) {
        this.userDataGateway = userDataGateway;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Account createAccount(AccountInputData accountInputData) {
        Account user = new Account( 
            accountInputData.getName(), 
            accountInputData.getEmail(), 
            passwordEncoder.encode(accountInputData.getPassword())
        );

        return userDataGateway.saveAccount(user);
    }

}

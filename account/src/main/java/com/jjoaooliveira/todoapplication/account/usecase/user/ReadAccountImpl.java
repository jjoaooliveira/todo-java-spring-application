package com.jjoaooliveira.todoapplication.account.usecase.user;

import com.jjoaooliveira.todoapplication.account.entity.Account;
import com.jjoaooliveira.todoapplication.account.usecase.AccountOutputData;

public class ReadAccountImpl implements IReadAccount {

    private final IReadAccountDataGateway dataGateway;

    public ReadAccountImpl(IReadAccountDataGateway dataGateway) {
        this.dataGateway = dataGateway;
    }

    @Override
    public AccountOutputData readAccount(String email) {
        Account returnedAccount = dataGateway.read(email);
        
        return new AccountOutputData(
            returnedAccount.getEmail(), 
            returnedAccount.getName()
        );
    }

}

package com.jjoaooliveira.todoapplication.account.usecase.user;

import com.jjoaooliveira.todoapplication.account.usecase.exception.AccountNotFoundException;

import com.jjoaooliveira.todoapplication.account.entity.Account;
import com.jjoaooliveira.todoapplication.account.usecase.AccountInputData;
import com.jjoaooliveira.todoapplication.account.usecase.AccountOutputData;
import com.jjoaooliveira.todoapplication.account.usecase.IAccountDataGateway;

public class ReadAccountImpl implements IReadAccount {

    private final IAccountDataGateway dataGateway;

    public ReadAccountImpl(IAccountDataGateway dataGateway) {
        this.dataGateway = dataGateway;
    }

    @Override
    public AccountOutputData readAccount(AccountInputData accountInputData) {
        Account returnedAccount = dataGateway.getAccountByEmail(accountInputData.getEmail())
            .orElseThrow(() -> new AccountNotFoundException("Account not found"));
        
        return new AccountOutputData(
            returnedAccount.getEmail(), 
            returnedAccount.getName()
        );
    }
}

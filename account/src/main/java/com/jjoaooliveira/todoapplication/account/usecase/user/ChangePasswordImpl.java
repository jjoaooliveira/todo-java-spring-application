package com.jjoaooliveira.todoapplication.account.usecase.user;

import com.jjoaooliveira.todoapplication.account.entity.Account;
import com.jjoaooliveira.todoapplication.account.usecase.AccountInputData;
import com.jjoaooliveira.todoapplication.account.usecase.IAccountDataGateway;
import com.jjoaooliveira.todoapplication.account.usecase.IPasswordEncoderAdapter;

public class ChangePasswordImpl implements IChangePassword {

    private final IAccountDataGateway dataGateway;
    private final IPasswordEncoderAdapter passwordEncoder;

    public ChangePasswordImpl(IAccountDataGateway dataGateway, IPasswordEncoderAdapter passwordEncoder) {
        this.dataGateway = dataGateway;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void changePassword(AccountInputData accountInputData) {
        Account account = dataGateway.getAccountByEmail(accountInputData.getEmail())
            .orElseThrow(() -> new RuntimeException("Account not found"));
        
        account.setPassword(passwordEncoder.encode(accountInputData.getNewPassword()));
        dataGateway.saveAccount(account);
    }
}

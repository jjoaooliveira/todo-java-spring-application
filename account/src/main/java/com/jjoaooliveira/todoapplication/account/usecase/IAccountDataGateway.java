package com.jjoaooliveira.todoapplication.account.usecase;

import java.util.Optional;

import com.jjoaooliveira.todoapplication.account.entity.Account;

public interface IAccountDataGateway {
    Account saveAccount(Account account);
    Optional<Account> getAccountByEmail(String email);
}

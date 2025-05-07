package com.jjoaooliveira.todoapplication.account.usecase;

import com.jjoaooliveira.todoapplication.account.entity.Account;

public interface IAccountDataGateway {
    Account saveAccount(Account account);
}

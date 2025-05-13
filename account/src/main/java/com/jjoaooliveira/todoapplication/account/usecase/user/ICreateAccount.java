package com.jjoaooliveira.todoapplication.account.usecase.user;

import com.jjoaooliveira.todoapplication.account.usecase.AccountInputData;
import com.jjoaooliveira.todoapplication.account.usecase.AccountOutputData;

public interface ICreateAccount {
    AccountOutputData createAccount(AccountInputData accountInputData);
}

package com.jjoaooliveira.todoapplication.account.usecase.user;

import com.jjoaooliveira.todoapplication.account.usecase.AccountInputData;
import com.jjoaooliveira.todoapplication.account.usecase.AccountOutputData;

public interface IReadAccount {
    AccountOutputData readAccount(AccountInputData accountInputData);
}

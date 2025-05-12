package com.jjoaooliveira.todoapplication.account.usecase.user;

import com.jjoaooliveira.todoapplication.account.entity.Account;

public interface IReadAccountDataGateway {
    Account read(String email);
}

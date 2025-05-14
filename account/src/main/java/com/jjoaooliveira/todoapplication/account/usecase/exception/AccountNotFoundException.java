package com.jjoaooliveira.todoapplication.account.usecase.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String message) {
        super(message);
    }
}

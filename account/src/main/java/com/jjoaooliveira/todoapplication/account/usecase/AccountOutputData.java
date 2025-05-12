package com.jjoaooliveira.todoapplication.account.usecase;

public class AccountOutputData {
    private String email;
    private String name;

    public AccountOutputData(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}

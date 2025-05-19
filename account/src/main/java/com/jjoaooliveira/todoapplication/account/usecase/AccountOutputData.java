package com.jjoaooliveira.todoapplication.account.usecase;

public class AccountOutputData {
    private String email;
    private String name;

    public AccountOutputData() {
    }

    public AccountOutputData(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}

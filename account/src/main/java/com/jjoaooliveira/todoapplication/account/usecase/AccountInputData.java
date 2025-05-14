package com.jjoaooliveira.todoapplication.account.usecase;

import java.util.UUID;

public class AccountInputData {
    private UUID id;
    private String name;
    private String email;
    private String password;
    private String newPassword;

    public AccountInputData(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public AccountInputData(String email, String newPassword) {
        this.email = email;
        this.newPassword = newPassword;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNewPassword() {
        return this.newPassword;
    }
}

package com.jjoaooliveira.todoapplication.account.usecase;

import java.util.UUID;

public class AccountInputData {
    private UUID id;
    private String name;
    private String email;
    private String password;
    private String newPassword;

    public AccountInputData(UUID id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public AccountInputData(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public AccountInputData(String name, String email, String password, String newPassword) {
        this.name = name;
        this.email = email;
        this.password = password;
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

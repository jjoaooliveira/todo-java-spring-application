package com.jjoaooliveira.todoapplication.account.usecase;

public interface IPasswordEncoderAdapter {
    String encode(String rawPassword);
    boolean matches(String rawPassword, String encodedPassword);
}

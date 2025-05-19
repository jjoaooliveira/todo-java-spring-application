package com.jjoaooliveira.todoapplication.account.securityadapter;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.jjoaooliveira.todoapplication.account.usecase.IPasswordEncoderAdapter;

public class PasswordEncoderAdapter implements IPasswordEncoderAdapter {
    
    private final PasswordEncoder passwordEncoder;

    public PasswordEncoderAdapter(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String encode(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    @Override
    public boolean matches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}

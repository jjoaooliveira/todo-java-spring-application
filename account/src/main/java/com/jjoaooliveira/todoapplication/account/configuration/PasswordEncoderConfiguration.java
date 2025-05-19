package com.jjoaooliveira.todoapplication.account.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jjoaooliveira.todoapplication.account.securityadapter.PasswordEncoderAdapter;
import com.jjoaooliveira.todoapplication.account.usecase.IPasswordEncoderAdapter;

@Configuration
public class PasswordEncoderConfiguration {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    IPasswordEncoderAdapter passwordEncoderAdapter(PasswordEncoder passwordEncoder) {
        return new PasswordEncoderAdapter(passwordEncoder);
    }
}

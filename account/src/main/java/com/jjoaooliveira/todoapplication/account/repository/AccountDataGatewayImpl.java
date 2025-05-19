package com.jjoaooliveira.todoapplication.account.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.jjoaooliveira.todoapplication.account.entity.Account;
import com.jjoaooliveira.todoapplication.account.entity.Role;
import com.jjoaooliveira.todoapplication.account.usecase.IAccountDataGateway;

@Component
class AccountDataGatewayImpl implements IAccountDataGateway {
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;

    public AccountDataGatewayImpl(
        AccountRepository accountRepository, 
        RoleRepository roleRepository
    ) {
        this.accountRepository = accountRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public Account saveAccount(Account account) {
        List<RoleEntity> roles = account.getRoles().stream()
                .map(role -> {
                    RoleEntity roleEntity = roleRepository.findByRole(role)
                    .orElseThrow(() -> new IllegalArgumentException("Role not found: " + role.name()));
                    
                    return roleEntity;
                })
                .toList();

        AccountEntity accountEntity = new AccountEntity(
            account.getId(),
            account.getName(),
            account.getEmail(), 
            account.getPassword(),
            roles,
            account.getEnabled()
        );

        AccountEntity savedAccountEntity = accountRepository.save(accountEntity);
        
        return new Account(
            savedAccountEntity.getId(),
            savedAccountEntity.getName(),
            savedAccountEntity.getEmail(),
            savedAccountEntity.getPassword(),
            savedAccountEntity.getRoles()
                .stream()
                .map(roleEntity -> Role.valueOf(roleEntity.getRole()))
                .toList(),
            savedAccountEntity.getEnabled()
        );
    }

    @Override
    public Optional<Account> getAccountByEmail(String email) {
        AccountEntity entity = accountRepository.findByEmail(email).orElse(null);

        Optional<Account> queriedAccount = Optional.ofNullable(entity)
            .map(e -> new Account(
                e.getId(),
                e.getName(),
                e.getEmail(),
                e.getPassword(),
                e.getRoles()
                    .stream()
                    .map(roleEntity -> Role.valueOf(roleEntity.getRole()))
                    .toList(),
                e.getEnabled()
            )); 

        return queriedAccount;
    }    
}

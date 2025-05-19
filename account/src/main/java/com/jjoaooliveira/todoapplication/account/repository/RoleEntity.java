package com.jjoaooliveira.todoapplication.account.repository;

import java.util.List;
import java.util.UUID;

import com.jjoaooliveira.todoapplication.account.entity.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class RoleEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToMany(mappedBy = "roles")
    private List<AccountEntity> account;

    public RoleEntity() {}
    
    public RoleEntity(UUID id, Role role) {
        this.id = id;
        this.role = role;
    }

    public RoleEntity(Role role) {
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public String getRole() {
        return role.name();
    }
}

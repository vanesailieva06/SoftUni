package com.example.demo.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class UserRole extends BaseEntity {
    private Role role;

    public UserRole() {
    }

    @Enumerated(EnumType.STRING)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

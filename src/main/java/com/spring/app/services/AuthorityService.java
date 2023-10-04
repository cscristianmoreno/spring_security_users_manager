package com.spring.app.services;

import org.springframework.security.core.GrantedAuthority;

import com.spring.app.models.Authority;

public class AuthorityService implements GrantedAuthority {

    private final Authority authority;

    public AuthorityService(Authority authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority.getRoles().toString();
    }
}

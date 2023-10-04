package com.spring.app.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.spring.app.models.Authority;
import com.spring.app.models.Users;
import com.spring.app.services.AuthorityService;

public class UserManager implements UserDetails {

    private final Users users;

    public UserManager(final Users users) {
        this.users = users;
    }

    @Override
    public String getUsername() {
        return this.users.getUsername();
    }

    @Override
    public String getPassword() {
        return this.users.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {        

        List<AuthorityService> listAuthority = new ArrayList<AuthorityService>();

        for (Authority role: this.users.getAuthority()) {
            AuthorityService authorityService = new AuthorityService(role);
            listAuthority.add(authorityService);
        }

        return listAuthority;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

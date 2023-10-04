package com.spring.app.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.app.dto.UserDTO;
import com.spring.app.manager.UserManager;
import com.spring.app.models.Users;

@Service
public class UserService implements UserDetailsService {

    private final UserDTO userDTO;

    public UserService(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users =  this.userDTO.findByUsername(username);

        if (users == null) {
            return null;
        }

        return new UserManager(users);
    }
    
}

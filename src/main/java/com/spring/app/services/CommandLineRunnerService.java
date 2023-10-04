package com.spring.app.services;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.spring.app.dto.AuthorityDTO;
import com.spring.app.dto.UserDTO;
import com.spring.app.models.Authority;
import com.spring.app.models.Users;
import com.spring.app.roles.Roles;

@Service
public class CommandLineRunnerService implements CommandLineRunner {

    private final AuthorityDTO authorityDTO;
    private final UserDTO userDTO;

    public CommandLineRunnerService(AuthorityDTO authorityDTO, UserDTO userDTO) {
        this.authorityDTO = authorityDTO;
        this.userDTO = userDTO;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.authorityDTO.findByAll().isEmpty()) {
            for (Roles role: Roles.values()) {
                Authority authority = new Authority(role);
                this.authorityDTO.save(authority);
            }
        }

        if (this.userDTO.getAllUsers().isEmpty()) {
            Users users;

            Authority role; 
            role = this.authorityDTO.findByRoles(Roles.ROLE_ADMIN);

            users = new Users();
            users.setUsername("cristian");
            users.setPassword("moreno");
            users.setAuthority(Set.of(role));

            this.userDTO.createUser(users);

            role = this.authorityDTO.findByRoles(Roles.ROLE_USER);

            users = new Users();
            users.setUsername("elias");
            users.setPassword("colque");
            users.setAuthority(Set.of(role));

            this.userDTO.createUser(users);

            role = this.authorityDTO.findByRoles(Roles.ROLE_USER);

            users = new Users();
            users.setUsername("ramiro");
            users.setPassword("farfan");
            users.setAuthority(Set.of(role));

            this.userDTO.createUser(users);
        }
    }
    
}

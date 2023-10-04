package com.spring.app.dto;

import java.util.List;
import java.util.Set;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.spring.app.models.Authority;
import com.spring.app.models.Users;
import com.spring.app.repository.UserRepository;
import com.spring.app.repositoryDTO.UserRepositoryDTO;
import com.spring.app.roles.Roles;

@Repository
public class UserDTO implements UserRepositoryDTO {
    
    private final UserRepository userRepository;
    private final AuthorityDTO authorityDTO;

    public UserDTO(UserRepository userRepository, AuthorityDTO authorityDTO) {
        this.userRepository = userRepository;
        this.authorityDTO = authorityDTO;
    }

    @Override
    public void createUser(Users user) {
        if (user.getAuthority() == null) {
            Authority role = this.authorityDTO.findByRoles(Roles.ROLE_USER);

            Set<Authority> hashSet = Set.of(role);
            user.setAuthority(hashSet);
        }
        
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        this.userRepository.save(user);
    }

    @Override
    public Users findByUsername(String username) {
        Users users = this.userRepository.findByUsername(username);
        return users;
    }

    @Override
    public void deleteUser(int id) {
    }

    @Override
    public List<Users> getAllUsers() {
        return (List<Users>) this.userRepository.findAll();
    }
}

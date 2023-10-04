package com.spring.app.dto;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.app.models.Authority;
import com.spring.app.repository.AuthorityRepository;
import com.spring.app.repositoryDTO.AuthorityRepositoryDTO;
import com.spring.app.roles.Roles;

@Repository
public class AuthorityDTO implements AuthorityRepositoryDTO {

    private final AuthorityRepository authorityRepository;

    public AuthorityDTO(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    @Override
    public void save(Authority authority) {
        this.authorityRepository.save(authority);
    }

    @Override
    public Authority findByRoles(Roles role) {
        return this.authorityRepository.findByRoles(role);
    }

    @Override
    public List<Authority> findByAll() {
        return this.authorityRepository.findAll();
    }
    
}

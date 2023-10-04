package com.spring.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.app.models.Authority;
import com.spring.app.roles.Roles;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
    Authority findByRoles(Roles role);
}

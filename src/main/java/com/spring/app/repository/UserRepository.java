package com.spring.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.app.models.Users;

public interface UserRepository extends CrudRepository<Users, Integer> {
    Users findByUsername(String username);
}

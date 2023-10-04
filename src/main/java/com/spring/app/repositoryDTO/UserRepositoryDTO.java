package com.spring.app.repositoryDTO;

import java.util.List;

import com.spring.app.models.Users;

public interface UserRepositoryDTO {
    void createUser(Users user);

    Users findByUsername(String username);
    
    void deleteUser(int id);

    List<Users> getAllUsers();
}

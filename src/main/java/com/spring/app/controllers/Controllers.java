package com.spring.app.controllers;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.app.dto.UserDTO;
import com.spring.app.models.Users;

@Controller
@ResponseBody
public class Controllers {

    private final UserDTO userDTO;

    public Controllers(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/users")
    public List<Users> getAllUsers() {
        return this.userDTO.getAllUsers();
    }
    
    @PostMapping("/create")
    public String create(@RequestBody Users users) {
        this.userDTO.createUser(users);
        return "Usuario creado!";
    }
}

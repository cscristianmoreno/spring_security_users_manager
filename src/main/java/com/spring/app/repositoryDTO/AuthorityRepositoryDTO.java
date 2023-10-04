package com.spring.app.repositoryDTO;


import java.util.List;

import com.spring.app.models.Authority;
import com.spring.app.roles.Roles;

public interface AuthorityRepositoryDTO {
    void save(Authority authority);
    
    Authority findByRoles(Roles role);

    List<Authority> findByAll();
}

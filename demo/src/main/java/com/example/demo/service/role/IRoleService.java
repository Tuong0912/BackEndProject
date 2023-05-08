package com.example.demo.service.role;


import com.example.demo.model.user.Role;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(Role.RoleType name);
}

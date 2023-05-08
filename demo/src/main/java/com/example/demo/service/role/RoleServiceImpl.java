package com.example.demo.service.role;


import com.example.demo.model.user.Role;
import com.example.demo.repository.role.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(Role.RoleType name) {
        return roleRepository.findByName(name);
    }
}

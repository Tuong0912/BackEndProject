package com.example.demo.service.iplm;

import com.example.demo.model.user.Role;
import com.example.demo.repository.role.IRoleRepository;
import com.example.demo.service.interservice.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository iRoleRepository;

    @Override
    public Iterable<Role> findAll() {
        return iRoleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(Long id) {
        return iRoleRepository.findById(id);
    }

    @Override
    public Role add(Role role) {
        return iRoleRepository.save(role);
    }

    @Override
    public void delete(Long id) {
        iRoleRepository.deleteById(id);
    }
}

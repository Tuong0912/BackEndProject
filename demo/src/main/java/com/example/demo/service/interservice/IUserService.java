package com.example.demo.service.interservice;

import com.example.demo.model.user.User;
import com.example.demo.service.IGeneralService;

import java.util.Optional;

public interface IUserService extends IGeneralService<User> {
    User checkApplication(Long id);
    Optional<User> findByUsername(String user);
}

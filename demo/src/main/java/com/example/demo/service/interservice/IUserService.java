package com.example.demo.service.interservice;

import com.example.demo.model.user.User;
import com.example.demo.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IUserService extends IGeneralService<User> {
    User checkApplication(Long id);

    User findByUsername(String user);

    User findByUserEmail(String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Boolean findByUsernameAndPassword(String username, String password);

    Page<User> findAllUserWhichFalse(Pageable pageable);

    int browseAUser(long id);
}

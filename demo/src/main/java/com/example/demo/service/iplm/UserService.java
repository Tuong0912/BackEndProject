package com.example.demo.service.iplm;

import com.example.demo.model.user.User;
import com.example.demo.repository.user.UserRepository;
import com.example.demo.service.interservice.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User checkApplication(Long id) {
        return this.userRepository.findById(id).get();
    }

    @Override
    public Optional<User> findByUsername(String user) {
        return userRepository.findByUsername(user);
    }

    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Boolean findByUsernameAndPassword(String username, String password) {
        Boolean user = this.userRepository.findByUsernameAndPassword(username, password);
        return user;
    }
}

package com.example.demo.repository.user;

import com.example.demo.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String user);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Boolean findByUsernameAndPassword(String username, String password);
}
